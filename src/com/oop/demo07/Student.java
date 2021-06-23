package com.oop.demo07;

public class Student {
    // 2：赋初值
    {
        System.out.println("匿名代码块");
    }

    // 1: 只执行一次
    static {
        System.out.println("静态代码块");
    }

    // 3
    public Student() {
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println("==============");
        Student student1 = new Student();
    }
}
