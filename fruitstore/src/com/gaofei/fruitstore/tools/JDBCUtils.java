package com.gaofei.fruitstore.tools;

import java.sql.*;

/*
/       工具类
 */

public class JDBCUtils {
    //加载驱动连接数据库
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/girls?characterEncoding=utf8","root","root");
        return conn;
    }

    //关闭数据库，释放资源
    public static void realse(Statement stmt,Connection conn){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static void realse(ResultSet rs,Statement stmt,Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }

        realse(stmt,conn);
    }

}
