package com.oop.demo04;



// 静态方法和非静态的方法区别很大
// 静态方法：方法的调用只和左边定义的数据类型有关
// 非静态方法：重写
public class Application {
    public static void main(String[] args) {
        // 方法的调用只和左边定义的数据类型有关
        A a = new A();
        a.test();

        // 父类的引用指向了子类
        B b = new A();
        b.test();
    }
}
