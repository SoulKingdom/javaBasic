package com.java.konwledge.basicinfo.test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  @dept 上海软件研发中心
 *  @description 线程池测试
 *  @author HaoXin.Liu
 *  @date 2020/3/19 9:37
 **/
public class ThreadTest {
    public static final Logger logger = LoggerFactory.getLogger(ThreadTest.class);
    /**
     * 设置线程池
     */
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            5, 10, 60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10),
            new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build(),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < 21; i++) {
            Runnable runnable = () -> {
                logger.info("线程[{}]执行中", Thread.currentThread().getName());
                try {
                    Thread.sleep(300);
                    logger.info("线程【{}】执行结束",Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            logger.info("============>>{}", i);
            executor.execute(runnable);
            logger.info("线程池中活跃的线程数：[{}]", executor.getPoolSize());
            if (executor.getQueue().size() > 0) {
                logger.info("----------------队列中阻塞的线程数[{}]", executor.getQueue().size());
            }
        }
        //线程池关闭
        logger.info("线程【{}】关闭", Thread.currentThread().getName());
        executor.shutdown();
    }
}