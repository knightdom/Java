package com.web.chat;

import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiveDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);
        while (true) {
            // 准备接收包裹
            byte[] container = new byte[1024];
            
        }
    }
}
