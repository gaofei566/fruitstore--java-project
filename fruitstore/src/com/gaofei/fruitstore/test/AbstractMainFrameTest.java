package com.gaofei.fruitstore.test;
import com.gaofei.fruitstore.view.AstractMainFrame;

/*
/窗口测试类
 */

public class AbstractMainFrameTest extends AstractMainFrame{
    public static void main(String[] args) {
        new AbstractMainFrameTest().setVisible(true);
    }

    @Override
    public void showAdmin() {
        System.out.println("进入管理员界面");
    }
}
