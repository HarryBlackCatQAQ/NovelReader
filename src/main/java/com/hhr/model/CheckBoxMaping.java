package com.hhr.model;

import com.jfoenix.controls.JFXCheckBox;

/**
 * @Author: Harry
 * @Date: 2019-05-25 02:32
 * @Version 1.0
 */
public class CheckBoxMaping {
    private JFXCheckBox checkBox;
    private int idx;

    public CheckBoxMaping(JFXCheckBox checkBox, int idx) {
        this.checkBox = checkBox;
        this.idx = idx;
    }

    public JFXCheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(JFXCheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }


}