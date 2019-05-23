package com.hhr.crawler;

import com.hhr.model.Book;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public interface BaseCrawler {
    public List<Book> Searching(String searchContent);
}
