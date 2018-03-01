package com.mjd507.springbootsample.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static void main(String args[]) {
        String todayStr = getTodayStr();
        System.out.println(todayStr);
    }

    public static String getTodayStr() {
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        return format.format(new Date());
    }
}
