package com.hhr.jsoup.model;

/**
 * @Author: Harry
 * @Date: 2019/5/20 13:24
 * @Version 1.0
 */
public class Chapter {
    private String url;
    private String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Chapter{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
