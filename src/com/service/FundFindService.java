package com.service;

import com.beans.FundInfoAll;
import com.dao.DaoFactory;
import com.dao.IFundDao;

import java.util.ArrayList;

public class FundFindService implements IFundFindService {

    private IFundDao mFundDao;

    public FundFindService() {
        mFundDao = DaoFactory.getInstance().getDaoByConfig(IFundDao.class);
    }

    @Override
    public ArrayList<FundInfoAll> getHistoryFundInfoFromAniu() {
        return mFundDao.getHistoryFundInfoFromAniu();
    }

    @Override
    public ArrayList<FundInfoAll> getHistoryFundInfoFromQieMan() {
        return mFundDao.getHistoryFundInfoFromQieMan();
    }

    @Override
    public ArrayList<FundInfoAll> getHistoryFundInfoFromZhiShuValue() {
        return mFundDao.getHistoryFundInfoFromZhiShuValue();
    }
}
