package com.web.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable{
    private DatagramSocket socket = null;
    private int port;
    private String msgFrom;

    public TalkReceive(int port, String msgFrom) {
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 准备接收包裹
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);

                byte[] data = packet.getData();
//            String receiveData = new String(data, 0, data.length);
                String receiveData = new String(data, 0, packet.getLength());   //需要使用packet.getLength()而不是data.length，使用data.length会导致有很多空格生成

                System.out.println(msgFrom+":"+receiveData);
                // 断开连接 bye
                if(receiveData.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
