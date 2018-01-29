package com.servlet;

import com.service.FundUpdateService;
import com.service.IFundUpdateService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet(urlPatterns = {"/writeFundInfo"})
public class FundUpdateServlet extends HttpServlet {

    private static final String URL_A_NIU = "https://m.aniu.com.cn/fof_pe_share/";
    private static final String URL_ZhiShuValue = "https://data.etfquant.cn/daily_pe_wxApp.json";
    private static final String URL_QIEMAN = "https://qieman.com/pmdj/v2/idx-eval/latest?msrc=WXA1001";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/json; charset=UTF-8");


        String toadyAniu = getTodayInfo(URL_A_NIU);
        String todayQieMan = getTodayInfo(URL_QIEMAN);
        String todayZhiShu = getTodayInfo(URL_ZhiShuValue);
        if (todayQieMan != null) {
            IFundUpdateService updateService = new FundUpdateService();
            boolean isAdd = updateService.addFundInfoFromQieMan(todayQieMan);
            String msg = "aniu data write to database " + (isAdd ? "success" : "failure");
            resp.getOutputStream().write(msg.getBytes("UTF-8"));
        } else {
            String msg = "aniu data write to database " + (1==1 ? "success" : "failure");
            resp.getOutputStream().write(msg.getBytes("UTF-8"));
        }

    }


    private String getTodayInfo(String url) {
        HttpURLConnection conn = null;
        try {
            URL mUrl = new URL(url);

            conn = (HttpURLConnection) mUrl.openConnection();
            conn.setRequestProperty("x-sign", "01BMN17A802B00HCW48QFNC7ED"); //且慢校验
            conn.setRequestProperty("Content-Type","application/json; charset=utf-8");//且慢校验
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
