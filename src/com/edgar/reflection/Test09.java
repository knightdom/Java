package com.edgar.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 通过反射，动态的创建对象
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 获得class对象
        Class<?> c1 = Class.forName("com.edgar.reflection.User");
        // 构造一个对象
        User user = (User)c1.newInstance();         // 本质是调用了类的无参构造器
        System.out.println(user);
        
        // 通过构造器创建对象
        Constructor<?> constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);

        // 构造一个对象
        User edgar = (User) constructor.newInstance("Edgar", 001, 18);
        System.out.println(edgar);

        // 通过反射调用普通方法
        User user3 = (User)c1.newInstance();
        // 通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        // invoke: 激活的意思，参数为(对象， 该方法的参数)
        setName.invoke(user3, "方得着");
        System.out.println(user3.getName());

        // 通过反射操作属性
        User user4 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");

        // 不能直接操作私有属性，需要关闭程序的安全检测，属性或方法的setAccessible(true)
        name.setAccessible(true);   // 将私有的属性的可设置功能变为true
        name.set(user4, "方得着2");
        System.out.println(user4.getName());
    }
}
