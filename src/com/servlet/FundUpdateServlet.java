package com.servlet;

import com.service.FundUpdateService;
import com.service.IFundUpdateService;
import jdk.nashorn.internal.ir.debug.JSONWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class FundUpdateServlet extends HttpServlet {

    private static final String URL_A_NIU = "https://m.aniu.com.cn/fof_pe_share/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json; charset=UTF-8");

        IFundUpdateService updateService = new FundUpdateService();
        String toadyAniu = getTodayInfoFromAniu(URL_A_NIU);
        if (toadyAniu != null) {
            boolean isAdd = updateService.addFundInfoFromAniu(toadyAniu);
            String msg = "aniu data write to database " + (isAdd ? "success" : "failure");
            resp.getOutputStream().write(msg.getBytes("UTF-8"));
        } else {
            String msg = "np data";
            resp.getOutputStream().write(msg.getBytes("UTF-8"));
        }
    }


    private String getTodayInfoFromAniu(String url) {
        HttpURLConnection conn = null;
        try {
            URL mUrl = new URL(url);
            conn = (HttpURLConnection) mUrl.openConnection();
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
