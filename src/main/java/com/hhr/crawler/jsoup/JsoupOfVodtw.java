package com.hhr.crawler.jsoup;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.hhr.model.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Harry
 * @Date: 2019-05-25 00:23
 * @Version 1.0
 */
public class JsoupOfVodtw extends BaseJsoup{

    public String[] getBookUrl(String html){
        this.setDocument(Jsoup.parse(html));
        this.setElements(this.getDocument().select("#CListTitle > a:nth-child(1)"));

        String VodtwUrl = "https://www.vodtw.com/";

        String urls[] = new String[this.getElements().size()];

        for(int i = 0;i < this.getElements().size();i++){
            urls[i] = VodtwUrl + this.getElements().get(i).attr("href");
        }

        return urls;
    }


    public List<Book> AnalysisOfTheBook(String urls[]){
        List<Book>  BookList = new LinkedList<Book>();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        // 创建webclient
        WebClient webClient = new WebClient();
        // 取消 JS 支持
        webClient.getOptions().setJavaScriptEnabled(false);
        // 取消 CSS 支持
        webClient.getOptions().setCssEnabled(false);

        for(int i = 0;i < urls.length;i++){
            final int idx = i;

            try {
                HtmlPage page1 = webClient.getPage(urls[i]);

                fixedThreadPool.execute(new Thread(()->{
                    Document document = Jsoup.parse(page1.asXml());

                    Element element2 = document.select("body > div.wrapper_list > div.bookinfo.clearfix > div.bookpic > img").get(0);
                    Element element1 = document.select("body > div.wrapper_list > div.bookinfo.clearfix > div.bookdetail > ul > li:nth-child(1) > h2").get(0);
//                System.out.println(element2.attr("src"));
//                System.out.println(element2.attr("alt"));
//                System.out.println(element1.text());

                    Book book = new Book();
                    book.setAuthor(element1.text());
                    book.setImageUrl(element2.attr("src"));
                    book.setName(element2.attr("alt"));
                    book.setImageName(book.getAutoImageName());
                    book.setUrl(page1.asXml());

//                System.out.println(book);



                    BookList.add(book);
                }));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        fixedThreadPool.shutdown();
        return BookList;
    }
}