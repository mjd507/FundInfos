package com.service;

import com.beans.FundInfoAll;

import java.util.ArrayList;

public interface IFundUpdateService {

    boolean addFundInfoFromAniu(String values);

    boolean addFundInfoFromQieMan(String values);

    boolean addFundInfoFromZhiShuValue(String values);
}
