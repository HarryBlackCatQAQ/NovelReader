package com.hhr.util;

import com.hhr.javaFx.controller.SearchController;
import com.hhr.model.Book;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Harry
 * @Date: 2019/5/23 22:26
 * @Version 1.0
 */
public class DownUtil {
    private ExecutorService fixedThreadPool;
    private int threadPoolNum;

    public DownUtil(int threadPoolNum){
        this.threadPoolNum = threadPoolNum;
        fixedThreadPool = Executors.newFixedThreadPool(threadPoolNum);
    }


    public void DownImage(List<Book> BookList,SearchController searchController){
        for(Book book : BookList){
            fixedThreadPool.execute(new Thread(()->{
                try {
                    File file = new File(IoUtil.imagePath() + book.getImageName());

                    if(file.exists()){
                        System.out.println(book.getImageName() + " 已存在!");
                    }
                    else{
                        IoUtil.writeImage(NetUtil.getImageInputStream(book.getImageUrl()),
                                book.getImageName(),
                                IoUtil.imagePath());

                        System.out.println(book.getImageName() + "   下载成功！");
                    }


                } catch (IOException e) {
//                    e.printStackTrace();
                    System.out.println("图片加载不到 1");
                }

                searchController.doServiceLater();
//                System.out.println(searchController + "  2");
//                System.out.println("ok");
            }));
        }

        fixedThreadPool.shutdown();
    }
}
