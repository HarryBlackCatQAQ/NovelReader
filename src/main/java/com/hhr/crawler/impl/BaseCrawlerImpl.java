package com.hhr.crawler.impl;

import com.hhr.crawler.BaseCrawler;
import com.hhr.crawler.HtmlUnit;
import com.hhr.crawler.MyJsoup;
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
    private HtmlUnit htmlUnit = null;
    private MyJsoup myJsoup = null;

    public BaseCrawlerImpl(){
        BookList = new LinkedList<Book>();
        htmlUnit = new HtmlUnit();
        myJsoup = new MyJsoup();
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

    public HtmlUnit getHtmlUnit() {
        return htmlUnit;
    }

    public void setHtmlUnit(HtmlUnit htmlUnit) {
        this.htmlUnit = htmlUnit;
    }

    public MyJsoup getMyJsoup() {
        return myJsoup;
    }

    public void setMyJsoup(MyJsoup myJsoup) {
        this.myJsoup = myJsoup;
    }
}