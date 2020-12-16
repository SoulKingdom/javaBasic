package com.java.konwledge.basicinfo.test;

import com.java.konwledge.basicinfo.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;

/**
 *  @dept 上海软件研发中心
 *  @description 测试解析jwt
 *  @author HaoXin.Liu
 *  @date 2020/3/11 17:12
 **/
public class test1 {
    public static final Logger logger = LoggerFactory.getLogger(test1.class);

    public static void main(String[] args) {
        String userId = "1";
        List<String> list;
        Predicate<List> predicate4 = o->Objects.isNull(o) || o.size() == 0;
        Predicate<String> predicate = (s)->s.length() >0;
        Predicate<String> predicate2 = (s)->s.equals("1");
        Predicate<String> predicate3 = (s)->s.equals("2");

        list = new ArrayList<>(1);
        if(predicate4.test(list)){
            logger.info("list is null or size = 0");
        }
        list.add("1");
        if(predicate4.negate().test(list)){
            logger.info("list is not null and  size != 0");
        }


        if(predicate.test(userId)){
            logger.info("This user result is {}",userId);
        }
       if(predicate.and(predicate2).test(userId)){
           logger.info(userId);
       }
        if(predicate.and(predicate3).test(userId)){
            logger.info(userId);
        }
       /* Integer b = 501;
        Integer i = new Integer(501);
        int c = 501;
        int in = 8<6?i:b;
        System.out.println(b == c);
        System.out.println(i == c);
        System.out.println(i == b);*/
       // String str = DateUtils.getTodayDate();
        // time1在time2之后true; time1在time2之前 false
       /* Boolean flag = DateUtils.beforeDate("2020-05-27",DateUtils.getTodayDate());
        System.out.println(str);
        System.out.println(flag);*/
       /* BigDecimal big = new BigDecimal("0");
        BigDecimal newt1 = BigDecimal.ZERO;
        BigDecimal newt2 = BigDecimal.ZERO;
        newt2 = newt1.add(big.setScale(2,RoundingMode.FLOOR));
        System.out.println(big.toString());*/
      /*  String[] inChannelId = "1".split(",");
        String[] outChannelId = "".split(",");
        int length = inChannelId.length + outChannelId.length;
        Map map = new HashMap(length);
        Arrays.stream(inChannelId).forEach(o -> map.put(o, o));
        Arrays.stream(outChannelId).forEach(o -> map.put(o, o));*/
//不等重复
       /* if (map.size() != length) {
            System.out.println(false);
        }
        System.out.println(true);*/
//        Map<String, String> map = new HashMap();
//        map.put("1", "1");
//        map.put("1", "2");
//        logger.info(String.valueOf(map.size()));
//
//        Date date = new Date();
//        logger.info(date.toString());
        //JSON.toJSONString()
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