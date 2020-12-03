package com.gaofei.fruitstore.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
/       窗口管理类
 */

public abstract class AbstractAdminDialog extends JDialog {
    private JLabel jLabel = new JLabel("水果列表");     //水果列表标题
    private JScrollPane tablePane = new JScrollPane();      //创建滚动视图

    //    定义姐买你使用的组件为变量
    protected JTable jTable = new JTable();   //水果列表
    private JLabel numberLabel = new JLabel("水果编号");
    private JLabel nameLabel = new JLabel("水果名称");
    private JLabel priceLabel = new JLabel("水果单价(/元)");
    private JLabel unitLabel = new JLabel("计价单位");

    //    添加功能组件
    protected JTextField numberText = new JTextField(6);
    protected JTextField nameText = new JTextField(6);
    protected JTextField priceText = new JTextField(6);
    protected JTextField unitText = new JTextField(6);
    private JButton addBtn = new JButton("添加水果");

    //修改功能组件
    protected JTextField numberUpdate = new JTextField(6);
    protected JTextField nameUpdate = new JTextField(6);
    protected JTextField priceUpdate = new JTextField(6);
    protected JTextField unitUpdate = new JTextField(6);
    private JButton updateBtn = new JButton("修改水果");

    //    删除功能
    protected JTextField numberDel = new JTextField(6);
    private JButton delBtn = new JButton("删除水果");

    //构建方法
    public AbstractAdminDialog() {
        this(null,true);
    }

    public AbstractAdminDialog(Frame owner, boolean b) {
        super(owner, b);
        this.init();
        this.addComponent();
        this.addListener();
    }

    //初始化
    public void init() {
        this.setTitle("超市货物管理");
        this.setSize(600, 400);
        this.setLocation(400, 250);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);       //窗体大小固定
    }

    //添加组件
    public void addComponent() {
        //取消布局
        this.setLayout(null);
//        表格标题
        jLabel.setBounds(265, 20, 70, 25);
        this.add(jLabel);
//        表格
        jTable.getTableHeader().setReorderingAllowed(false);    //列不能移动
        jTable.getTableHeader().setResizingAllowed(false);      //不能拉动表格
        jTable.setEnabled(false);       //不能改数据

        tablePane.setBounds(50, 50, 500, 200);
        tablePane.setViewportView(jTable);
        this.add(tablePane);

        //字段标题
        numberLabel.setBounds(50, 250, 70, 25);
        nameLabel.setBounds(150, 250, 70, 25);
        priceLabel.setBounds(250, 250, 70, 25);
        unitLabel.setBounds(350, 250, 70, 25);
        this.add(numberLabel);
        this.add(nameLabel);
        this.add(priceLabel);
        this.add(unitLabel);

//        添加组件
        numberText.setBounds(50,280,80,25);
        nameText.setBounds(150,280,80,25);
        priceText.setBounds(250,280,80,25);
        unitText.setBounds(350,280,80,25);
        this.add(numberText);
        this.add(nameText);
        this.add(priceText);
        this.add(unitText);
        addBtn.setBounds(460,280,90,25);
        this.add(addBtn);

        //修改组件
        numberUpdate.setBounds(50,310,80,25);
        nameUpdate.setBounds(150,310,80,25);
        priceUpdate.setBounds(250,310,80,25);
        unitUpdate.setBounds(350,310,80,25);
        this.add(numberUpdate);
        this.add(nameUpdate);
        this.add(priceUpdate);
        this.add(unitUpdate);
        updateBtn.setBounds(460,310,90,25);
        this.add(updateBtn);

        //删除组件
        numberDel.setBounds(50,340,80,25);
        this.add(numberDel);
        delBtn.setBounds(460,340,90,25);
        this.add(delBtn);

    }
    //添加监听器
    public void addListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFruit();     //增加水果
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFruit();      //修改水果
            }
        });

        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delFruit();     //删除水果
            }
        });

    }

    //查询方法
    public abstract void queryFruit();
    //增加方法
    public abstract void addFruit();
    //修改方法
    public abstract void updateFruit();
    //删除方法
    public abstract void delFruit();

}
