package org.edu.common.page.mybatis;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.edu.common.page.dialect.DialectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class PaginationStatementHandlerInterceptor implements Interceptor {

	private final static Logger logger						 = LoggerFactory.getLogger(PaginationStatementHandlerInterceptor.class);

	private static final ObjectFactory		  DEFAULT_OBJECT_FACTORY		 = new DefaultObjectFactory();
	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
	private static final ReflectorFactory	  DEFAULT_REFLECTOR_FACTORY		 = new DefaultReflectorFactory();

	public Object intercept(Invocation invocation) throws Throwable {
		Object target = invocation.getTarget();

		if (target instanceof StatementHandler) {
			StatementHandler statementHandler = (StatementHandler) target;
			ParameterHandler parameterHandler = statementHandler.getParameterHandler();
			BoundSql boundSql = statementHandler.getBoundSql();

			MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY, DEFAULT_REFLECTOR_FACTORY);

			RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
			if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {// ??????????????????
				return invocation.proceed();
			}

			Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
            org.edu.common.page.dialect.Dialect dialect = DialectFactory.buildDialect(configuration);

			String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");

			Page<?> page = (Page<?>) rowBounds;
			int offset = page.getOffset();
			int limit = page.getLimit();
			if (PageConstant.NOT_PAGING < offset && PageConstant.NOT_PAGING < limit) {
				String countSql = dialect.getCountString(originalSql);
				Connection connection = (Connection) invocation.getArgs()[0];
				int total = getTotal(parameterHandler, connection, countSql);
				page.setTotalCount(total);
				// ????????????????????????
				metaStatementHandler.setValue("delegate.boundSql.sql", dialect.getLimitString(originalSql, page.getOffset(), page.getLimit()));
			}
			// ??????mybatis????????????
			metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
			metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);

			if (logger.isDebugEnabled()) {
				logger.debug("??????SQL : " + boundSql.getSql());
			}

		}

		return invocation.proceed();
	}

	/** ???????????????
	 * 
	 * @param parameterHandler
	 * @param connection
	 * @param countSql
	 * @return
	 * @throws Exception */
	private int getTotal(ParameterHandler parameterHandler, Connection connection, String countSql) throws Exception {
		// TODO ??????????????????SQL????????????????????????
		PreparedStatement prepareStatement = connection.prepareStatement(countSql);
		parameterHandler.setParameters(prepareStatement);
		ResultSet rs = prepareStatement.executeQuery();
		int count = 0;
		if (rs.next()) {
			count = rs.getInt(1);
		}
		rs.close();
		prepareStatement.close();

		return count;
	}

	public Object plugin(Object target) {
		if (target instanceof StatementHandler) {
			return Plugin.wrap(target, this);
		}
		return target;
	}

	public void setProperties(Properties arg0) {

	}

}
