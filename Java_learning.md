# Java学习笔记

## Java基础

### 1.  super注意点

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

### 2. 方法重写

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

### 3. 多态

注意事项：
1. 多态是方法的多态，属性没有多态
2. 父类和子类，有联系可以强制转换（类型转换异常 ClassCastException)
3. 存在条件：继承关系，方法需要重写，**父类引用指向子类对象**！ Father f1 = new son();

无法重写方法的例子：
1. static方法，属于类型，不属于实例
2. final 常量
3. private方法

### 4. static详解

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

### 5.多线程继承Thread类和Runnable接口的区别

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
### 6. lambda表达式

* lambda表达式只能有一行代码的情况下才能简化为一行，如果有多行，就只能用代码块包裹
* 前提是接口为函数式接口，即只有一个方法
* 多个参数也可以去掉参数类型，要去掉就都去掉，但必须加括号



## 注解与反射

### 1. 什么是注解（Annotation）

* Annotation的作用
  * 不是程序本身，可以对程序做出解释（和注释（comment）一样）
  * **可以被其他程序（如编译器等）读取**
* Annotation的格式
  * “@注释名”如@Override，也可以添加一些参数值，如：@SuppressWarnings(value="unchecked")

```java
// @SuppressWarning("all")  抑制所有告警
@SuppressWarnings("all")
public class Test01 extends Object{

    // @Override 重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    // @Deprecated 已经废弃，不推荐程序员使用，但是可以使用
    @Deprecated
    public static void test() {
        System.out.println("Deprecated");
    }

    public void test02() {
        ArrayList list = new ArrayList();
    }

    public static void main(String[] args) {
        test();
    }
}
```

### 2. 元注解

* 元注解负责注解其他的注解，Java中定义了4个标准的meta-annotation类型，用来提供对其他annotation类型作说明
* 在java.lang.annotation包中，包括**@Target, @Retention, @Documented, @Inherited**
  * **@Target**: 用于描述注解的使用范围（即，被描述的注解用在什么地方）
  * **@Retention**: 表示需要在什么级别保存该注释信息，用于描述注解饿生命周期（SOURCE < CLASS < RUNTIME)
  * @Documented: 说明该注解被包含在javadoc中
  * @Inherited: 说明子类可以继承父类中的该注解

### 3. 自定义注解

* @interface用来声明一个注解，格式：

  ```java
  public @interface 注解名 {
  	参数类型 参数名称() [default 默认参数值];
  }
  ```

   *如果在类中，去掉public*

* 如果只有一个参数成员，一般参数名为value

* 注解元素必须要有值，我们定义注解元素时，经常使用空字符串，0作为默认值

```java
public class Test03 {
    @MyAnnotation2(age = 18)  // 注释可以显示赋值，如果没有默认值，我们就必须给注解赋值
    public void test() {}

    @MyAnnotation3("Edgar")	// 调用时没有写参数名value
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
```

### 4. 反射概述

* Reflection（反射机制）允许程序在执行期间借助于Reflection API取得任何类的内部信息，并能直接操作任意对象的内部属性和方法
* 加载完类之后，在堆内存的方法区中就产生了一个Class类型的对象（**一个类只有一个class对象**），这个对象包含了完整的类的结构信息。可以通过这个对象看到类的结构。像一面镜子，因此称之为“反射”。

反射机制提供的**功能**：

* 在运行时判断任意一个对象所属的类
* 在运行时构造任意一个类的对象
* 在运行时判断任意一个类所具有的成员变量和方法
* 在运行时获取泛型信息
* 在运行时调用任意一个对象的成员变量和方法
* 在运行时处理注解
* 生成动态代理

### 5. 获取Class类的实例

1. 若已知具体的类，通过类的class**静态**属性获取，该方法最安全可靠，性能最好

2. 已知某个类的实例，调用该实例的getClass()方法获取Class对象

3. 已知一个类的全类名，且该类在类路径下，可通过Class类的**静态方法**forName()获取，可能抛出ClassNotFoundException

