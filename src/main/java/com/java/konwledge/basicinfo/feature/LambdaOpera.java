package com.java.konwledge.basicinfo.feature;

import com.java.konwledge.basicinfo.arithmetic.sort.MD5Util;
import com.java.konwledge.basicinfo.feature.entity.OptionalOpera;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;

/**
 *  @dept 上海软件研发中心
 *  @description Lambda
 *  @author HaoXin.Liu
 *  @date 2020/5/9 15:26
 **/
public class LambdaOpera {

    public static void main(String[] args) {
        String str = MD5Util.getMD5("123456");
        /*List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, Comparator.reverseOrder());

        names.stream().forEach(System.out::println);

        OptionalOpera optionalOpera = new OptionalOpera();
        Consumer<String> str = optionalOpera::getName;
        System.out.println(str);*/
        String channelId="123";
        String inChannelId="  ";
        String outChannelId="  ";
        String[] channelIds;
        String[] inChannelIds;
        String[] outChannelIds;
        if (StringUtils.isNotBlank(channelId)) {
            channelIds = channelId.split(",");
        }else{
            channelIds = new String[0];
        }
        if (StringUtils.isNotBlank(inChannelId)) {
            inChannelIds = channelId.split(",");
        }else{
            inChannelIds = new String[0];
        }
        if (StringUtils.isNotBlank(outChannelId)) {
            outChannelIds = channelId.split(",");
        }else{
            outChannelIds = new String[0];
        }
        int length = inChannelIds.length + outChannelIds.length + channelIds.length;
        Map map = new HashMap(length);
        Arrays.stream(channelIds).forEach(o -> map.put(o, o));
        Arrays.stream(outChannelIds).forEach(o -> map.put(o, o));
        Arrays.stream(inChannelIds).forEach(o -> map.put(o, o));
        //不等重复
        if (0 != length && map.size() != length) {
            //存在重复
            System.out.println(0);
        }else{
            System.out.println(1);
        }
    }


    public static ArrayList<String> test(int intervals ) {
        ArrayList<String> pastDaysList = new ArrayList<>();
        ArrayList<String> fetureDaysList = new ArrayList<>();
        for (int i = 0; i <intervals; i++) {
            pastDaysList.add(getPastDate(i));
            fetureDaysList.add(getFetureDate(i));
        }
        return pastDaysList;
    }


    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        //Log.e(null, result);
        return result;
    }
    /**
     * 获取未来 第 past 天的日期
     * @param past
     * @return
     */
    public static String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        //Log.e(null, result);
        return result;
    }
}