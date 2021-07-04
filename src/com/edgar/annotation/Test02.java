package com.edgar.annotation;

import java.lang.annotation.*;

// 测试元注解
@MyAnnotation
public class Test02 {

    public void test() {

    }
}

// Target 表示我们的注解可以用在什么地方
@Target(value = {ElementType.METHOD, ElementType.TYPE})

// Retention 表示注解在什么地方有效。
// runtime > class > sources
@Retention(value = RetentionPolicy.RUNTIME)

// Documented 表示是否将注解生成在javadoc中
@Documented

// Inherited 子类可以继承父类的注解
@Inherited
@interface MyAnnotation{

}
