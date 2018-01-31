package com.servlet;

import com.beans.FundInfoAll;
import com.google.gson.Gson;
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
    class WriteMsg {
        String name;
        ArrayList<FundInfoAll> value;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        ArrayList<WriteMsg> list = new ArrayList<>();

        IFundFindService findService = new FundFindService();
        ArrayList<FundInfoAll> aniu = findService.getHistoryFundInfoFromAniu();

        WriteMsg msg1 = new WriteMsg();
        msg1.name = "aniu";
        msg1.value = aniu;
        list.add(msg1);

        ArrayList<FundInfoAll> qieMan = findService.getHistoryFundInfoFromQieMan();
        WriteMsg msg2 = new WriteMsg();
        msg2.name = "qieMan";
        msg2.value = qieMan;
        list.add(msg2);

        ArrayList<FundInfoAll> zhiShuValue = findService.getHistoryFundInfoFromZhiShuValue();
        WriteMsg msg3 = new WriteMsg();
        msg3.name = "zhiShuValue";
        msg3.value = zhiShuValue;
        list.add(msg3);

        Gson gson = new Gson();
        String jsonStr = gson.toJson(list);

        resp.getWriter().write(jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
