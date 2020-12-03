package com.gaofei.fruitstore.Admin;

/*
/   管理员操作界面
 */


import com.gaofei.fruitstore.domain.Fruit;
import com.gaofei.fruitstore.view.AbstractAdminDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

public class AdminControl extends AbstractAdminDialog {
    //定义服务类
    private AdminService adminService = new AdminService();

    //构造方法
    public AdminControl() {
        super();
    }

    public AdminControl(Frame owner, boolean b) {
        super(owner, b);
        //创建对象时展示数据
        queryFruit();
    }


    //查询方法
    @Override
    public void queryFruit() {
        //定义表格头
        String[] thead = {"水果编号","水果名称","水果单价(/元)","水果单价"};
        //调用adminService的查询服务
        ArrayList<Fruit> datalist = adminService.queryFruit();
        //调用list2Array方法,将查询的集合转为数组,方便JTable赋值
        String[][] tbody = list2Array(datalist);
        //将查询的结果变为数组
        TableModel tableModel = new DefaultTableModel(tbody,thead);
        jTable.setModel(tableModel);


    }
    //方法使集合转化为二维数组
    private String[][] list2Array(ArrayList<Fruit> datalist) {
        //定义JTable数据
        String[][] body = new String[datalist.size()][4];
        for (int i = 0; i < datalist.size(); i++) {
            Fruit fruit = datalist.get(i);
            body[i][0] = fruit.getNumber();
            body[i][1] = fruit.getName();
            body[i][2] = fruit.getPrice()+"";
            body[i][3] = fruit.getUnit();
        }
        return body;
    }

    //增加方法
    @Override
    public void addFruit() {
        //获取数据
        String addNumber = numberText.getText();
        String addName = nameText.getText();
        String addPrice = priceText.getText();
        String addUnit = unitText.getText();

        //调用adminSercice添加服务
        boolean addSuccess = adminService.addFruit(addNumber, addName, addPrice, addUnit);
        //如果添加成功
        if (addSuccess) {
            //添加成功刷新表格
            queryFruit();
        } else {
            //
            JOptionPane.showMessageDialog(this, "水果编号不能重复,请检查数据!");
        }
    }

    //修改方法
    @Override
    public void updateFruit() {
        //修改数据
        String updateNumber = numberUpdate.getText();
        String updateName = nameUpdate.getText();
        String updatePrice = priceUpdate.getText();
        String updateUnit = unitUpdate.getText();

        //都调用adminService修改服务
        boolean updateSuccess = adminService.updateFruit(updateNumber, updateName, updatePrice, updateUnit);
        //如果修改成功
        if (updateSuccess) {
            //添加成功刷新表格
            queryFruit();
        } else {
            //
            JOptionPane.showMessageDialog(this, "没有这个编号的水果,请检查数据!");
        }

    }

    //删除方法
    @Override
    public void delFruit() {
        //删除数据
        String delNumber = numberDel.getText();

//        调用adminService的删除服务
        boolean delSuccess = adminService.delFruit(delNumber);
        //如果修改成功
        if (delSuccess) {
            //添加成功刷新表格
            queryFruit();
        } else {
            //
            JOptionPane.showMessageDialog(this, "没有这个编号的水果,请检查数据!");
        }
    }
}
