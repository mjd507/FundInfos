package com.service;

import com.dao.DaoFactory;
import com.dao.IFundDao;

public class FundUpdateService implements IFundUpdateService {
    private final IFundDao mFundDao;

    public FundUpdateService() {
        mFundDao = DaoFactory.getInstance().getDaoByConfig(IFundDao.class);
    }

    @Override
    public boolean addFundInfoFromAniu(String values) {
        return mFundDao.addFundInfoFromAniu(values);
    }

    @Override
    public boolean addFundInfoFromQieMan(String values) {
        return mFundDao.addFundInfoFromQieMan(values);
    }

    @Override
    public boolean addFundInfoFromZhiShuValue(String values) {
        return mFundDao.addFundInfoFromZhiShuValue(values);
    }
}
