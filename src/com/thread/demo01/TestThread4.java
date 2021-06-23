package com.thread.demo01;

public class TestThread4 implements Runnable{
    private int ticketNums = 10;

    @Override
    public void run() {
        while(true){
            if(ticketNums <= 0){
                break;
            }
            // 模拟延时200ms
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNums--+"张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 t4 = new TestThread4();
        new Thread(t4, "小明").start();
        new Thread(t4, "老师").start();
        new Thread(t4, "黄牛党").start();
    }
}
