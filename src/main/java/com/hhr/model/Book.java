package com.hhr.model;

import com.hhr.util.IoUtil;

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
    private String imageName;


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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getAutoImageName(){
        return getName() + "-" + getAuthor() + IoUtil.getSuffix(getImageUrl());
    }

    @Override
    public String toString() {
        return "Book{" +
                "imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}