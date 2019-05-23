package com.hhr.services.impl;

import com.hhr.crawler.impl.Quanshuwang;
import com.hhr.model.Book;
import com.hhr.services.BaseService;

import java.util.List;

/**
 * @Author: Harry
 * @Date: 2019-05-23 14:06
 * @Version 1.0
 */
public class QuanshuwangService implements BaseService {
    private Quanshuwang quanshuwang;

    public QuanshuwangService(){
        quanshuwang = new Quanshuwang();
    }


    @Override
    public List<Book> getBookList(String searchContent){
        return quanshuwang.Searching(searchContent);
    }
}