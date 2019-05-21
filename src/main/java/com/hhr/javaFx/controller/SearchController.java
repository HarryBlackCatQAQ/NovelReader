package com.hhr.javaFx.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author: Harry
 * @Date: 2019/5/21 22:41
 * @Version 1.0
 */
public class SearchController implements Initializable {

    @FXML
    private JFXTextField searchingText;

    @FXML
    private JFXButton searchingBtn;

    @FXML
    private JFXSpinner loading;

    @FXML
    void searchingBtnClick(ActionEvent event) {
        System.out.println("搜索按钮点击！");
        System.out.println(searchingText.getText());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
