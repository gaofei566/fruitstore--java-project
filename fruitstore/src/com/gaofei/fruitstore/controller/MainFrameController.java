package com.gaofei.fruitstore.controller;
import com.gaofei.fruitstore.Admin.AdminControl;
import com.gaofei.fruitstore.view.AstractMainFrame;

/*
/   主界面操作类
 */

public class MainFrameController extends AstractMainFrame{
    @Override
    public void showAdmin() {
        //在该方法中创建管理员界面并显示
        //this为父窗口，true为模拟窗口展示
        new AdminControl(this,false).setVisible(true);
    }
}
