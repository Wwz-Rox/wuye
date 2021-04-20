package org.edu.common.page.dialect;

public class OracleDialect extends Dialect {

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		return OraclePageHepler.getLimitString(sql, offset, limit);
	}

	@Override
	public String getCountString(String sql) {
		return OraclePageHepler.getCountString(sql);
	}
}
