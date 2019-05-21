package com.hhr.jsoup;

import com.hhr.jsoup.model.Chapter;
import com.hhr.util.IoUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Harry
 * @Date: 2019/5/20 11:03
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("http://www.quanshuwang.com/book/168/168595/49211154.html").get();
        Elements elements = document.select("div[id=content]");
//        System.out.println(elements.text());
        contentReplace(elements.text());
    }

    public static String contentReplace(String str){
        String tp = "";
        char pre = '0';
        for(int i = 0;i < str.length();i++){
            char c = str.charAt(i);
            if(i != ' ' && pre == ' '){
                tp += '\n';
            }
            tp += c;
            pre = c;
        }
        System.out.println(tp);
        return tp;
    }


    public static void solve(String html) throws IOException {
        Document document = Jsoup.parse(html);

        Elements elements = document.select("#chapter > div.chapterSo > div.chapterNum > ul > div.clearfix.dirconone > li > a");
        List<Chapter> list = new ArrayList<Chapter>();
        for(Element element : elements){
            Chapter chapter = new Chapter();


            chapter.setUrl(element.attr("href"));
            chapter.setTitle(element.text());
//            System.out.println(chapter);
            list.add(chapter);
        }

        int counter = 1;
        for(Chapter chapter : list){
            document = Jsoup.connect(chapter.getUrl()).get();
            Element element = document.select("#content").get(0);
            writeNovel(contentReplace(element.text()),chapter.getTitle());
            System.out.println(counter + " ok!");
            counter++;
        }
    }


    public static void writeNovel(String content,String fileName) throws IOException {
        String filePath = IoUtil.getSystemPath() + IoUtil.pathReplace("\\src\\main\\java\\com\\hhr\\novel");
        IoUtil.mkDirs(filePath);
        content = content.replaceAll("\n","\r\n");
        filePath += "\\" + fileName + ".txt";
        FileWriter fwriter = new FileWriter(filePath, false);
        fwriter.write(content);
        fwriter.flush();
        fwriter.close();
    }
}
