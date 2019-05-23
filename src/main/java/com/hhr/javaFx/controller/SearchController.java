package com.hhr.javaFx.controller;

import com.gluonhq.charm.glisten.control.CardPane;
import com.hhr.model.Book;
import com.hhr.model.Page;
import com.hhr.services.BaseService;
import com.hhr.services.impl.QuanshuwangService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;


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
    private JFXButton prePageBtn;

    @FXML
    private JFXButton nextPageBtn;

    private List<CardPaneController> CardList;

    private List<Book> BookList;

    private Page page;


    @FXML
    void searchingBtnClick(ActionEvent event) {
        System.out.println("搜索按钮点击！");
        System.out.println(searchingText.getText());

        loading.setVisible(true);

        if(searchingText.getText().equals("")){
            loading.setVisible(false);
        }
        else{
            doService();
        }

    }

    @FXML
    void nextPageBtnClick(ActionEvent event) {
        page.setPageIdx(page.getPageIdx() + 1);
        page.setStartIdxAndEndIdx();
        writeCardList();
        page.setPreAndNextBtnVisible();
    }

    @FXML
    void prePageBtnClick(ActionEvent event) {
        page.setPageIdx(page.getPageIdx() - 1);
        page.setStartIdxAndEndIdx();
        writeCardList();
        page.setPreAndNextBtnVisible();
    }

    private void doService(){
        new Thread(() -> {
            BaseService service = new QuanshuwangService();
            BookList = service.getBookList(searchingText.getText());
            page.setPageSum(BookList.size());
            System.out.println(BookList);
            System.out.println(page.getPageSum());

            //DO SOMETHING WITH CONTROLLS ON FX THREAD ACCORDING RESULT OF OVER
            Platform.runLater(() -> {
                writeCardList();
                setCardListVisible(true);
                loading.setVisible(false);
                page.setPreAndNextBtnVisible();
            });
//            Platform.runLater(new Runnable() {
//                @Override
//                public void run() {
//                    //javaFX operations should go here
//                }
//            });

        }).start();
    }

    private void initPane(){
        loading.setVisible(false);
        prePageBtn.setVisible(false);
        nextPageBtn.setVisible(false);
        initCardList();
        page = new Page(prePageBtn,nextPageBtn);
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

    private void writeCardList(){
        int counter = 0;
        for(int i = page.getStartBookIdx();i <= page.getEndBookIdx();i++){
            CardPaneController cardPaneController = CardList.get(counter++);
            Book book = BookList.get(i);

            cardPaneController.setCardPaneController(book);
            cardPaneController.setVisible(true);
        }
        for(int i = counter;i < 8;i++){
            CardPaneController cardPaneController = CardList.get(i);
            cardPaneController.setVisible(false);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initPane();
    }
}
