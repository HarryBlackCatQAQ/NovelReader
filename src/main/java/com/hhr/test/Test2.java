package com.hhr.test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Harry
 * @Date: 2019-05-24 16:52
 * @Version 1.0
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        // 创建webclient
        WebClient webClient = new WebClient();
        // 取消 JS 支持
        webClient.getOptions().setJavaScriptEnabled(false);
        // 取消 CSS 支持
        webClient.getOptions().setCssEnabled(false);

        // 获取指定网页实体
        HtmlPage page = (HtmlPage) webClient.getPage("https://www.vodtw.com");

        // 获取搜索输入框
        HtmlInput input = (HtmlInput) page.getByXPath("//*[@id=\"searchwarpper\"]/form/ul/li[2]/input").get(0);

        input.setValueAttribute("斗罗大陆");

        // 获取搜索按钮
        HtmlInput btn = (HtmlInput) page.getByXPath("//*[@id=\"Image12\"]").get(0);

        // “点击” 搜索
        HtmlPage page2 = btn.click();

//        System.out.println(page2.asXml());

        Document document = Jsoup.parse(page2.asXml());

        String url = "https://www.vodtw.com/";
        Elements elements = document.select("#CListTitle > a:nth-child(1)");
        String urls[] = new String[elements.size()];
        HtmlPage pages[] = new HtmlPage[elements.size()];
        int counter = 0;
        System.out.println("size:" + elements.size());

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);

        for(Element element : elements){
//            urls[counter++] = url + element.attr("href");
            String url1 = url + element.attr("href");
            counter++;
            final int idx = counter - 1;
            HtmlPage page1 = webClient.getPage(url1);


            fixedThreadPool.execute(new Thread(()->{
//                System.out.println(idx);
                System.out.println(page1 + " idx:" + idx);
                Document document2 = Jsoup.parse(page1.asXml());
                Element element2 = document2.select("body > div.wrapper_list > div.bookinfo.clearfix > div.bookpic > img").get(0);
                Element element1 = document2.select("body > div.wrapper_list > div.bookinfo.clearfix > div.bookdetail > ul > li:nth-child(1) > h2").get(0);
                System.out.println(element2.attr("src"));
                System.out.println(element2.attr("alt"));
                System.out.println(element1.text());
            }));



//            new Thread(()->{
////                System.out.println(idx);
//                System.out.println(pages[idx] + " idx:" + idx);
//                Document document2 = Jsoup.parse(pages[idx].asXml());
//                Element element2 = document2.select("body > div.wrapper_list > div.bookinfo.clearfix > div.bookpic > img").get(0);
//                System.out.println(element2.attr("src"));
//                System.out.println(element2.attr("alt"));
//            }).start();

//            System.out.println(pages[idx] + " idx:" + idx);
//            Document document2 = Jsoup.parse(pages[idx].asXml());
//            Element element2 = document2.select("body > div.wrapper_list > div.bookinfo.clearfix > div.bookpic > img").get(0);
//            System.out.println(element2.attr("src"));
//            System.out.println(element2.attr("alt"));
        }

        fixedThreadPool.shutdown();
//        System.out.println(pages[0].asXml());

    }
}