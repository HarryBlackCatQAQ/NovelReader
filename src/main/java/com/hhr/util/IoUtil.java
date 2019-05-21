package com.hhr.util;

import java.io.*;

/**
 * @Author: Harry
 * @Date: 2019/5/19 1:59
 * @Version 1.0
 */
public class IoUtil {
    public static void writeImage(InputStream inputStream,String imageName,String path) throws IOException {
        mkDirs(path);
        OutputStream outputStream = new FileOutputStream(new File(path,imageName));
        byte[] buf = new byte[1024];
        int p = 0;
        while((p = inputStream.read(buf)) != -1){
            outputStream.write(buf,0,p);
        }
    }

    public static void  mkDirs(String strPath) throws IOException {
        File file = new File(strPath);
        if (!file.exists()) {
            file.mkdirs();
        }

    }

    public static String pathReplace(String path){
        String fs = System.getProperties().getProperty("file.separator");
        return path.replace("\\",fs);
    }

    public static String getSystemPath(){
        return System.getProperty("user.dir");
    }


    public static String fxmlPath(String path){
        return pathReplace("file:\\" + getSystemPath() + "\\src\\main\\java\\com\\hhr\\javaFx\\fxml\\" + path) ;
    }
}
