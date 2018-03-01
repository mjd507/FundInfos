package com.mjd507.springbootsample.controller;

import com.mjd507.springbootsample.beans.FundInfoAll;
import com.mjd507.springbootsample.dao.AniuFundDaoMapper;
import com.mjd507.springbootsample.service.GetFundServiceImpl;
import com.mjd507.springbootsample.service.IGetFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class GetFunInfoController {

    @Autowired
    GetFundServiceImpl fundService;

    @RequestMapping(value = "/getFundInfo")
    public Map<String, ArrayList<FundInfoAll>> getFundInfo() {
        ArrayList<FundInfoAll> aniu = fundService.getHistoryFundInfoFromAniu();
        ArrayList<FundInfoAll> qieMan = fundService.getHistoryFundInfoFromQieMan();
        ArrayList<FundInfoAll> zhiShu = fundService.getHistoryFundInfoFromZhiShuValue();
        Map<String, ArrayList<FundInfoAll>> list = new LinkedHashMap<>();
        list.put("aniu", aniu);
        list.put("qieman", qieMan);
        list.put("zhishu", zhiShu);
        return list;
    }

}
