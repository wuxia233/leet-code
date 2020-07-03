package cn.wuxia.leetcode.java;

/**
 * @Author: WuXia
 * @Email: wuxia1@szunicom.com
 * @Date: 2020/6/10 11:36
 * 大家可以把这行代码注释以后看看运行效果，在没有加join的时候运行的结果是不确定的。
 * 加了join以后，运行结果按照递增的顺序展示出来。
 */
public class JoinDemo extends Thread{
    int i;
    Thread previousThread; //上一个线程
    public JoinDemo(Thread previousThread,int i){
        this.previousThread=previousThread;
        this.i=i;
    }
    @Override
    public void run() {
        try {
            //调用上一个线程的join方法，大家可以自己演示的时候可以把这行代码注释掉
            previousThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num:"+i);
    }
    public static void main(String[] args) {
        Thread previousThread=Thread.currentThread();
        for(int i=0;i<10;i++){
            JoinDemo joinDemo=new JoinDemo(previousThread,i);
            joinDemo.start();
            previousThread=joinDemo;
        }
    }
}

