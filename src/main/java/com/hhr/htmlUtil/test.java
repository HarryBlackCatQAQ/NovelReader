package com.hhr.htmlUtil;

import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.List;


/**
 * @Author: Harry
 * @Date: 2019/5/20 12:05
 * @Version 1.0
 */
public class test {

    public static void main(String[] args) throws IOException {
        // 创建webclient
        WebClient webClient = new WebClient();
        // 取消 JS 支持
        webClient.getOptions().setJavaScriptEnabled(false);
        // 取消 CSS 支持
        webClient.getOptions().setCssEnabled(false);

        // 获取指定网页实体
        HtmlPage page = (HtmlPage) webClient.getPage("http://www.quanshuwang.com/");

        // 获取搜索输入框
        HtmlInput input = (HtmlInput) page.getHtmlElementById("bdcsMain");
        // 往输入框 “填值”
        input.setValueAttribute("斗罗大陆");
        // 获取搜索按钮
        HtmlInput btn = (HtmlInput) page.getHtmlElementById("searchbuttom");
        // “点击” 搜索
        HtmlPage page2 = btn.click();

        System.out.println(page2.asXml());



        //选择阅读按钮
//        int len = page2.getByXPath("//*[@id=\"container\"]/div[2]/section/div/div[1]/div[2]/a[1]").size();
//        HtmlAnchor btnAnchor = null;
//        if(len == 0) {
//            System.out.println("@");
//            btnAnchor = (HtmlAnchor) page2.getByXPath("//*[@id=\"navList\"]/section/ul/li[1]/span/a[3]").get(0);
//            page2 = btnAnchor.click();
//        }

//        btnAnchor = (HtmlAnchor) page2.getByXPath("//*[@id=\"container\"]/div[2]/section/div/div[1]/div[2]/a[1]").get(0);


        // “点击” 阅读
//        HtmlPage page3 = btnAnchor.click();



//        System.out.println(page.getByXPath("//*[@id=\"container\"]/div[2]/section/div/div[1]/div[2]/a[1]"));
//        System.out.println(btnAnchor);
//        System.out.println(page3.asXml());

//        com.hhr.jsoup.test.solve(page3.asXml());

//        // 选择元素
//        List<HtmlElement> spanList=page2.getByXPath("//h3[@class='res-title']/a");
//        for(int i=0;i<spanList.size();i++) {
//            // 输出新页面的文本
//            System.out.println(i+1+"、"+spanList.get(i).asText());
//        }
    }
}
