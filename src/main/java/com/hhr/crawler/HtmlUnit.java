package com.hhr.crawler;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

/**
 * @Author: Harry
 * @Date: 2019-05-23 13:16
 * @Version 1.0
 */
public class HtmlUnit {

    public HtmlPage getHtmlPage(String url){
        // 创建webclient
        WebClient webClient = new WebClient();
        // 取消 JS 支持
        webClient.getOptions().setJavaScriptEnabled(false);
        // 取消 CSS 支持
        webClient.getOptions().setCssEnabled(false);

        // 获取指定网页实体
        HtmlPage page = null;
        try {
            page = (HtmlPage) webClient.getPage("http://www.quanshuwang.com/");
        } catch (IOException e) {
            e.printStackTrace();
        }


        return page;
    }
}