4. *内置*基本数据类型可以直接用类名.Type

   ```java
   // 测试Class类的创建方式
   public class Test03 {
       public static void main(String[] args) throws ClassNotFoundException {
           Person person = new Student();
           System.out.println("这个人是" + person.name);
   
           // 方式一：通过对象获得
           Class c1 = person.getClass();
           System.out.println(c1.hashCode());
   
           // 方式二：通过包名forname获得
           Class c2 = Class.forName("com.edgar.reflection.Student");
           System.out.println(c2.hashCode());
   
           // 方式三：通过类名.class获得（class是静态属性）
           Class c3 = Student.class;
           System.out.println(c3.hashCode());
   
           // 方式四：基本内置类型的包装类都有一个Type属性
           Class c4 = Integer.TYPE;
           System.out.println(c4.hashCode());
   
           // 获得父类类型
           Class c5 = c1.getSuperclass();
           System.out.println(c5);
       }
   }
   
   class Person {
       public String name;
   
       public Person() {
       }
   
       public Person(String name) {
           this.name = name;
       }
   
       @Override
       public String toString() {
           return "Person{" +
                   "name='" + name + '\'' +
                   '}';
       }
   }
   
   class Student extends Person{
       public Student() {
           this.name = "学生";
       }
   }
   
   class Teacher extends Person{
       public Teacher() {
           this.name = "老师";
       }
   }
   ```

### 6. 有Class对象的类型

```java
public class Test04 {
    public static void main(String[] args) {
        Class c1 = Object.class;        // 类
        Class c2 = Comparable.class;    // 接口
        Class c3 = String[].class;      // 一维数组
        Class c4 = int[][].class;       // 二维数组
        Class c5 = Override.class;      // 注解
        Class c6 = ElementType.class;   // 枚举
        Class c7 = Integer.class;       // 基本数据类型
        Class c8 = void.class;          // 空
        Class c9 = Class.class;         // Class类

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);
    }
}
```

**只要类型和维度一样，就是同一个Class对象**

### 7. 类的加载与ClassLoader的理解

1. **加载**：将class文件字节码内容加载到内存中，并将这些静态数据转换成方法区的运行时数据结构，然后生成一个代表这个类的java.lang.Class对象。（**在加载到内存时，生成Class对象**）
2. **链接**：将Java类的二进制代码合并到JVM的运行状态之中的过程
   1. 验证：确保加载的类信息符合JVM规范，没有安全方面的问题
   2. 准备：正式为类变量（static）分配内存并设置类变量默认初始值的阶段，这些内存都将在方法区中进行分配
   3. 解析：虚拟机常量池内的符号引用（常量名）替换为直接引用（地址）的过程。
3. **初始化**：（由JVM完成）
   1. 执行类构造器<clinit>()方法的过程。类构造器<clinit>()方法是由编译期自动收集类中所有类变量的赋值动作和静态代码块中的语句合并产生的。（类构造器是构造类信息的，不是构造该类对象的构造器）
   2. 当初始化一个类的时候，如果发现其父类还没有进行初始化，则需要先触发父类的初始化。
   3. 虚拟机会保证一个类的<clinit>()方法在多线程中被正确加锁和同步。

### 8. 类的初始化条件

* 类的主动引用（一定会发生类的初始化）
  * 当虚拟机启动时，先初始化main方法所在的类
  * new一个类的对象
  * 调用类的静态成员（除了final常量）和静态方法
  * 使用java.lang.reflect包的方法对类进行反射调用
  * 当初始化一个类，如果其父类没有被初始化，则先会初始化它的父类
* 类的被动引用（不会发生类的初始化）
  * 当访问一个静态域时，只有真正声明这个域的类才会被初始化。如：当通过子类引用父类的静态变量，不会导致子类初始化
  * 通过数组定义类引用，不会触发此类的初始化
  * 引用常量不会触发此类的初始化（常量在链接阶段就存入调用类的常量池中了）

### 9. 类加载器的作用

类加载器作用就是把类（class）装载到内存中。JVM定义了如下类型的类的加载器。

* 引导类加载器：用C++编写，是JVM自带的类加载器，**负责Java平台的核心库**，用来装载核心类库。该加载器无法直接获取（即rt.jar）
* 扩展类加载器：负责jre/lib/ext目录下的jar包或-D java.ext.dirs指定目录下的jar包装入工作库
* 系统类加载器：负责java -classpath 或 -D java.class.path所指的目录下的类与jar包装入工作，是最常用的加载器
