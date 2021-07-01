package com.web.chat;

public class TalkStudent {
    public static void main(String[] args) {
        // 开启两个线程
        new Thread(new TalkSend("localhost", "localhost", 7777, 9999)).start();
        new Thread(new TalkReceive(8888, "老师"));
    }
}
