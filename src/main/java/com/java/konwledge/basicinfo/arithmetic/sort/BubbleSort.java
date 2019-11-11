package com.java.konwledge.basicinfo.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 *  @dept 上海软件研发中心
 *  @description 冒泡排序实现
 *  @author HaoXin.Liu
 *  @date 2019/11/8 9:16
 **/
@Slf4j
public class BubbleSort {
    /**
     * 冒泡排序实现过程
     *
     * @dept 上海软件研发中心
     * @param a 需要排序的数组
     * @author HaoXin.Liu
     * @date 2019/11/8 9:16
     **/
    public static void bubbleSort(int[] a) {
        //结束递归的条件

    }

    public static void main(String[] args) {
        int i;
        int[] a = {30, 40, 60, 10, 20, 50};
        //输出排序之前的
        System.out.printf("before sort:");
        log.info(a.toString());
        //输出排序数组
        printSortAy(a);
        //調用冒泡排序：核心只有这一个，其他的都是废话
        bubbleSort(a);

        System.out.printf("after  sort:");
        //输出排序数组
        printSortAy(a);
    }

    private static void printSortAy(int[] a) {
        int i;
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");
    }
}