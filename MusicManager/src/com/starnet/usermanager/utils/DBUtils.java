package com.starnet.usermanager.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private static DBUtils dbUtils=new DBUtils();
    private static String dbUrl;
//    private String url = "jdbc:mysql://localhost:3306/user_manager";
//    // jdbc协议:数据库子协议:主机:端口/连接的数据库   //
//
//    private String user = "root";//用户�?
//    private String password = "123";//密码
    public static DBUtils genInstance(){
        return dbUtils;
    }
    private void init(){
        Properties p=new Properties();
        try {
            p.load(this.getClass().getResourceAsStream("/dbConn.props"));
            String dbDriver=p.getProperty("db.driver");
            Class.forName("com.mysql.jdbc.Driver");
            DBUtils.dbUrl=p.getProperty("db.url");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public Connection getConn() {

        try {
//            Driver driver = new com.mysql.jdbc.Driver();
//            Properties props=new Properties();
//
//            props.setProperty("user", user);
//            props.setProperty("password", password);
//            Connection conn=driver.connect(url,props);
//            return conn;
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(dbUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }
    public void releaseAll(Connection conn, PreparedStatement pstm, ResultSet rs)
    {
        if (rs!=null)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (pstm!=null)
            {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null)
            {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
