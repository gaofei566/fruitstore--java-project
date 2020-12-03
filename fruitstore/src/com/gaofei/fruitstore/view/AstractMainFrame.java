package com.gaofei.fruitstore.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
/   主窗口类
 */

public abstract class AstractMainFrame extends JFrame {
    private JLabel jLabel = new JLabel(new ImageIcon("D:\\QQfile\\f.jpg"));
    private JButton jButton = new JButton("进入系统");

    public AstractMainFrame() {
        this.init();      //初始化
        this.addComponent();        //添加组件
        this.addListener();       //添加监听器
    }

    //初始化
    private void init() {
        this.setTitle("水果超市欢迎您");
        this.setSize(800, 600);
        this.setLocation(400,250);
        this.setResizable(false);       //窗体大小固定
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

    //添加组件
    private void addComponent() {
        this.add(this.jLabel, BorderLayout.NORTH);

        JPanel btnjPanel = new JPanel();    //创建JPanel对象
        btnjPanel.setLayout(null);          //清楚JPanel布局
        this.add(btnjPanel);                //把btnjPanel添加到JFrame窗口中
        jButton.setBounds(320, 10, 120, 50);   //定义位置
        btnjPanel.add(jButton);
    }

    //添加监听器
    private void addListener() {
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdmin();        //显示管理员界面
            }
        });
    }

    public abstract void showAdmin();       //抽象  展示管理员界面方法

}
