package com.hhr.crawler.impl;

import com.hhr.crawler.BaseCrawler;
import com.hhr.model.Book;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Harry
 * @Date: 2019-05-23 13:26
 * @Version 1.0
 */
public class BaseCrawlerImpl implements BaseCrawler {
    private List<Book> BookList = null;

    public BaseCrawlerImpl(){
        BookList = new LinkedList<Book>();
    }

    @Override
    public List<Book> Searching(String searchContent) {
        return null;
    }

    public List<Book> getBookList() {
        return BookList;
    }

    public void setBookList(List<Book> bookList) {
        BookList = bookList;
    }
}