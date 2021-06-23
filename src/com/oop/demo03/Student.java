package com.oop.demo03;

public class Student extends Person{
    public Student(){
        // 隐藏super()代码：调用了父类的无参构造
        super();    // 调用父类的构造器，必须在子类构造器的第一行
        System.out.println("Student无参构造被执行了");
    }
    private String name = "Edgar";

    public void print(String name){
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }
}
