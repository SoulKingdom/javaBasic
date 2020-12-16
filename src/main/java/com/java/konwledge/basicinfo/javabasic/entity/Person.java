package com.java.konwledge.basicinfo.javabasic.entity;

import java.util.Objects;

/**
 *  @dept 上海软件研发中心
 *  @description Haoxin.Liu
 *  @author HaoXin.Liu
 *  @date 2020/10/28 14:14
 **/
public class Person {

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getName().equals(person.getName()) &&
                getAge().equals(person.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }
}