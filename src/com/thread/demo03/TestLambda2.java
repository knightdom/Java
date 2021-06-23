package com.thread.demo03;

public class TestLambda2 {
    public static void main(String[] args) {
        // 1. lambda表达式简化
        ILove love = (int a)->{
            System.out.println("I love you -->"+a);
        };

        // 2. 参数类型简化
        love = (a)->{
            System.out.println("I love you -->"+a);
        };

        // 3. 简化括号，只能有一个参数
        love = a -> {
            System.out.println("I love you -->"+a);
        };

        // 4. 简化花括号，这个简化的方法love中只能有一行的代码，如果有多行，就只能用代码块包裹即3
        love = a -> System.out.println("I love you -->"+a);

        love.love(520);
    }
}

interface ILove{
    void love(int a);
}
