package com.java.konwledge.basicinfo.feature.entity;

import lombok.Data;

/**
 *  @dept 上海软件研发中心
 *  @description 个人信息
 *  @author HaoXin.Liu
 *  @date 2019/11/11 15:08
 **/
@Data
public class Person {
    /**
     * 姓名
     */
    private String name;
    /**
     * 班级
     */
    private String classes;
    /**
     * 年龄
     */
    private Integer age;

    public Person() {
        super();
    }

    public Person(String name, String classes, Integer age) {
        this.name = name;
        this.classes = classes;
        this.age = age;
    }
}