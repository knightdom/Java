package com.oop.demo01;

public class Person {
    // 1. 一个类即使什么都不写，也会存在一个方法

    // 2. 显示的定义构造器
    String name;

    // 实例化初始值
    // 2.1. 无参构造器
    public Person(){
        this.name = "Edgar Fang";
    }

    // 2.2. 有参构造器
    public Person(String name){
        this.name = name;
    }

    // 3. alt+insert 通过变量名自动生成有参构造器

    /**
     * 构造器
     *      1. 和类名相同
     *      2. 没有返回值类型，且不能用void
     * 作用
     *      1. new本质在调用构造方法
     *      2. 初始化对象的值
     * 注意点
     *      定义有参构造之后，如果想使用无参构造，需要显式定义一个无参构造
     */

}
