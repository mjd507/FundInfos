package com.mjd507.springbootsample.controller;

import com.mjd507.springbootsample.beans.FundInfoAll;
import com.mjd507.springbootsample.beans.WriteStatus;
import com.mjd507.springbootsample.service.WriteFundServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class WriteFundInfoController {

    private static final String URL_A_NIU = "https://m.aniu.com.cn/fof_pe_share/";
    private static final String URL_ZhiShuValue = "https://data.etfquant.cn/daily_pe_wxApp.json";
    private static final String URL_QIEMAN = "https://qieman.com/pmdj/v2/idx-eval/latest?msrc=WXA1001";

    @Autowired
    WriteFundServiceImpl fundService;

    @RequestMapping(value = "/writeFundInfo")
    public WriteStatus writeFundInfo() {
        String aniuInfo = getTodayInfo(URL_A_NIU);
        String qiemanInfo = getTodayInfo(URL_QIEMAN);
        String zhishuInfo = getTodayInfo(URL_ZhiShuValue);
        WriteStatus status = new WriteStatus();
        status.setAniu(aniuInfo != null && fundService.addFundInfoFromAniu(aniuInfo));
        status.setQieman(qiemanInfo != null && fundService.addFundInfoFromQieMan(qiemanInfo));
        status.setZhishu(zhishuInfo != null && fundService.addFundInfoFromZhiShuValue(zhishuInfo));
        return status;
    }

    private String getTodayInfo(String url) {
        HttpURLConnection conn = null;
        try {
            URL mUrl = new URL(url);

            conn = (HttpURLConnection) mUrl.openConnection();
            conn.setRequestProperty("x-sign", "01BMN17A802B00HCW48QFNC7ED"); //且慢校验
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");//且慢校验
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                InputStream is = conn.getInputStream();
                BufferedReader bufr = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuilder sb = new StringBuilder();
                String res;
                while ((res = bufr.readLine()) != null) {
                    sb.append(res);
                }
                bufr.close();
                return sb.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }

}
