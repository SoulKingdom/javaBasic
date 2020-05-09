package com.java.konwledge.basicinfo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  @dept 上海软件研发中心
 *  @description 测试解析jwt
 *  @author HaoXin.Liu
 *  @date 2020/3/11 17:12
 **/
public class test1 {
    public static void main(String[] args) {
        Integer w = test1.getCurrDayOfWeek(test1.formatDate(new Date()));
        System.out.println(w);
    }
    public static String formatDate(java.util.Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    private static Integer getCurrDayOfWeek(String currDate) {
        //获取当日时间对应的星期几
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = timeFormat.parse(currDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            //星期字段 1~7
            int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
            Integer[] weekDay = new Integer[]{7, 1, 2, 3, 4, 5, 6};
            return weekDay[w];
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}