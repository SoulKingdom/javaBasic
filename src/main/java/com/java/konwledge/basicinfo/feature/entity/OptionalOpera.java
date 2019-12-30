package com.java.konwledge.basicinfo.feature.entity;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 *  @dept 上海软件研发中心
 *  @description Optional类的使用
 *  @author HaoXin.Liu
 *  @date 2019/11/14 17:47
 **/
@Slf4j
public class OptionalOpera {
    public static void main(String[] args) {
        Optional<String> fullName = Optional.ofNullable(null);
        //isPresent() 持有一个非null值，返回true,否则返回false
        log.info("Full Name is set? " + fullName.isPresent());
        //持有null的时候返回传入的默认值
        log.info("Full Name: " + fullName.orElse("[none]"));
        //设置Option值不为空
        fullName = Optional.ofNullable("blockChain");
        //如果不为空则输出map对象，为空执行orElse
        log.info(fullName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
    }
}