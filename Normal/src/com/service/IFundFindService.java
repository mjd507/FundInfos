package com.service;

import com.beans.FundInfoAll;

import java.util.ArrayList;

public interface IFundFindService {

    ArrayList<FundInfoAll> getHistoryFundInfoFromAniu();

    ArrayList<FundInfoAll> getHistoryFundInfoFromQieMan();

    ArrayList<FundInfoAll> getHistoryFundInfoFromZhiShuValue();

}
