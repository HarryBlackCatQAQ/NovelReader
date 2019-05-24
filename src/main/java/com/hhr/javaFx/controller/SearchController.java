package com.hhr.javaFx.controller;

import com.hhr.model.Book;
import com.hhr.model.CheckBoxMaping;
import com.hhr.model.Page;
import com.hhr.services.BaseService;
import com.hhr.services.impl.QuanshuwangService;
import com.hhr.services.impl.VodtwService;
import com.hhr.util.DownUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    private JFXButton prePageBtn;

    @FXML
    private JFXButton nextPageBtn;

    private List<CardPaneController> CardList;

    private List<Book> BookList;

    private Page page;

    private String preSearchingText = "";



    @FXML
    private JFXCheckBox vodtxCheckBox;

    @FXML
    private JFXCheckBox quanshuwangCheckBox;

    @FXML
    private Button testCheckBoxBtn;

    private List<CheckBoxMaping> CheckBoxList;

    @FXML
    void testCheckBoxBtnClick(ActionEvent event) {
        System.out.println("vodtxCheckBox:" + vodtxCheckBox.isSelected());
        System.out.println("quanshuwangCheckBox:" + quanshuwangCheckBox.isSelected());
        System.out.println("size:" + getCheckBoxNum());
    }

    @FXML
    void searchingBtnClick(ActionEvent event) {
        if(searchingBeforeLoading()){
            return;
        }


        System.out.println("搜索按钮点击！");
        System.out.println(searchingText.getText());
        this.preSearchingText = searchingText.getText();

        loading.setVisible(true);

        if(searchingText.getText().equals("")){
            loading.setVisible(false);
        }
        else{
            doService();
        }

    }

    private Boolean searchingBeforeLoading(){
        if(preSearchingText.equals(searchingText.getText())){
            System.out.println("查询过了");
            return true;
        }

        if(getCheckBoxNum() == 0){
            System.out.println("没有选择查询网站");
            return true;
        }


        return false;
    }

    @FXML
    void nextPageBtnClick(ActionEvent event) {
        page.setPageIdx(page.getPageIdx() + 1);
        RefreshPane();
    }

    @FXML
    void prePageBtnClick(ActionEvent event) {
        page.setPageIdx(page.getPageIdx() - 1);
        RefreshPane();
    }

    private void doService(){
        List<List<Book>> list = new LinkedList<List<Book>>();

        for(int i = 0;i < getCheckBoxNum();i++){
            list.add(new LinkedList<Book>());
        }

        new Thread(() -> {
            for(CheckBoxMaping checkBoxMaping : CheckBoxList){
                BaseService service = getSearchingServiceWebType(checkBoxMaping);
                new Thread(()->{
                    list.add(service.getBookList(searchingText.getText()));
                }).start();
            }

            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!size:" + list.size());
            for(int i = 1;i < list.size();i++){
                List<Book> l = list.get(i);
                System.out.println(l.size());
            }

            for(int i = 1;i < list.size();i++){
                list.get(0).addAll(list.get(i));
            }

            BookList = list.get(0);

            page.setPageSum(BookList.size());
            System.out.println(BookList);
            System.out.println(page.getPageSum());

            if(BookList.size() == 0){
                RefreshPaneForNullSearching();
                return;
            }

            System.out.println(this + "  1");
            DownUtil downUtil = new DownUtil(5);
            downUtil.DownImage(BookList,this);

            //DO SOMETHING WITH CONTROLLS ON FX THREAD ACCORDING RESULT OF OVER
            doServiceLater();

        }).start();
    }

    public void doServiceLater(){
        Platform.runLater(() -> {
//            writeCardList();
            setCardListVisible(true);
            loading.setVisible(false);
//            page.setPreAndNextBtnVisible();

            RefreshPane();
        });

        //            Platform.runLater(new Runnable() {
//                @Override
//                public void run() {
//                    //javaFX operations should go here
//                }
//            });
    }

    private BaseService getSearchingServiceWebType(CheckBoxMaping checkBoxMaping){
        if(checkBoxMaping.getIdx() == 0){
            return new VodtwService();
        }
        else if(checkBoxMaping.getIdx() == 1){
            return new QuanshuwangService();
        }

        return null;
    }

    private void initPane(){
        loading.setVisible(false);
        prePageBtn.setVisible(false);
        nextPageBtn.setVisible(false);
        initCardList();
        page = new Page(prePageBtn,nextPageBtn);
        initCheckBoxList();
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

    private void initCheckBoxList(){
        this.CheckBoxList = new LinkedList<CheckBoxMaping>();
        CheckBoxList.add(new CheckBoxMaping(vodtxCheckBox,0));
        CheckBoxList.add(new CheckBoxMaping(quanshuwangCheckBox,1));
    }

    private void RefreshPane(){
        page.setStartIdxAndEndIdx();
        writeCardList();
        page.setPreAndNextBtnVisible();
    }

    private void RefreshPaneForNullSearching(){
        page.setPageSum(0);
        setCardListVisible(false);
        page.setPreAndNextBtnVisible();
        loading.setVisible(false);
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

    private int getCheckBoxNum(){
        int sum = 0;
        for(CheckBoxMaping checkBoxMaping : CheckBoxList){
            if(checkBoxMaping.getCheckBox().isSelected()){
                sum++;
            }
        }

        return sum;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initPane();
    }
}
