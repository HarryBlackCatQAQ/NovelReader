package com.hhr.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * @Author: Harry
 * @Date: 2019/5/21 22:22
 * @Version 1.0
 */
public class JavaFxUnit {

    public static Scene getScene(String fxmlName) throws IOException {
        URL url = new URL(IoUtil.fxmlPath(fxmlName));
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);


        return scene;
    }

    public static Stage getStage(Control control){
        System.out.println((Stage)control.getScene().getWindow());
        return (Stage)control.getScene().getWindow();
    }

    public static void ChangeStage(Control control ,String fxmlName) throws IOException {
        Stage stage = JavaFxUnit.getStage(control);
        stage.setScene(JavaFxUnit.getScene(fxmlName));
    }
}
