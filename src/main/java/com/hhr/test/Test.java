package com.hhr.test;

import com.hhr.crawler.BaseCrawler;
import com.hhr.crawler.impl.Quanshuwang;
import com.hhr.jache.JCache;
import com.hhr.test.thread.MyThread;
import com.hhr.util.IoUtil;
import com.hhr.util.NetUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Harry
 * @Date: 2019-05-23 13:20
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
//        BaseCrawler quanshuwang = new Quanshuwang();
//
//        quanshuwang.Searching("斗罗大陆");


//        File file2 = new File(IoUtil.getCachePath());
//        System.out.println(file2);
//        JCache jCache=JCache.get(file2);//创建缓存对象
//        jCache.put("dasdas","999999");//缓存信息
//        String data=jCache.getAsString("dasdas");//获取缓存信息
//        System.out.println(data);
//
//        jCache.put("2",new BufferedImage());

//        MyThread myThreads[] = new MyThread[10];
//        for(int i = 0;i < 10;i++){
//            myThreads[i] = new MyThread(String.valueOf(i + 1),25);
//        }
//
//        myThread1.start();
//        myThread2.start();
//        myThread3.start();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 10; i++) {
//            final int index = i;
//
//            fixedThreadPool.execute(myThreads[index]);
////            fixedThreadPool.execute(new Runnable() {
////                public void run() {
////                    System.out.println(index);
//////                    try {
//////                        System.out.println(index);
//////                        Thread.sleep(2000);
//////                    } catch (InterruptedException e) {
//////                        e.printStackTrace();
//////                    }
////                }
////            });
//        }

//        IoUtil.writeImage();



//        try {
//            IoUtil.writeImage(NetUtil.getImageInputStream("http://img.quanshuwang.com/image/168/168595/168595s.jpg"),
//                    "1.jpg",
//                    IoUtil.imagePath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        String url[] = new String[5];
        url[0] = "http://img.quanshuwang.com/image/168/168595/168595s.jpg";
        url[1] = "http://img.quanshuwang.com/image/175/175310/175310s.jpg";
        url[2] = "http://img.quanshuwang.com/image/106/106281/106281s.jpg";
        url[3] = "http://img.quanshuwang.com/image/143/143815/143815s.jpg";
        url[4] = "http://img.quanshuwang.com/image/149/149816/149816s.jpg";

        System.out.println(IoUtil.getSuffix(url[0]));


//        for(int i = 0;i < 5;i++){
//            final int index = i;
//            fixedThreadPool.execute(new Thread(()->{
//                try {
//                    IoUtil.writeImage(NetUtil.getImageInputStream(url[index]),
//                            String.valueOf(index + 1) + ".jpg",
//                            IoUtil.imagePath());
//                    System.out.println("Thread" + (index + 1) + " die");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }));
//        }
    }
}