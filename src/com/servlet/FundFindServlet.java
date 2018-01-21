package com.servlet;

import com.beans.FundInfoAll;
import com.service.FundFindService;
import com.service.FundUpdateService;
import com.service.IFundFindService;
import com.service.IFundUpdateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FundFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json; charset=UTF-8");

        IFundFindService findService =new FundFindService();
        findService.getHistoryFundInfoFromAniu();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
