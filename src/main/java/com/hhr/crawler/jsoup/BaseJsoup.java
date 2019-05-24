package com.hhr.crawler.jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @Author: Harry
 * @Date: 2019-05-25 00:25
 * @Version 1.0
 */
public class BaseJsoup {
    private Document document;
    private Elements elements;


    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Elements getElements() {
        return elements;
    }

    public void setElements(Elements elements) {
        this.elements = elements;
    }
}