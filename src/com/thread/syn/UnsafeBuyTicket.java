package com.thread.syn;

// 不安全的取钱
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "Me").start();
        new Thread(buyTicket, "You").start();
        new Thread(buyTicket, "Agency").start();
    }
}

class BuyTicket implements Runnable {
    private int ticketNums = 10;
    boolean flag = true;    // 外部停止标志

    @Override
    public void run() {
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void buy() throws InterruptedException {
        if (ticketNums <= 0) {
            flag = false;
            return;
        } else {
            Thread.sleep(100);  // sleep可以放大问题的发生性
            System.out.println(Thread.currentThread().getName() + "买了第" + ticketNums-- + "张票");
        }
    }
}
