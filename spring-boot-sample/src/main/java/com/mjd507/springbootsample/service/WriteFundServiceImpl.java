package com.mjd507.springbootsample.service;

import com.mjd507.springbootsample.beans.FundInfoAll;
import com.mjd507.springbootsample.dao.AniuFundDaoMapper;
import com.mjd507.springbootsample.dao.QiemanFundDaoMapper;
import com.mjd507.springbootsample.dao.ZhiShuFundDaoMapper;
import com.mjd507.springbootsample.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriteFundServiceImpl implements IWriteFundService {

    @Autowired
    private AniuFundDaoMapper aniuFundDaoMapper;
    @Autowired
    private QiemanFundDaoMapper qiemanFundDaoMapper;
    @Autowired
    private ZhiShuFundDaoMapper zhiShuFundDaoMapper;

    @Override
    public boolean addFundInfoFromAniu(String values) {
        String date = DateUtils.getTodayStr();
        FundInfoAll todayInfo = aniuFundDaoMapper.getDayFundInfo(date);
        boolean hasTodayInfo = todayInfo != null;
        if (hasTodayInfo) return updateFundInfoFromAniu(values);
        return aniuFundDaoMapper.addFundInfo(date, values);
    }

    @Override
    public boolean addFundInfoFromQieMan(String values) {
        String date = DateUtils.getTodayStr();
        FundInfoAll todayInfo = qiemanFundDaoMapper.getDayFundInfo(date);
        boolean hasTodayInfo = todayInfo != null;
        if (hasTodayInfo) return updateFundInfoFromQieMan(values);
        return qiemanFundDaoMapper.addFundInfo(date, values);
    }

    @Override
    public boolean addFundInfoFromZhiShuValue(String values) {
        String date = DateUtils.getTodayStr();
        FundInfoAll todayInfo = zhiShuFundDaoMapper.getDayFundInfo(date);
        boolean hasTodayInfo = todayInfo != null;
        if (hasTodayInfo) return updateFundInfoFromZhiShuValue(values);
        return zhiShuFundDaoMapper.addFundInfo(date, values);
    }

    @Override
    public boolean updateFundInfoFromAniu(String values) {
        String date = DateUtils.getTodayStr();
        return aniuFundDaoMapper.updateFundInfo(date, values);
    }

    @Override
    public boolean updateFundInfoFromQieMan(String values) {
        String date = DateUtils.getTodayStr();
        return qiemanFundDaoMapper.updateFundInfo(date, values);
    }

    @Override
    public boolean updateFundInfoFromZhiShuValue(String values) {
        String date = DateUtils.getTodayStr();
        return zhiShuFundDaoMapper.updateFundInfo(date, values);
    }
}
