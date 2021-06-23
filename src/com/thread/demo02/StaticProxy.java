package com.thread.demo02;

/**
 * 静态代理总结：
 * 真实对象和代理对象都要实现同一个接口
 * 代理对象要代理真实角色
 * 使用runnable来调用多线程就是用静态代理实现，因为Thread类也是继承Runnable接口
 *
 * 好处：
 *  代理对象可以做很多真实对象做不了的事情
 *  真实对象专注做自己的事情
 */
public class StaticProxy {
    public static void main(String[] args) {
        WeddingCom weddingCom = new WeddingCom(new You());
        weddingCom.HappyMarry();
    }

}

interface Marry{
    void HappyMarry();
}

// 真实角色
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("我要结婚了！");
    }
}

// 代理角色
class WeddingCom implements Marry{
    private Marry target;

    public WeddingCom(Marry target){
        this.target = target;
    }

    @Override
    public void HappyMarry(){
        before();
        this.target.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("婚庆公司布置现场");
    }

    private void after() {
        System.out.println("婚庆公司收尾款");
    }
}