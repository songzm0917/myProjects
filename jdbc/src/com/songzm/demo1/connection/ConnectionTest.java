package com.songzm.demo1.connection;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {


    @Test
    public void testConnection1() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/test";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);

    }

    @Test
    public void testConnection2() throws Exception {
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/test";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    /**
     * 使用DriverManager替换Driver
     */
    @Test
    public void testConnection3() throws Exception {
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        DriverManager.registerDriver(driver);
        String url = "jdbc:mysql://localhost:3306/test";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123");
        Connection connection = DriverManager.getConnection(url, properties);
        System.out.println(connection);
    }


    @Test
    public void testConnection4() throws Exception {

        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123";
        String driverName = "com.mysql.jdbc.Driver";
        Class.forName(driverName);
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }

    @Test
    public void testConnection5() throws Exception {

        InputStream inputStream = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driverName = properties.getProperty("driverName");

        Class.forName(driverName);
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }

}
