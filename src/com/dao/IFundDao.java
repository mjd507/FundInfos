package com.dao;

import com.beans.FundInfoAll;

import java.util.ArrayList;

public interface IFundDao {
    ArrayList<FundInfoAll> getHistoryFundInfo(String tableName);

    boolean hasDayFundInfo(String tableName, String date);

    boolean addFundInfo(String tableName, String values);

    boolean updateFundInfo(String tableName, String values);
}
