package com.annotation;

import java.util.ArrayList;

// 什么是注解
// @SuppressWarning("all")  抑制所有告警
@SuppressWarnings("all")
public class Test01 extends Object{

    // @Override 重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    // @Deprecated 已经废弃，不推荐程序员使用，但是可以使用
    @Deprecated
    public static void test() {
        System.out.println("Deprecated");
    }

    public void test02() {
        ArrayList list = new ArrayList();
    }

    public static void main(String[] args) {
        test();
    }
}
