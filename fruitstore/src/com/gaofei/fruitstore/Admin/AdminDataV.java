package com.gaofei.fruitstore.Admin;

/*
/   管理员数据访问类
 */

import com.gaofei.fruitstore.data.DataBase;
import com.gaofei.fruitstore.domain.Fruit;
import com.gaofei.fruitstore.tools.JDBCUtils;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class AdminDataV {
    //获取所有数据
    public ArrayList<Fruit> queryAllDate() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Fruit> list = new ArrayList<Fruit>();
        //连接数据库
        try {
            conn = JDBCUtils.getConnection();
            //获取statement对象
            stmt = conn.createStatement();
            //发送sql语句
            String sql = "select * from fruit";
            rs = stmt.executeQuery(sql);
            //处理            将数据库数据封装对象  再存入集合中
            while (rs.next()){
                Fruit fruit = new Fruit();
                fruit.setNumber(rs.getString("number"));
                fruit.setName(rs.getString("fruitname"));
                fruit.setPrice(rs.getDouble("price"));
                fruit.setUnit(rs.getString("unit"));
                list.add(fruit);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.realse(rs,stmt,conn);
        }

        return null;
    }

    //增加数据
    public void addFruit(Fruit fruit) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = JDBCUtils.getConnection();
            //创建一个statement对象将sql语句发送数据库
            stmt = conn.createStatement();

            String sql = "insert into fruit(number,fruitname,price,unit)"
                    + "values('" + fruit.getNumber() + "','"
                    + fruit.getName() + "',"
                    + fruit.getPrice() + ",'"
                    + fruit.getUnit() + "')";
            int count = stmt.executeUpdate(sql);        //影响行数
            if(count > 0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.realse(stmt,conn);
        }
    }

    //删除数据
    public void delFruit(String number) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = JDBCUtils.getConnection();

            stmt = conn.createStatement();

            String sql = "delete from fruit where number=" + number;
            int count = stmt.executeUpdate(sql);
            if(count > 0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.realse(stmt,conn);
        }

    }


}
