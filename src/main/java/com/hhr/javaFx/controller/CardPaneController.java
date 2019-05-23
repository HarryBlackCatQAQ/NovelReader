package com.hhr.javaFx.controller;

import com.hhr.model.Book;
import com.hhr.util.IoUtil;
import com.jfoenix.controls.JFXButton;
import com.sun.javafx.tk.ImageLoader;
import com.sun.javafx.tk.PlatformImage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author: Harry
 * @Date: 2019-05-23 00:22
 * @Version 1.0
 */
public class CardPaneController extends AnchorPane implements Initializable {
    @FXML
    private ImageView cardImage;

    @FXML
    private Label cardTtile;

    @FXML
    private Label cardAuthor;

    @FXML
    private JFXButton cardOnlineReadingBtn;

    @FXML
    private JFXButton cardOfflineReadingBtn;


    @FXML
    void cardOfflineReadingBtnClick(ActionEvent event) {
        System.out.println("离线阅读点击");
    }

    @FXML
    void cardOnlineReadingBtnClick(ActionEvent event) {
        System.out.println("在线阅读点击@@");
    }

    public CardPaneController() throws MalformedURLException {
        loadFxml();
    }

    private void loadFxml() throws MalformedURLException {
        URL url = new URL(IoUtil.fxmlPath("cardPane.fxml"));
        FXMLLoader loader = new FXMLLoader(url);
        loader.setRoot(this);
        loader.setController(this);

        try{
            loader.load();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCardPaneController(Book book){
        cardImage.setImage(new Image(book.getImageUrl()));
        cardTtile.setText(book.getName());
        cardAuthor.setText(book.getAuthor());

        
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public ImageView getCardImage() {
        return cardImage;
    }

    public Label getCardTtile() {
        return cardTtile;
    }

    public JFXButton getCardOnlineReadingBtn() {
        return cardOnlineReadingBtn;
    }

    public JFXButton getCardOfflineReadingBtn() {
        return cardOfflineReadingBtn;
    }

    public Label getCardAuthor() {
        return cardAuthor;
    }
}