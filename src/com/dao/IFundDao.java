package com.dao;

import com.beans.FundInfoAll;

import java.util.ArrayList;

public interface IFundDao {
    String TABLE_A_NIU = "aniu";
    String TABLE_QIE_MAN = "qieman";
    String TABLE_ZHI_SHU_VALUE = "zhushuvalue";

    String COLUMN_FUND_DATE = "fundDate";
    String COLUMN_FUND_INFO = "fundInfo";

    ArrayList<FundInfoAll> getHistoryFundInfoFromAniu();

    ArrayList<FundInfoAll> getHistoryFundInfoFromQieMan();

    ArrayList<FundInfoAll> getHistoryFundInfoFromZhiShuValue();

    boolean addFundInfoFromAniu(String values);

    boolean addFundInfoFromQieMan(String values);

    boolean addFundInfoFromZhiShuValue(String values);

    boolean updateFundInfoFromAniu(String values);

    boolean updateFundInfoFromQieMan(String values);

    boolean updateFundInfoFromZhiShuValue(String values);
}
