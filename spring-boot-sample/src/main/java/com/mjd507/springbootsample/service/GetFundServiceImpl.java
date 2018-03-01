package com.mjd507.springbootsample.service;

import com.mjd507.springbootsample.beans.FundInfoAll;
import com.mjd507.springbootsample.dao.AniuFundDaoMapper;
import com.mjd507.springbootsample.dao.QiemanFundDaoMapper;
import com.mjd507.springbootsample.dao.ZhiShuFundDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GetFundServiceImpl implements IGetFundService {

    @Autowired
    private AniuFundDaoMapper aniuFundDaoMapper;
    @Autowired
    private QiemanFundDaoMapper qiemanFundDaoMapper;
    @Autowired
    private ZhiShuFundDaoMapper zhiShuFundDaoMapper;


    @Override
    public ArrayList<FundInfoAll> getHistoryFundInfoFromAniu() {
        return aniuFundDaoMapper.getHistoryFundInfo();
    }

    @Override
    public ArrayList<FundInfoAll> getHistoryFundInfoFromQieMan() {
        return qiemanFundDaoMapper.getHistoryFundInfo();
    }

    @Override
    public ArrayList<FundInfoAll> getHistoryFundInfoFromZhiShuValue() {
        return zhiShuFundDaoMapper.getHistoryFundInfo();
    }
}
