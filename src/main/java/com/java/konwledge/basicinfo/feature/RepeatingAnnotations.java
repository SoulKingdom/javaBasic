package com.java.konwledge.basicinfo.feature;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.lang.annotation.*;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *  @dept 上海软件研发中心
 *  @description 重复注解的使用
 *  @author HaoXin.Liu
 *  @date 2019/11/14 16:58
 **/
@Slf4j
public class RepeatingAnnotations {
    //该注解放在类的什么位置：Type 类上
    @Target(ElementType.TYPE)
    //该注解保留的时机  如果需要使用反射，必须为runtime
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        //定义一个Filter是一个注解，代表注解重复使用
        Filter[] value();
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    //代表重复注解，重复注解定义的类为Filters
    @Repeatable(Filters.class)
    public @interface Filter {
        String value();
    }

    /**
     * 使用重复注解的类
     */
    @Filter("filter1")
    @Filter("filter2")
    public interface Filterable {
    }

    /**
     * 在类中时使用双注解
     */
    @Filter("FilterClass1")
    @Filter("FilterClass2")
    class FilterClass {
    }

    public static void main(String[] args) {
        log.info("-----getAnnotationsByType方法的使用-----");
        //通过反射获取注解上对应的注解类
        for (Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
            //输出注解类对应的值
            log.info("通过反射获取的注解------->" + filter.value());
        }
        //通过注解获取类上对应的注解
        Arrays.stream(FilterClass.class.getAnnotationsByType(Filter.class)).
                forEach(o -> log.info("通过反射获取类上的注解值----->" + o.value()));
        log.info("-----getAnnotations方法的使用-----");
        Stream.of(FilterClass.class.getAnnotations()).forEach(o -> log.info("通过反射获取类上的注解值----->" + o.getClass().getName()));
/*        log.info("-----getAnnotation方法的使用-----");
        log.info("通过反射获取类上的注解值----->" + FilterClass.class.getAnnotation(Filter.class).value());*/

    }
}