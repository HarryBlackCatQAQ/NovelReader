package com.hhr.javaFx.controller;

import com.gluonhq.charm.glisten.control.CardPane;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author: Harry
 * @Date: 2019/5/21 22:41
 * @Version 1.0
 */
public class SearchController implements Initializable {
    @FXML
    private AnchorPane mainPane;

    @FXML
    private JFXTextField searchingText;

    @FXML
    private JFXButton searchingBtn;

    @FXML
    private JFXSpinner loading;

    @FXML
    private AnchorPane cardAreaPane;

    @FXML
    private CardPane<?> card;

    @FXML
    private ImageView cardImage;

    @FXML
    private Label cardTitle;

    List<CardPaneController> CardList;


    @FXML
    void searchingBtnClick(ActionEvent event) {
        System.out.println("搜索按钮点击！");
        System.out.println(searchingText.getText());
        loading.setVisible(true);
        setCardListVisible(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loading.setVisible(false);
        initCardList();
    }

    private void initCardList(){
        CardList = new LinkedList<CardPaneController>();
        double xx = cardAreaPane.getLayoutX() + 15;
        double yy = 0;
        try {
            for(int i = 0;i < 2;i++){
                for(int j = 0;j < 4;j++){
                    CardPaneController cardPaneController = new CardPaneController();
                    cardPaneController.setLayoutX(xx + j * 275);
                    cardPaneController.setLayoutY(yy + i * 330);
                    CardList.add(cardPaneController);
                    cardAreaPane.getChildren().add(cardPaneController);
                }
            }

            setCardListVisible(false);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void setCardListVisible(boolean isVisible){
        for(CardPaneController cardPaneController : CardList){
            cardPaneController.setVisible(isVisible);
        }
    }
}
