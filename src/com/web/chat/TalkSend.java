package com.web.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class TalkSend implements Runnable{
    private String fromIP;
    private String toIP;
    private int fromPort;
    private int toPort;

    private DatagramSocket socket = null;
    private BufferedReader reader = null;

    public TalkSend(String fromIP, String toIP, int fromPort, int toPort) {
        this.fromIP = fromIP;
        this.toIP = toIP;
        this.fromPort = fromPort;
        this.toPort = toPort;

        try {
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                String data = reader.readLine();
                byte[] datas = data.getBytes(StandardCharsets.UTF_8);
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIP, this.toPort));
                socket.send(packet);

                if(data.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        socket.close();
    }
}
