package com.web.lesson2;
/**
 * TCP实现聊天，和TcpServerDemo01.java
 */

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class TcpClientDemo01 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try {
            // 1. 客户端需要知道服务器的地址，端口号
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;

            // 2. 创建一个socket连接
            socket = new Socket(serverIP, port);

            // 3. 发送消息 IO流
            os = socket.getOutputStream();
            os.write("坚持学习Java".getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
