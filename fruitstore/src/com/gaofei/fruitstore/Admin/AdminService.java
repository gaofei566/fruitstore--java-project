package com.gaofei.fruitstore.Admin;

/*
/   管理员服务类
 */

import com.gaofei.fruitstore.domain.Fruit;

import java.util.ArrayList;

public class AdminService {
    private AdminDataV adminDataV = new AdminDataV();

    //查寻服务
    public ArrayList<Fruit> queryFruit() {
        //调用AdminDataV中 方法获取所有数据
        ArrayList<Fruit> data = adminDataV.queryAllDate();
        //返回数据
        return data;
    }

    //增加服务
    public Boolean addFruit(String number, String name, String price, String unit) {
        //获取所有数据
        ArrayList<Fruit> data = queryFruit();
        //使用输入的编号对比
        for (int i = 0; i < data.size(); i++) {
            Fruit fruit = data.get(i);
            //如果编号重复则添加失败
            if (fruit.getNumber().equals(number)) {
                return false;
            }
        }
        //如果没重复的编号,将数据封装成一个新的对象
        Fruit thisFruit = new Fruit(number, name, Double.parseDouble(price), unit);
        //调用AdminDataV中添加数据方法
        adminDataV.addFruit(thisFruit);

        return true;
    }

    //修改服务
    public Boolean updateFruit(String number, String name,String price, String unit) {
        //获取所有数据
        ArrayList<Fruit> data = queryFruit();
        //使用输入的编号对比
        for (int i = 0; i < data.size(); i++) {
            Fruit fruit = data.get(i);
            //若有相同的则更新
            if (fruit.getNumber().equals(number)) {
                //删除
                adminDataV.delFruit(number);
                //若没有相同，封装对象
                Fruit thisfruit = new Fruit(number, name, Double.parseDouble(price), unit);


                adminDataV.addFruit(thisfruit);
                return true;
            }
        }
        //若不存在相同编号的则可以不更新
        return false;
    }

    //删除服务
    public Boolean delFruit(String number) {
        //获取所有数据
        ArrayList<Fruit> data = queryFruit();

        for (int i = 0; i < data.size(); i++) {
            Fruit fruit = data.get(i);
            //如果相同删除
            if (fruit.getNumber().equals(number)) {
                adminDataV.delFruit(number);

                return true;
            }
        }
        ////若不存在相同编号的则可以不删除
        return false;
    }

}
