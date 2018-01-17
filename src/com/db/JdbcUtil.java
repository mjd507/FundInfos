package com.db;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
    private static JdbcUtil mJdbcUtil = null;
    private ComboPooledDataSource dataSource;

    private JdbcUtil() {
        //读取c3p0默认配置文件
        dataSource = new ComboPooledDataSource();
    }

    public static JdbcUtil getInstance() {
        if (mJdbcUtil == null) {
            synchronized (JdbcUtil.class) {
                if (mJdbcUtil == null) {
                    mJdbcUtil = new JdbcUtil();
                }
            }
        }
        return mJdbcUtil;
    }


    public Connection getConn() throws SQLException {
        return dataSource.getConnection();
    }

    public void closeConn(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (ps != null) {
                ps.close();
            }

            if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
