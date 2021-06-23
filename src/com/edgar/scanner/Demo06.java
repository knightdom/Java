package com.edgar.scanner;

import java.util.Arrays;

public class Demo06 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        System.out.println(a);
        System.out.println(Arrays.toString(a));
        int[] b = {43,646,232,1,5567,54,654,34345};
        b = mpSort(b);
        System.out.println(Arrays.toString(b));
    }

    // 冒泡排序
    public static int[] mpSort(int[] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j=0; j < a.length-1-i; j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }
}
