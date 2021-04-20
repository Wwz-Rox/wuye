package org.edu.util;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;


public class SqlUtil {

    private static Properties properties=new Properties();


    static ThreadLocal<Connection> local=new ThreadLocal<Connection>();


    static{
        try {
            properties.load(SqlUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    static{
        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static Connection opencon(){
        Connection conn=local.get();
        try {
            if(conn==null||conn.isClosed()){
                conn=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
                local.set(conn);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }


    public static ResultSet  select(String sql,Object ...params ){
        Connection conn=SqlUtil.opencon();
        ResultSet rs=null;
        PreparedStatement  pst=null;
        try {
            pst = conn.prepareStatement(sql);
            if(params!=null){
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i+1,params[i]);
                }
            }
            rs=pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return rs;

    }


    public static <T> List<T>  select1(String sql,RowHandlerMapper<T> handlerMapper,Object ...params ){
        Connection conn=SqlUtil.opencon();
        ResultSet rs=null;
        PreparedStatement  pst=null;
        List<T> rows=null;
        try {
            pst = conn.prepareStatement(sql);
            if(params!=null){
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i+1,params[i]);
                }
            }
            rs=pst.executeQuery();

            rows=handlerMapper.mapper(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(pst!=null){
                try {
                    pst.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return rows;

    }

    public static  List<HashMap<String, Object>>  select2(String sql,Object ...params ){
        Connection conn=SqlUtil.opencon();
        ResultSet rs=null;
        PreparedStatement  pst=null;
        List<HashMap<String, Object>> rows=new ArrayList<HashMap<String,Object>>();
        try {
            pst = conn.prepareStatement(sql);
            if(params!=null){
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i+1,params[i]);
                }
            }
            rs=pst.executeQuery();
             java.sql.ResultSetMetaData tt = rs.getMetaData();
             while(rs.next()){
                 HashMap<String, Object> map=new HashMap<String, Object>();
                 for(int i=1;i<=tt.getColumnCount();i++){
                     String str=tt.getColumnLabel(i);
                     map.put(str, rs.getObject(str));
                 }
                 rows.add(map);

             }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(pst!=null){
                try {
                    pst.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return rows;

    }

    public static int updata(String sql,Object ...params){
        Connection conn=SqlUtil.opencon();
        int is=0;
        PreparedStatement  pst=null;
        try {
            pst = conn.prepareStatement(sql);
            if(params!=null){
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i+1,params[i]);
                }
            }
            is=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            if(pst!=null){
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return is;
    }

    public static void close(){

        if(local.get()!=null){
            try {
                local.remove();
                local.get().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static interface RowHandlerMapper<T>{
        public List<T> mapper(ResultSet res);
    }

}

