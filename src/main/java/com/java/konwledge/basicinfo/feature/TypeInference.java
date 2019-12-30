package com.java.konwledge.basicinfo.feature;

import lombok.extern.slf4j.Slf4j;

/**
 *  @dept 上海软件研发中心
 *  @description Java8类型推断能力增强
 *  @author HaoXin.Liu
 *  @date 2019/11/14 17:37
 **/
@Slf4j
public class TypeInference {
    /**
     * 存值的泛型类
     */
    public static class Value<T> {
        public static <T> T defaultValue() {
            return null;
        }

        public T getOrDefault(T value, T defaultValue) {
            return (value != null) ? value : defaultValue;
        }
    }

    public static void main(String[] args) {
        //创建泛型类
        final Value<String> value = new Value<>();
        // Value.defaultValue()根据推到认定位位String类型
        String str = value.getOrDefault("22", Value.defaultValue());
        log.info("类型推断为String类型的值：" + str);
    }
}