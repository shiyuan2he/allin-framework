package org.hsy.util;

import java.sql.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path framework/com.hsy.util
 * @date 2017/7/15 下午5:39
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class DBUtils {
    public static Connection getConnetction() {
        Connection conn = null;
        String user   = "root";
        String passwd = "htbuy@2016";
        String url = "jdbc:mariadb://192.168.6.101:3306/test_shopping";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(url,user,passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeResource(PreparedStatement pstmt, Connection conn) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void closeResource(PreparedStatement pstmt, ResultSet rs, Connection conn) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            if (rs != null ) {
                rs.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
