package com.hhr.javaFx;

import com.hhr.util.JavaFxUnit;
import javafx.application.Application;

import javafx.stage.Stage;


/**
 * @Author: Harry
 * @Date: 2019/5/20 14:59
 * @Version 1.0
 */
public class MainUi extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        System.out.println(primaryStage);
        primaryStage.setScene(JavaFxUnit.getScene("main.fxml"));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
