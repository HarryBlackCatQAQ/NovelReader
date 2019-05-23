package com.hhr.services;

import com.hhr.model.Book;

import java.util.List;

public interface BaseService {
    public List<Book> getBookList(String searchContent);
}
