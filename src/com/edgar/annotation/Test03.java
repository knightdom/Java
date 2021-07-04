package com.edgar.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test03 {
    @MyAnnotation2(age = 18)  // 注释可以显示赋值，如果没有默认值，我们就必须给注解赋值
    public void test() {}

    @MyAnnotation3("Edgar") // 调用时没有写参数名value
    public void test01() {}
}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    // 注解的参数：参数类型 + 参数名();
    String name() default "";
    int age();
    int id() default -1;    // 如果默认值为-1，表示不存在
    String[] schools() default {"UNSW", "UTS"};
}

// 一个参数的注解
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value(); // 如果只有一个参数，用value作参数名，可以在调用时，不用写参数名
}