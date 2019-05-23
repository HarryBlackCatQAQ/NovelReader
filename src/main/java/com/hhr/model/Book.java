package com.hhr.model;

/**
 * @Author: Harry
 * @Date: 2019-05-23 12:56
 * @Version 1.0
 */
public class Book  {
    private String imageUrl;
    private String name;
    private String author;
    private String url;


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "Book{" +
                "imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}