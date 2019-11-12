package com.java.konwledge.basicinfo.arithmetic.sort;

import lombok.extern.slf4j.Slf4j;

/**
 *  @dept 上海软件研发中心
 *  @description 选择排序
 *  @author HaoXin.Liu
 *  @date 2019/11/11 16:34
 **/
@Slf4j
public class ChoiceSort {
    /**
     * 冒泡排序实现过程
     *
     * @dept 上海软件研发中心
     * @param a 选择排序的数组
     * @author HaoXin.Liu
     * @date 2019/11/11 16:36
     **/
    public static void choiceSort(int[] a) {
        //选择排序 外部循环，通过循环每轮循环保证一个最小值 从小到大排序
        for (int i = 0; i < a.length - 1; i++) {
            int temp = i;
            //内部循环，进行标记排序，每轮找到做小的数组标记
            for (int j = i + 1; j < a.length; j++) {
                //判断标价位置是否为最小值，不是最小值的标记，把最小值的标记位置赋值给标记；
                if (a[temp] > a[j]) {
                    //标记为赋值
                    temp = j;
                }
            }
            //如果标记不等于外部循环，说明循环坐标不是最小的，需要交换；找到最小值赋值给外部循环的位置
            if (i != temp) {
                //符合条件的最小值进行交换
                int t = a[i];
                a[i] = a[temp];
                a[temp] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {30, 40, 60, 10, 20, 50};

        System.out.printf("before sort:");
        log.info(a.toString());
        printSortAy(a);

        //調用选择排序：核心只有这一个，其他的都是废话
        choiceSort(a);

        System.out.printf("after  sort:");
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