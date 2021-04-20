package org.edu.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class SqlHelp {
	private static Properties properties=new Properties();
	static ThreadLocal<Connection> local=new ThreadLocal<Connection>();
	/*
	 * 静态快加载驱动  (类加载时就要调用 只调用一次)
	 */
	static {
		try {
			properties.load(SqlHelp.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			System.out.println("连接正常");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("连接失败");
		}
	}
	static {
		try {
			Class.forName(properties.getProperty("Driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 定义一个建立连接类
	 */
	public static Connection openConnection() {
		Connection conn=local.get();
		try {
			if(conn==null||conn.isClosed()) {
				conn=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
				local.set(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/*
	 * 查询
	 */
	public static ResultSet select(String sql ,Object ...params) {
		Connection conn=SqlHelp.openConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			if(params!=null) {
				for(int i=0;i<params.length;i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/*
	 * 查询  用hashmap
	 */
	public static List<HashMap<String,Object>> select3(String sql,Object ...params){
		Connection conn=SqlHelp.openConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<HashMap<String,Object>> rows=new ArrayList<HashMap<String,Object>>();
		try {
			ps=conn.prepareStatement(sql);
			if(params!=null) {
				for(int i=0;i<params.length;i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			rs=ps.executeQuery();//获得结果集
			ResultSetMetaData rsd=rs.getMetaData();//获得列头源数据
			int length=rsd.getColumnCount();//获得 列数
			while(rs.next()) {//循环行
				HashMap<String, Object> map=new HashMap<String, Object>();//循环一次创建一次
				for(int i=0;i<length;i++) {//循环列
					String columnLabel=rsd.getColumnLabel(i+1);//得到列名
					map.put(columnLabel, rs.getObject(columnLabel));//赋值
				}
				rows.add(map);//添加到list中
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return rows;

	}
	/*
	 * 查询 用  List
	 */
	public static <T> List<T> select2(String sql,Row<T> row,Object ...params){

		Connection conn=SqlHelp.openConnection();
		List<T> list=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			if(params!=null) {
				for(int i=0;i<params.length;i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			rs=ps.executeQuery();
			list=row.maping(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;

	}
	/*
	 * 增删改
	 */
	public static int update(String sql ,Object ...params) {
		Connection conn=SqlHelp.openConnection();
		PreparedStatement ps=null;
		int j=0;
		try {
			ps=conn.prepareStatement(sql);
			if(params!=null) {
				for(int i=0;i<params.length;i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			j=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	/*
	 * 关闭
	 */
	public static void close() {
		Connection conn=local.get();
		if(conn!=null) {
			try {
				conn.close();
				local.remove();
				conn=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static interface Row<T> {
		public List<T> maping(ResultSet rs);
	}
}