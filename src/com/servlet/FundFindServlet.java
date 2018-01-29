package com.servlet;

import com.beans.FundInfoAll;
import com.service.FundFindService;
import com.service.IFundFindService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/getFundInfo"})
public class FundFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json; charset=UTF-8");

        IFundFindService findService = new FundFindService();
        ArrayList<FundInfoAll> fromAniu = findService.getHistoryFundInfoFromAniu();
        String msg = "数据长度：" + fromAniu.size();
        resp.getOutputStream().write(msg.getBytes("UTF-8"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
