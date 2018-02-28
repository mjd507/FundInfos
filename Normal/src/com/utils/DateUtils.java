package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static void main(String args[]) {
        String todayStr = getTodayStr();
        System.out.println(todayStr);
    }

    public static String getTodayStr() {
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        return format.format(new Date());
    }
}
