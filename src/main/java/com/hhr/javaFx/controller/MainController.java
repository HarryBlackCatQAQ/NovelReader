package com.hhr.javaFx.controller;

import com.hhr.util.JavaFxUnit;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * @Author: Harry
 * @Date: 2019-05-21 20:13
 * @Version 1.0
 */
public class MainController {
    @FXML
    private JFXButton onLineReadingBtn;


    @FXML
    void onLineReadingBtnClick(ActionEvent event) throws Exception {
        System.out.println("在线阅读按钮点击！");
        JavaFxUnit.ChangeStage(onLineReadingBtn,"search.fxml");
    }
}