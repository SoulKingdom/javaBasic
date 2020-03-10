package com.java.konwledge.basicinfo.javabasic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  @dept 上海软件研发中心
 *  @description 线程池
 *  @author HaoXin.Liu
 *  @date 2020/3/9 10:10
 **/
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> System.out.println("hello"));
    }
}