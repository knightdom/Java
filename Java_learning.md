# Java学习笔记

## 1.  super注意点

* super调用父类的构造方法，必须放在子类的构造方法中第一个
* super必须只能出现在子类的方法或者构造方法中
* super和this不能同时调用构造方法

**VS this**

代表的对象不同：
* this: 本身调用这个对象
* super: 代表父类对象的应用

前提：
* this: 没有继承也可以使用
* super: 只能在继承条件才可以使用

构造方法：
* this(): 本类的构造
* super(): 父类的构造

*具体参看./src/com/oop/demo03*

## 2. 方法重写

需要有继承关系，子类重写父类的**方法**
* 方法名必须相同
* 参数列表必须相同
* 方法必须是非静态的
* 修饰符：范围可以扩大但不能缩小：    public > protected > default > private （例如，父类是private，子类可以扩大到default；反之不行）
* 抛出的异常：范围可以被缩小，但不能扩大（子类是ClassNotFoundException，父类是Exception；反之不行）

重写：子类的方法和父类必须一致，但**方法体**不同

为什么需要重写：
* 父类的功能，子类不一定需要，或者不一定满足

重载和重写的区别：
重载是指，在一个类中，有多个方法名相同，但是参数不同的方法
重写是指，在父类和子类中，各有一个方法名相同的方法，但内容不同

*具体参看./src/com/oop/demo04*

## 3. 多态

注意事项：
1. 多态是方法的多态，属性没有多态
2. 父类和子类，有联系可以强制转换（类型转换异常 ClassCastException)
3. 存在条件：继承关系，方法需要重写，**父类引用指向子类对象**！ Father f1 = new son();

无法重写方法的例子：
1. static方法，属于类型，不属于实例
2. final 常量
3. private方法

## 4. static详解

```java
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
```
结果返回：
```shell
静态代码块
匿名代码块
构造方法
==============
匿名代码块
构造方法
```
**静态代码块**只执行一次

## 5.多线程继承Thread类和Runnable接口的区别

* 继承Thread类
    * 子类继承Thread类具备多线程能力
    * 启动线程：子类对象.start()
    * 不建议使用：**避免OOP单继承局限性**
*具体参看：./src/com/thread.demo01/TestThread1*
* 实现Runnable接口
    * 实现接口Runnable具有多线程能力
    * 启动线程：传入目标对象+Thread对象.start()
    * 推荐使用：避免单继承局限性，灵活方便，方便同一个对象被多个线程使用
*具体参看：./src/com/thread.demo01/TestThread2*
      
## 6. lambda表达式

* lambda表达式只能有一行代码的情况下才能简化为一行，如果有多行，就只能用代码块包裹
* 前提是接口为函数式接口，即只有一个方法
* 多个参数也可以去掉参数类型，要去掉就都去掉，但必须加括号