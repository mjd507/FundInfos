package com.mjd507.springbootsample.service;

import com.mjd507.springbootsample.beans.FundInfoAll;

import java.util.ArrayList;

public interface IGetFundService {

    ArrayList<FundInfoAll> getHistoryFundInfoFromAniu();

    ArrayList<FundInfoAll> getHistoryFundInfoFromQieMan();

    ArrayList<FundInfoAll> getHistoryFundInfoFromZhiShuValue();


}
