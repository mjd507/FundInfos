package com.mjd507.springbootsample.service;

public interface IWriteFundService {

    boolean addFundInfoFromAniu(String values);

    boolean addFundInfoFromQieMan(String values);

    boolean addFundInfoFromZhiShuValue(String values);

    boolean updateFundInfoFromAniu(String values);

    boolean updateFundInfoFromQieMan(String values);

    boolean updateFundInfoFromZhiShuValue(String values);
}
