package com.hhr.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: Harry
 * @Date: 2019-05-19 23:43
 * @Version 1.0
 */
public class NetUtil {
    public static HttpURLConnection getHttpURLConnection(String url) throws IOException {
        URL url1 = new URL(url);
        URLConnection uri = url1.openConnection();
        uri.setConnectTimeout(5000);
        uri.setReadTimeout(5000);
        HttpURLConnection httpUrlConn = (HttpURLConnection)uri;
        httpUrlConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36)");
        return httpUrlConn;
    }

    public static InputStream getImageInputStream(String url){
//        return ttest(url);
        InputStream inputStream = null;

        try {
//            System.out.println(5);
            inputStream = getHttpURLConnection(url).getInputStream();
//            System.out.println("inputStream 1:" + inputStream);
        } catch (IOException e) {
//            e.printStackTrace();
            File file = new File(IoUtil.getErrorImagePath());
            try {
                inputStream = new FileInputStream(file);
//                System.out.println("inputStream 2:" + inputStream);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }


        return inputStream;
    }

    public static InputStream ttest(String url){
        HttpClient httpclient = new DefaultHttpClient();

        HttpGet httpget = new HttpGet(url);
        InputStream instream = null;
        //伪装成google的爬虫
        httpget.setHeader("User-Agent", "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
        try {
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            instream = entity.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return instream;
    }
}

