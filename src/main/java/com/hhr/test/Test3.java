package com.hhr.test;

import com.hhr.model.Book;
import com.hhr.services.impl.VodtwService;

import java.util.List;

/**
 * @Author: Harry
 * @Date: 2019-05-25 00:54
 * @Version 1.0
 */
public class Test3 {
    public static void main(String[] args) {
        VodtwService vodtwService = new VodtwService();

        List<Book> BookList = vodtwService.getBookList("斗罗大陆");
        System.out.println(BookList);

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(BookList.size());
    }
}