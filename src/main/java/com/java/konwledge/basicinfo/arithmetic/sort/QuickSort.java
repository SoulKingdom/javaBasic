package com.java.konwledge.basicinfo.arithmetic.sort;


import lombok.extern.slf4j.Slf4j;
/**
 *  @dept 上海软件研发中心
 *  @description 快速排序
 *  @author HaoXin.Liu
 *  @date 2019/11/5 17:19
 **/
@Slf4j
public class QuickSort {

    public static void quickSort(int[] a, int l, int r) {
        //结束递归的条件
        if (l < r) {
            //定义临时变量，i和j是临时的左和右,x作为临时基准数;
            int i, j, x;
            //左右位置进行设置
            i = l;
            j = r;
            //将左边的第一个数作为基准数进行传递
            x = a[i];
            //执行条件：左边的标记必须小于右边的标记
            while (i < j) {
                //左边不动，从右向左找，找到比基准数小的数为止，如果数比基数大或相等，j（右标记）向左移动，反之结束
                while (i < j && a[j] > x) {
                    j--;
                }
                //从右向左找，找到比基数小的数，把比基数小的数赋值给左边的位置，并且左边的位置+1（i(左游标)向右移动一位）
                if (i < j) {
                    a[i++] = a[j];
                }
                //右边不动，从左向右找，找到比基准数大的数为止，如果数比基数小或相等，i（左标记）向右移动，反之结束
                while (i < j && a[i] < x) {
                    i++; // 从左向右找第一个大于x的数
                }
                //从左向左找，找到比基数小的数，把比基数小的数赋值给左边的位置，并且左边的位置+1
                if (i < j) {
                    a[j--] = a[i];
                }
            }
            a[i] = x;
            //递归调用 比基数小的分一组（基数左边的分组）
            quickSort(a, l, i - 1);
            // 递归调用 比基数大的分一组（基数右边的分组）
            quickSort(a, i + 1, r);
        }
    }

    public static void main(String[] args) {
        int i;
        int[] a = {30, 40, 60, 10, 20, 50};

        System.out.printf("before sort:");
        log.info(a.toString());
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");
        //調用快速排序：核心只有这一个，其他的都是废话
        quickSort(a, 0, a.length - 1);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");
    }
}