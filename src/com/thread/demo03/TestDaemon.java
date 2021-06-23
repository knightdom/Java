package com.thread.demo03;

// 测试守护进程
// 上帝守护你
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        Me me = new Me();

        Thread thread = new Thread(god);
        thread.setDaemon(true); // 默认是false，表示是用户线程，正常的线程都是用户线程

        thread.start();

        new Thread(me).start(); // 用户线程
    }
}

// 上帝
class God implements Runnable{
    @Override
    public void run(){
        while (true) {
            System.out.println("上帝保佑我");
        }
    }
}

// 我
class Me implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("我快乐地活着");
        }
        System.out.println("========== GoodBye World! ==========");
    }
}