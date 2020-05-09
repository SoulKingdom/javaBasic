package com.java.konwledge.basicinfo.feature;

import com.java.konwledge.basicinfo.feature.entity.OptionalOpera;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 *  @dept 上海软件研发中心
 *  @description Lambda
 *  @author HaoXin.Liu
 *  @date 2020/5/9 15:26
 **/
public class LambdaOpera {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, Comparator.reverseOrder());

        names.stream().forEach(System.out::println);

        OptionalOpera optionalOpera = new OptionalOpera();
        Consumer<String> str = optionalOpera::getName;
        System.out.println(str);

    }
}