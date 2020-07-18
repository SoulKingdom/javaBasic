package com.java.konwledge.basicinfo.test;

import com.java.konwledge.basicinfo.util.DateUtils;

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
       /* Integer b = 501;
        Integer i = new Integer(501);
        int c = 501;
        int in = 8<6?i:b;
        System.out.println(b == c);
        System.out.println(i == c);
        System.out.println(i == b);*/
        String str = DateUtils.getTodayDate();
        // time1在time2之后true; time1在time2之前 false
        Boolean flag = DateUtils.beforeDate("2020-05-27",DateUtils.getTodayDate());
        System.out.println(str);
        System.out.println(flag);
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