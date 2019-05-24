package com.hhr.thread;

import com.hhr.javaFx.controller.SearchController;
import com.hhr.model.Book;
import com.hhr.util.IoUtil;
import com.hhr.util.NetUtil;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Harry
 * @Date: 2019-05-24 14:26
 * @Version 1.0
 */
public class IamgeDownloadThread extends Thread{
    private Book book;
    private SearchController searchController;


    public IamgeDownloadThread(Book book,SearchController searchController){
        this.book = book;
        this.searchController = searchController;
    }


    @Override
    public void run() {
//        System.out.println("运行了！");
//        try {
//            File file = new File(IoUtil.imagePath() + book.getImageName());
//
//            if(file.exists()){
//                System.out.println(book.getImageName() + " 已存在!");
//            }
//            else{
//                IoUtil.writeImage(NetUtil.getImageInputStream(book.getImageUrl()),
//                        book.getImageName(),
//                        IoUtil.imagePath());
//
//                System.out.println(book.getImageName() + "   下载成功！");
//            }
//
//
//        } catch (IOException e) {
////                    e.printStackTrace();
//            System.out.println("图片加载不到 1");
//        }
//
//        searchController.doServiceLater();
//        System.out.println("运行了！222");
    }
}