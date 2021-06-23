package com.web.lesson2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpServerDemo02 {
    public static void main(String[] args) throws Exception {
        // 1. 创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        // 2. 监听客户端的连接
        Socket socket = serverSocket.accept();// 阻断式监听，会一直等待客户端连接
        // 3. 获取输入流
        InputStream is = socket.getInputStream();
        // 4. 文件输出
        FileOutputStream fos = new FileOutputStream("receive.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        // 通知客户端接收完毕
        OutputStream os = socket.getOutputStream();
        os.write("接收完毕".getBytes(StandardCharsets.UTF_8));

        // 关闭资源
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
