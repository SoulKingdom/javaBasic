package com.java.konwledge.basicinfo.javabasic.IoStream;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.java.konwledge.basicinfo.javabasic.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *  @dept 上海软件研发中心
 *  @description 流的操作
 *  @author HaoXin.Liu
 *  @date 2019/12/31 10:17
 **/
public class IoStreamOperation {
    public static final Logger log = LoggerFactory.getLogger(IoStreamOperation.class);

    /**
     * 创建文件流 写入
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/12/31 10:22
     **/
    private void createFileWrite() {
        try {
            //创建文件
            FileWriter fw = new FileWriter("demo.txt");
            //数据写入
            fw.append("abc");
            fw.append("def");
            //刷新数据到本地
            fw.flush();
            //关闭写入流
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建文件流读取
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/12/31 10:31
     **/
    private void createFileStream() {
        try {
            InputStream inputStream = new FileInputStream("demo.txt");
            byte[] bit = new byte[10];
            int num;
            StringBuilder sb = new StringBuilder();
            if ((num = inputStream.read(bit)) != -1) {
                sb.append(bit);
                log.info("数量是：" + num + "  数据是:" + sb.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {




        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date startTime = sdf.parse("2020-11-03 18:00:01");
            Date endTime = sdf.parse("2020-11-03 19:00:00");
            Date visitStart =sdf.parse("2020-11-03 17:45:00");
            Date visitEnd = sdf.parse("2020-11-03 18:00:00");
            if ((!startTime.after(visitEnd)) && (!endTime.before(visitStart))) {
                //时间重叠
                if(startTime.equals(visitEnd)){
                    System.out.println("false");
                }else {
                    System.out.println("true");
                }

            }else{
                System.out.println("false");
            }
        }catch (Exception e){

        }

        List<Integer> listA = Lists.newArrayList();
        listA.add(1);
        listA.add(6);
        List<Integer> listB = Lists.newArrayList();
        listB.add(10);
        listB.add(2);
        Map<String, List<Integer>> abMap = Maps.newHashMap();
        abMap.put("A", listA);
        abMap.put("B", listB);
        // 需获取A和B集合中大于5的元素
        abMap.values().stream().flatMap(num -> num.stream().filter(n -> n > 5)).collect(Collectors.toList())
                .forEach(System.out::println);

        "1".equals(null);
        Predicate predicate = (o -> !o.equals("1"));
        Predicate predicate2 = (o -> !o.equals("2"));
        predicate.and(predicate2).test("3");
        predicate.and(predicate2).test("2");
        List<String> list = Arrays.asList("1", "2", "3", "3");
        List<String> listNew = new ArrayList<>(list.size());
        List<Person> personList;
        List<Person> personList2;
        personList = init();
        //去重
        listNew = list.stream().distinct().collect(Collectors.toList());
        //对象去重
        personList2 = personList.stream().distinct().collect(Collectors.toList());
        //
        listNew = (List<String>) list.stream().filter(predicate).collect(Collectors.toList());
        Map<String, List<String>> map = list.stream().collect(Collectors.groupingBy(o -> o));
        String st = list.stream().collect(Collectors.joining("-"));
        for (Map.Entry<String, List<String>> entity : map.entrySet()) {
            log.info(entity.getKey());
            log.info(entity.getValue().toString());
        }
        list = list.stream().peek(o -> System.out.println(o)).collect(Collectors.toList());
        log.info("forEach的用法输出:");
        list.stream().forEach(o -> {
            log.info(o);
        });

        //数据
        Integer counSum = list.stream().mapToInt(o -> Integer.parseInt(o)).sum();
        log.info("统计结果：{}", counSum);
        log.info(st);
    }

    private static List<Person> init() {
        List<Person> list = new ArrayList<>(4);
        Person person = new Person();
        person.setName("a");
        person.setAge("12");
        Person person2 = new Person();
        person2.setName("a");
        Person person3 = new Person();
        person3.setName("a");
        person3.setAge("12");
        Person person4 = new Person();
        person4.setAge("123");
        Person person5 = new Person();
        person5.setName("a");
        person5.setAge("12");
        Person person6 = new Person();
        list.add(person);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        list.add(person6);
        return list;
    }


    public static String getMD5(String message) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(message.getBytes());
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            message = hexValue.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return message;
    }
}