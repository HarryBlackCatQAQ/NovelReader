package com.hhr.crawler;

import com.hhr.model.Book;
import com.hhr.util.IoUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Harry
 * @Date: 2019-05-23 13:33
 * @Version 1.0
 */
public class MyJsoup {
    private Document document;
    private Elements elements;

    public List<Book> AnalysisOfTheBook(String html, String webName){
        webName = webName.toLowerCase();

        if(webName.equals("quanshuwang")){
            return JsoupQuanshuwang(html);
        }

        return null;
    }



    private List<Book> JsoupQuanshuwang(String html){
        List<Book> BookList = new LinkedList<Book>();

        document = Jsoup.parse(html);
        Elements elements = document.select("#navList > section > ul > li > a");
        Elements authorElements = document.select("#navList > section > ul > li > span > a:nth-child(2)");


        for(int i = 0;i < elements.size();i++){
            Book book = new Book();
            Element element = elements.get(i);
            Element authorElement = authorElements.get(i);
            Element img = element.child(0);

            book.setUrl(element.attr("href"));
            book.setName(img.attr("alt"));
            book.setImageUrl(img.attr("src"));
            book.setAuthor(authorElement.text());
//            book.setImageName(book.getName() + "-" + book.getAuthor() + IoUtil.getSuffix(book.getImageUrl()));
            book.setImageName(book.getAutoImageName());

            BookList.add(book);

        }

        return BookList;
    }
}