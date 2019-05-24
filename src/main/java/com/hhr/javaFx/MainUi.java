package com.hhr.javaFx;

import com.hhr.util.JavaFxUtil;
import javafx.application.Application;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


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
        primaryStage.setScene(JavaFxUtil.getScene("main.fxml"));
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                Platform.exit();
                System.out.println("关闭舞台！");
//            primaryStage.close();
                System.exit(0);
            }

        });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
