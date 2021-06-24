package com.web.lesson3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

// 不需要连接服务器
public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception {
        // 1。 建立一个Socket
        DatagramSocket socket = new DatagramSocket();

        // 2. 建个包
        String msg = "你好，服务器";
        // 发送对象
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
        // 数据，数据的长度起始，要发送给谁
        DatagramPacket packet = new DatagramPacket(msg.getBytes(StandardCharsets.UTF_8), 0, msg.getBytes(StandardCharsets.UTF_8).length, localhost, port);

        // 3. 发送包
        socket.send(packet);

        // 4. 关闭流
        socket.close();
    }
}
