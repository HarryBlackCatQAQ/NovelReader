package com.hhr.util;

import java.io.IOException;
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
        HttpURLConnection httpUrlConn = (HttpURLConnection)uri;
        httpUrlConn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36)");

        return httpUrlConn;
    }
}

