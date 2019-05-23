package com.hhr.util;

import java.io.*;

/**
 * @Author: Harry
 * @Date: 2019/5/19 1:59
 * @Version 1.0
 */
public class IoUtil {
    /**
     * 拿取图片的InputStream下载图片
     * @param inputStream
     * @param imageName
     * @param path
     * @throws IOException
     */
    public static void writeImage(InputStream inputStream,String imageName,String path) throws IOException {
        mkDirs(path);
        OutputStream outputStream = new FileOutputStream(new File(path,imageName));
        byte[] buf = new byte[1024];
        int p = 0;
        while((p = inputStream.read(buf)) != -1){
            outputStream.write(buf,0,p);
        }
    }

    /**
     * 创建存在在的路径文件/文件夹
     * @param strPath
     * @throws IOException
     */
    public static void  mkDirs(String strPath) throws IOException {
        File file = new File(strPath);
        if (!file.exists()) {
            file.mkdirs();
        }

    }


    /**
     *
     * @param path
     * @return 系统分隔符替换后的路径
     */
    public static String pathReplace(String path){
        String fs = getSystemSeparator();
        return path.replace("\\",fs);
    }

    /**
     *
     * @return 系统分隔符
     */
    public static String getSystemSeparator(){
        return System.getProperties().getProperty("file.separator");
    }

    /**
     *
     * @return 项目路径
     */
    public static String getSystemPath(){
        return System.getProperty("user.dir");
    }


    /**
     * fxml路径自动生成 输入fxml文件名即可
     * @param path
     * @return fxml在该项目的路径
     */
    public static String fxmlPath(String path){
        String file_ = "file:";
        if(getSystemSeparator().equals("\\")){
            file_ += "\\";
        }
        return pathReplace(file_ + getSystemPath() + "\\src\\main\\java\\com\\hhr\\javaFx\\fxml\\" + path) ;
    }

    /**
     *
     * @return 返回缓存数据的路径
     */
    public static String getCachePath(){
        return pathReplace(getSystemPath() + "\\src\\main\\java\\com\\hhr\\cache");
    }

    /**
     *
     * @return 返回图片存储路径
     */
    public static String imagePath(){
        return pathReplace(getSystemPath() + "\\src\\main\\java\\com\\hhr\\images\\");
    }

    public static String getSuffix(String string){
        return string.substring(string.lastIndexOf("."));
    }
}
