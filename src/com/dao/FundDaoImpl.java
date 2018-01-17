package com.dao;

import com.beans.FundInfoAll;
import com.db.JdbcUtil;
import com.utils.DateUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FundDaoImpl implements IFundDao {

    private final JdbcUtil jdbcUtil;
    private final String COLUMN_FUND_DATE = "fundDate";
    private final String COLUMN_FUND_INFO = "fundInfo";

    public FundDaoImpl() {
        jdbcUtil = JdbcUtil.getInstance();
    }

    @Override
    public ArrayList<FundInfoAll> getHistoryFundInfo(String tableName) {
        ArrayList<FundInfoAll> infos = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = jdbcUtil.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                FundInfoAll all = new FundInfoAll();
                String fundDate = rs.getString("fundDate");
                String fundInfo = rs.getString("fundInfo");
                all.setFundDate(fundDate);
                all.setFundInfo(fundInfo);
                infos.add(all);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.closeConn(conn, ps, rs);
        }

        return infos;
    }

    @Override
    public boolean hasDayFundInfo(String tableName, String date) {
        String sql = "SELECT * FROM " + tableName + " WHERE " + COLUMN_FUND_DATE + " = " + date;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = jdbcUtil.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            jdbcUtil.closeConn(conn, ps, rs);
        }

    }

    @Override
    public boolean addFundInfo(String tableName, String values) {
        String todayStr = DateUtils.getTodayStr();
        if (hasDayFundInfo(tableName, todayStr)) {
            return updateFundInfo(tableName, values);
        }
        String sql = "INSERT INTO " + tableName + " VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = jdbcUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, todayStr);
            ps.setString(2, values);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            jdbcUtil.closeConn(conn, ps, null);
        }

    }

    @Override
    public boolean updateFundInfo(String tableName, String values) {
        String todayStr = DateUtils.getTodayStr();
        if (!hasDayFundInfo(tableName, todayStr)) {
            return addFundInfo(tableName, values);
        }
        String sql = "UPDATE " + tableName + " SET " + COLUMN_FUND_INFO + " = " + values
                + " WHERE " + COLUMN_FUND_DATE + " = " + todayStr;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = jdbcUtil.getConn();
            ps = conn.prepareStatement(sql);
            int rows = ps.executeUpdate();

            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            jdbcUtil.closeConn(conn, ps, null);
        }

    }

}
