package com.hhr.test;

import com.hhr.crawler.BaseCrawler;
import com.hhr.crawler.impl.Quanshuwang;
import com.hhr.jache.JCache;
import com.hhr.util.IoUtil;

import java.io.File;

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

        File file = new File("/Users/harry/ddd");
        File file2 = new File(IoUtil.getCachePaht());
        System.out.println(file2);
        JCache jCache=JCache.get(file2);//创建缓存对象
        System.out.println(file);
        jCache.put("dasdas","dasdasdas");//缓存信息
        String data=jCache.getAsString("dasdas");//获取缓存信息
        System.out.println(data);

    }
}