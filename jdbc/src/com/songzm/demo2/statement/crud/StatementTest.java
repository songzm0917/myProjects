package com.songzm.demo2.statement.crud;

import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class StatementTest {

    @Test
    public void isLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的用户名！");
        String account = scanner.nextLine();
        System.out.println("请输入您的密码！");
        String password = scanner.nextLine();
        String sql = "select account,password from user where account = '"+account+"' and password = '"+password +"'";
        User user = get(sql, User.class);
        if(user != null) {
            System.out.println("登录成功");
        }else {
            System.out.println("用户名或者密码错误");
        }


    }

    public <T> T get(String sql,Class<T> clazz) {
        T t = null;
        Connection con = null;
        Statement state = null;
        ResultSet res = null;


        try {
            //加载配置
            InputStream in = StatementTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pro = new Properties();
            pro.load(in);
            String url = pro.getProperty("url");
            String user = pro.getProperty("user");
            String password = pro.getProperty("password");
            String driverName = pro.getProperty("driverName");

            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, password);
            state = con.createStatement();
            res = state.executeQuery(sql);
            ResultSetMetaData metaData = res.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (res.next()) {
                t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Object objectVal = res.getObject(columnLabel);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,objectVal);

                }

                return t;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return null;
    }
}
