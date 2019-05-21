package com.hhr.javaFx;

import com.hhr.util.IoUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * @Author: Harry
 * @Date: 2019/5/20 14:59
 * @Version 1.0
 */
public class MainUi extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        URL url = new URL(IoUtil.fxmlPath("demo.fxml"));
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
