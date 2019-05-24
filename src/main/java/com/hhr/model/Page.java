package com.hhr.model;

import com.jfoenix.controls.JFXButton;

/**
 * @Author: Harry
 * @Date: 2019-05-23 15:46
 * @Version 1.0
 */
public class Page {
    private int pageSum;
    private int pageIdx;
    private int bookSum;
    private int startBookIdx;
    private int endBookIdx;
    private JFXButton prePageBtn;
    private JFXButton nextPageBtn;

    public Page(){
        pageSum = 0;
        pageIdx = 1;
        bookSum = startBookIdx = endBookIdx = 0;
    }

    public Page(JFXButton prePageBtn,JFXButton nextPageBtn){
        pageSum = 0;
        pageIdx = 1;
        bookSum = startBookIdx = endBookIdx = 0;
        this.prePageBtn = prePageBtn;
        this.nextPageBtn = nextPageBtn;
    }

    public void setPreAndNextBtnVisible(){
        if(pageSum == 0){
            this.prePageBtn.setVisible(false);
            this.nextPageBtn.setVisible(false);
            return;
        }

        if(pageIdx == 1){
            this.prePageBtn.setVisible(false);
            if(pageSum == 1){
                this.nextPageBtn.setVisible(false);
            }
            else{
                this.nextPageBtn.setVisible(true);
            }
        }
        else if(pageIdx == pageSum){
            this.prePageBtn.setVisible(true);
            this.nextPageBtn.setVisible(false);
        }
        else{
            this.prePageBtn.setVisible(true);
            this.nextPageBtn.setVisible(true);
        }
    }

    public void setStartIdxAndEndIdx(){
        if(pageSum == 0){
            this.startBookIdx = this.endBookIdx = 0;
            return;
        }

        int s,e;
        if(pageIdx == pageSum){
            s = (pageIdx - 1) * 8 + 1;
            e = bookSum;
        }
        else{
            s = (pageIdx - 1) * 8 + 1;
            e = s + 8 - 1;
        }
        this.startBookIdx = s - 1;
        this.endBookIdx = e - 1;
    }


    public int getPageSum() {
        return pageSum;
    }

    public void setPageSum(int bookSum) {
        int pageSum = bookSum / 8;
        if(bookSum % 8 != 0){
            pageSum++;
        }
        this.bookSum = bookSum;
        this.pageSum = pageSum;
        this.pageIdx = 1;
        setStartIdxAndEndIdx();
    }

    public int getPageIdx() {
        return pageIdx;
    }

    public void setPageIdx(int pageIdx) {
        this.pageIdx = pageIdx;
    }

    public void setPrePageBtn(JFXButton prePageBtn) {
        this.prePageBtn = prePageBtn;
    }

    public void setNextPageBtn(JFXButton nextPageBtn) {
        this.nextPageBtn = nextPageBtn;
    }


    public int getBookSum() {
        return bookSum;
    }

    public void setBookSum(int bookSum) {
        this.bookSum = bookSum;
    }


    public int getStartBookIdx() {
        return startBookIdx;
    }

    public void setStartBookIdx(int startBookIdx) {
        this.startBookIdx = startBookIdx;
    }

    public int getEndBookIdx() {
        return endBookIdx;
    }

    public void setEndBookIdx(int endBookIdx) {
        this.endBookIdx = endBookIdx;
    }


    @Override
    public String toString() {
        return "Page{" +
                "pageSum=" + pageSum +
                ", pageIdx=" + pageIdx +
                ", bookSum=" + bookSum +
                ", startBookIdx=" + startBookIdx +
                ", endBookIdx=" + endBookIdx +
                ", prePageBtn=" + prePageBtn +
                ", nextPageBtn=" + nextPageBtn +
                '}';
    }
}