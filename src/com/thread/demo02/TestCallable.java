package com.thread.demo02;

import com.thread.demo01.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

// 线程创建方法三：实现callable接口
/*
callable的好处
1. 可以定义返回值
2. 可以抛出异常
 */
public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCallable(String url, String name){
        this.name = name;
        this.url = url;
    }

    // 下载图片线程的执行体

    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为："+name);
        return true;
    }

    public static void main(String[] args) {
        TestCallable t1 = new TestCallable("https://i0.hdslb.com/bfs/sycp/creative_img/202012/c88395907fb0c3df0e93b5657ac331ce.jpg", "test1.jpg");
        TestCallable t2 = new TestCallable("https://i0.hdslb.com/bfs/sycp/creative_img/202012/c88395907fb0c3df0e93b5657ac331ce.jpg", "test2.jpg");
        TestCallable t3 = new TestCallable("https://i0.hdslb.com/bfs/sycp/creative_img/202012/c88395907fb0c3df0e93b5657ac331ce.jpg", "test3.jpg");

        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        // 获取结果
        try {
            boolean rs1 = r1.get();
            boolean rs2 = r2.get();
            boolean rs3 = r3.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 关闭服务
        ser.shutdown();
    }
}

class WebDownloader{
    public void downloader(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }

    }
}
