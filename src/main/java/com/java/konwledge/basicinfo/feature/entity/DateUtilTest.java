package com.java.konwledge.basicinfo.feature.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2020/12/3 9:41
 **/
public class DateUtilTest {
    private static final Logger logger = LoggerFactory.getLogger(DateUtilTest.class);

    public static void main(String[] args) {
        Date startTime = strToDate("2020-12-01 12:59:59");
        Date endTime = strToDate("2020-12-02 23:59:59");
        logger.info("This date total {} days", getDatePoorDay(endTime, startTime));

    }

    /**
     * @function string->date
     * @params time
     **/
    public static Date strToDate(String time) {

        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return timeFormat.parse(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 两个时间相隔多少天，向上取整
     * @param endDate
     * @param nowDate
     * @return
     */
    public static String getDatePoorDay(Date endDate, Date nowDate) {
        double days = 0;
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        if (hour > 0 && hour < 12) {
            days = day + 0.5;
        } else if (hour > 12) {
            day = day + 1;
        }
        // 计算差多少秒//输出结果
        return String.valueOf(days);
    }
}