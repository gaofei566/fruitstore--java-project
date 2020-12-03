package com.gaofei.fruitstore.data;

/*
/   储存数据
 */

import com.gaofei.fruitstore.domain.Fruit;

import java.util.ArrayList;

public class DataBase {
    public static ArrayList<Fruit> data = new ArrayList<Fruit>();
    //初始数据
    static {
        data.add(new Fruit("1","苹果",5.0,"kg"));
    }
}
