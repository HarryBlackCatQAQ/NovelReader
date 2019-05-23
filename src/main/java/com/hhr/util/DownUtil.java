package com.hhr.util;

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


    public void DownImage(List<Book> BookList){
        for(Book book : BookList){
            fixedThreadPool.execute(new Thread(()->{
                try {
                    String imageName = book.getName() + "-" + book.getAuthor() + IoUtil.getSuffix(book.getImageUrl());

                    File file = new File(IoUtil.imagePath() + imageName);

                    if(file.exists()){
                        System.out.println(imageName + " 已存在!");
                    }
                    else{
                        IoUtil.writeImage(NetUtil.getImageInputStream(book.getImageUrl()),
                                imageName,
                                IoUtil.imagePath());

                        System.out.println(imageName + "   下载成功！");
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));
        }
    }
}
