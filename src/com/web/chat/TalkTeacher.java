package com.web.chat;

public class TalkTeacher {
    public static void main(String[] args) {
        // 开启两个线程
        new Thread(new TalkSend("localhost", "localhost", 5555, 8888)).start();
        new Thread(new TalkReceive(9999, "学生"));
    }
}
