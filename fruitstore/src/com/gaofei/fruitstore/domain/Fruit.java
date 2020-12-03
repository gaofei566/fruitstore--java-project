package com.gaofei.fruitstore.domain;

public class Fruit {
    //属性
    private String number;
    private String name;
    private Double price;
    private String unit;

    //构造方法
    public Fruit() {
    }

    public Fruit(String number, String name, Double price, String unit) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }
    //Get Set 方法
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
