package com.hhr.services.impl;

import com.hhr.crawler.impl.Vodtw;
import com.hhr.model.Book;
import com.hhr.services.BaseService;

import java.util.List;

/**
 * @Author: Harry
 * @Date: 2019-05-25 00:56
 * @Version 1.0
 */
public class VodtwService implements BaseService {
    private Vodtw vodtw;

    public VodtwService(){
        vodtw = new Vodtw();
    }

    @Override
    public List<Book> getBookList(String searchContent) {
        return vodtw.Searching(searchContent);
    }
}