package com.java.konwledge.basicinfo.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;

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
        //冒泡排序，外部循环，每次循环将最大的数据移动至末尾；从小到大排序
        for (int i = 0; i < a.length - 1; i++) {
            //内部循环，每次互换两两进行比较和交换，最大值移至末尾之后，末尾坐标减一
            for (int j = 0; j < a.length - 1 - i; j++) {
                //如果前面的数比后面的数打，进行交换
                if (a[j] > a[j + 1]) {
                    //进行交换
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    //交换之后进行下次比较
                    continue;
                }
            }
        }
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