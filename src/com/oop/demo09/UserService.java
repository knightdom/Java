package com.oop.demo09;

// interface定义的关键字，接口都需要有实现类
public interface UserService {
    // 定义的属性都是常量 public static final
    int AGE = 99;   // 一般都

    // 接口中的所有定义的方法其实都是抽象的 public abstract
    void add(String name);
    void delete(String name);
    void update(String name);
    void query(String name);
}
