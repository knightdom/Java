package com.oop.demo08;

// abstract 抽象类： 类是用extends来继承，并且是单继承， （接口可以多继承）
public abstract class Action {

    // 约束，子类来实现
    // abstract, 抽象方法，只有方法名字，没有方法的实现
    public abstract void doSomething();

    // 1. 不能new这个抽象类，只能考子类去实现它。约束
    // 2. 抽象类中可以写普通的方法
    // 3. 抽象方法必须在抽象类中
}
