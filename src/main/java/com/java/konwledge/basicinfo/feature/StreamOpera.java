package com.java.konwledge.basicinfo.feature;

import com.java.konwledge.basicinfo.feature.entity.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  @dept 上海软件研发中心
 *  @description 流结构的使用
 *  @author HaoXin.Liu
 *  @date 2019/11/8 13:33
 **/
@Slf4j
public class StreamOpera {
    /**
     * 数组转换成流的操作
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/11/8 13:37
     **/
    public static void arrayStream() {
        //Stream流操作 1、数组操作
        String[] strAy = {"a", "b", "c"};
        //数组转换成流结构
        Stream stream = Stream.of(strAy);
        stream = Arrays.stream(strAy);
        stream = stream.map(o -> o + "1");
        String[] strToAy = (String[]) stream.toArray(String[]::new);
        //把字符串拼接成一个数组
        String str = Stream.of(strToAy).collect(Collectors.joining(","));
        log.info(str);
    }

    /**
     * Stream基本操作流程 从source -> Intermediate -> ( short-circuiting)->Terminal
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/11/8 18:17
     **/
    void treamOpera() {
        //Stream流操作 1、数组操作
        String[] strAy = {"a", "b", "c"};
        //数组转换成流结构
        Stream stream = Stream.of(strAy);
        List<String> stringList = (List<String>) stream.collect(Collectors.toList());
        //大小写转换
        stringList = stringList.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    /**
     * 集合转换成流的操作
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/11/8 13:37
     **/
    public static void collectionStream() {
        String[] strAy = {"a", "b", "c"};
        //数组转换成Stream流
        Stream stream = Stream.of(strAy);
        //数组转成集合流
        List<String> list = Arrays.asList(strAy);
        stream = list.stream();
        //集合流转换成集合 一个Stream只能使用一次
        list = (List<String>) stream.collect(Collectors.toList());
        //list = (List<String>) stream.collect(Collectors.toCollection(ArrayList::new));
        //对集合数据进行遍历
        list.stream().forEach(o -> System.out.print(o));
    }

    /**
     * stream流操作
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/11/8 13:37
     **/
    public static void streamOperation() {
        //求值List的平方
        List<Integer> list = Arrays.asList(1, 2, 3);
        //进行平方运算求职
        list = list.stream().map(n -> n * n).collect(Collectors.toList());
        list.forEach(o -> System.out.println("平方值是：" + o));
        //进行一堆多流数据管理
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
        //对数据进行统计封装到一个Stream中
        outputStream.forEach(o -> System.out.println(o));
    }

    /**
     * Intermediate的filter操作
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/11/8 13:37
     **/
    public static void filterOperation() {
        List<String> list = Arrays.asList("livingRoom", "bathRoom", "fridge", "refrigerator");
        //条件筛选包含“Room”的单词
        list = list.stream().filter(o -> o.contains("Room")).collect(Collectors.toList());
        list.forEach(o -> System.out.println(o));
    }

    /**
     * Intermediate的peek操作
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/11/8 13:37
     **/
    public static void peekOperation() {
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }

    /**
     * Short-circuiting的findFirst用法
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/11/8 13:37
     **/
    public static void findFirstOperator() {
        String str1 = " abcd ", str2 = null;
        Optional optional = Arrays.asList(str1).stream().findFirst();
        System.out.println(optional.get());
        Optional.ofNullable(str1).ifPresent(o -> System.out.println(o));
        Integer integer = Optional.ofNullable(str2).map(String::length).orElse(10);
        System.out.println(integer);
    }

    /**
     * Short-circuiting的reduce的操作
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/11/8 13:37
     **/
    public static void reduceOperator() {
        //字符串拼接
        List<String> list = Arrays.asList("10", "20");
        String concat = list.stream().reduce("", String::concat);
        log.info(concat);
        //进行运算
        Double max = list.stream().map(Double::valueOf).reduce(Double.MAX_VALUE, Double::min);
        log.info(max.toString());
     /*   List<Integer> doubleList = Arrays.asList(10, 20, 30);
        Integer min = doubleList.stream().reduce(Integer.MAX_VALUE, Integer::min);
        log.info("数组最小值是：" + min);*/
    }

    /**
     * limit和skip的操作
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/11/8 13:37
     **/
    public static void limitSkipOpera() {
        List<String> list = Arrays.asList("10", "20", "30", "40", "50", "60");
        //对集合进行排序
        //list = list.stream().sorted(((o1, o2) -> Integer.valueOf(o2)-Integer.valueOf(o1))).collect(Collectors.toList());
        list = list.stream().sorted((Comparator.comparingInt(Integer::valueOf))).limit(5).skip(2).collect(Collectors.toList());
        //limit和skip的应用
        //list = list.stream().skip(2).limit(2).collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    /**
     * match的使用 allMatch  anyMath noneMathc
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2019/11/11 14:48
     **/
    public static void matchOperation() {
        List<String> list = Arrays.asList("10", "20", "30", "40", "50", "60");
        Boolean flag = list.stream().allMatch(o -> Integer.valueOf(o) > 20);
        log.info("This list condition is: " + flag);
        Boolean flagTo = list.stream().allMatch(o -> Integer.valueOf(o) < 100);
        log.info("This list condition is: " + flagTo);
        //进行分组测试
        List<Person> personList = new ArrayList<>(2);
        Person p = new Person();
        p.setName("p1");
        p.setClasses("1");
        p.setAge(18);
        Person p2 = new Person();
        p2.setName("p2");
        p2.setClasses("1");
        p2.setAge(18);
        Person p3 = new Person();
        p3.setName("p3");
        p3.setClasses("2");
        p3.setAge(19);
        Person p4 = new Person();
        p4.setName("p4");
        p4.setClasses("2");
        p4.setAge(19);
        personList.add(p);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.stream().forEach(o -> {
            if ("p1".equals(o.getName())) {
                o.setAge(25);
            }
        });
        //输出看看是否内部数据进行更改(对象修改之后，内容指向的地址也会进行修改)
        personList.stream().forEach(System.out::println);
        Map<String, List<Person>> personMap = personList.stream().collect(Collectors.groupingBy(Person::getClasses));
        //分组后的数据进行输出
        personMap.forEach((s, list1) -> {
            System.out.println(s + ":");
            list1.stream().forEach(System.out::println);
        });
    }

    /**
     * Stream方法具体分析
     * 1.
     *
     */
    public static void main(String[] args) {
        //数组数据流操作
        arrayStream();
        //集合数据流操作
        collectionStream();
        //Steam的流运算
        streamOperation();
        //Intermediate filter用法
        filterOperation();
        //Intermediate peek用法
        peekOperation();
        //Short-circuiting的findFirst用法
        findFirstOperator();
        //Short-circuiting的reduce的操作
        reduceOperator();
        //limit和skip的操作
        limitSkipOpera();
        //match的操作
        matchOperation();
    }
}