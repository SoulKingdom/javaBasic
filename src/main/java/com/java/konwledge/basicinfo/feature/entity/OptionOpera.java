package com.java.konwledge.basicinfo.feature.entity;

import jdk.nashorn.internal.runtime.options.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 *  @dept 上海软件研发中心
 *  @description Option操作
 *  @author HaoXin.Liu
 *  @date 2020/2/24 18:17
 **/
public class OptionOpera {
    private static final Logger log = LoggerFactory.getLogger(OptionalOpera.class);

    /**
     * 创建optional
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2020/2/25 9:34
     **/
    public static void optionOper() {
        //创建操作对象 ofNullable 不存在/存在
        Optional<Person> personOption = Optional.ofNullable(new Person("lhx", "1503", 11));
        //验证是否有值
        if (personOption.isPresent()) {
            Person person = personOption.get();
            log.info(person.toString());
        }
    }

    /**
     * option过滤操作
     *
     * @dept 上海软件研发中心
     * @author HaoXin.Liu
     * @date 2020/2/25 9:35
     **/
    public static void optionFilter() {
        Optional<Person> personOption = Optional.ofNullable(new Person("lhx", "1503", 11));
        Optional<Person> personTo = personOption.filter(p -> p.getAge() > 10);
        //map参数
        personOption.map(OptionOpera::getOutputOpt).orElse(Optional.of(new Person()));
    }


    static Optional<Person> getOutputOpt(Person input) {
        return input == null ? Optional.empty() : Optional.of(input);
    }

    public static void main(String[] args) {
        //Option操作
        optionOper();
    }
}