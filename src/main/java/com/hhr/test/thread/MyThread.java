package com.hhr.test.thread;

/**
 * @Author: Harry
 * @Date: 2019/5/23 22:02
 * @Version 1.0
 */
public class MyThread extends Thread {

    private String name;
    private int num;

    public MyThread(){

    }

    public MyThread(String name,int num){
        this.name = name;
        this.num = num;
        System.out.println("Creating Thread" +  name );
    }

    @Override
    public synchronized void start() {
        super.start();
        System.out.println("Thread" +  name  + "Start");
    }

    @Override
    public void run() {
        super.run();
        for(int i = 0;i < num;i++){
            System.out.println("Thread" +  name + ": " + i);
        }
    }
}
