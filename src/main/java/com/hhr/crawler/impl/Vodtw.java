package com.hhr.crawler.impl;

import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.hhr.crawler.jsoup.JsoupOfVodtw;
import com.hhr.model.Book;

import java.io.IOException;
import java.util.List;

/**
 * @Author: Harry
 * @Date: 2019-05-24 20:32
 * @Version 1.0
 */
public class Vodtw extends BaseCrawlerImpl {

    @Override
    public List<Book> Searching(String searchContent) {

        try {
            // 获取指定网页实体
            HtmlPage page = this.getHtmlUnit().getHtmlPage("https://www.vodtw.com");

            // 获取搜索输入框
            HtmlInput input = (HtmlInput) page.getByXPath("//*[@id=\"searchwarpper\"]/form/ul/li[2]/input").get(0);

            input.setValueAttribute(searchContent);

            // 获取搜索按钮
            HtmlInput btn = (HtmlInput) page.getByXPath("//*[@id=\"Image12\"]").get(0);

            // “点击” 搜索
            HtmlPage page2 = btn.click();

            JsoupOfVodtw jsoupOfVodtw = new JsoupOfVodtw();

            String urls[] = jsoupOfVodtw.getBookUrl(page2.asXml());

//            String htmls[] = new String[urls.length];
//
//
//            for(int i = 0;i < htmls.length;i++){
//                htmls[i] = this.getHtmlUnit().getHtmlPage(urls[i]).asXml();
//            }

            this.setBookList(jsoupOfVodtw.AnalysisOfTheBook(urls));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.getBookList();
    }
}