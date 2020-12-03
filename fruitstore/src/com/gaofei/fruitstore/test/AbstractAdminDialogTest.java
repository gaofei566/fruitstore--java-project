package com.gaofei.fruitstore.test;

import com.gaofei.fruitstore.view.AbstractAdminDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class AbstractAdminDialogTest extends AbstractAdminDialog {
    public AbstractAdminDialogTest() {
        super();
        queryFruit();       //测试数据
    }

    //加入table数据
    @Override
    public void queryFruit() {
        String[] thead = new String[]{"水果编号", "水果名称", "水果单价(/元)", "计价单位"};
        String[][] tbody = new String[][]{
                {"1", "苹果", "5", "kg"},
                {"2", "葡萄", "3", "斤"},
                {"3", "西瓜", "1", "斤"},
                {"4", "哈密瓜", "2", "斤"}
        };

        TableModel data = new DefaultTableModel(tbody, thead);
        jTable.setModel(data);
    }

    @Override
    public void addFruit() {

    }

    @Override
    public void updateFruit() {

    }

    @Override
    public void delFruit() {

    }

    public static void main(String[] args) {
        new AbstractAdminDialogTest().setVisible(true);     //创建界面  并    显示
    }
}
