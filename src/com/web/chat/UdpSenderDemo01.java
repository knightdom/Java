package com.web.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UdpSenderDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        // 准备数据：控制台读取System.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String data = reader.readLine();
<<<<<<< HEAD
            byte[] datas = data.getBytes();
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));
            socket.send(packet);

            if (data.equals("bye")) {
=======
            byte[] datas = data.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));
            socket.send(packet);

            if(data.equals("bye")) {
>>>>>>> master
                break;
            }
        }

        socket.close();
    }
}
