package com.hhr.crawler.impl;

import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.hhr.crawler.BaseCrawler;
import com.hhr.crawler.HtmlUnit;
import com.hhr.crawler.MyJsoup;
import com.hhr.model.Book;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Harry
 * @Date: 2019-05-23 13:11
 * @Version 1.0
 */
public class Quanshuwang extends BaseCrawlerImpl {

    @Override
    public List<Book> Searching(String searchContent){
        HtmlUnit htmlUnit = new HtmlUnit();
        MyJsoup myJsoup = new MyJsoup();

        try {
            HtmlPage page = htmlUnit.getHtmlPage("http://www.quanshuwang.com/");

            // 获取搜索输入框
            HtmlInput input = (HtmlInput) page.getHtmlElementById("bdcsMain");

            // 往输入框 “填值”
            input.setValueAttribute(searchContent);

            // 获取搜索按钮
            HtmlInput btn = (HtmlInput) page.getHtmlElementById("searchbuttom");

            // “点击” 搜索
            HtmlPage page2 = btn.click();

            this.setBookList(myJsoup.AnalysisOfTheBook(page2.asXml(),"quanshuwang"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return this.getBookList();
        }

    }
}