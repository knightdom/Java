package com.thread.demo03;

/**
 * Join合并线程，待此线程执行完成后，才能执行其他线程，其他线程阻塞
 */
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip --> "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 2000; i++) {
            if (i == 200){
                thread.join();
            }
            System.out.println("main --> " + i);
        }
    }
}
