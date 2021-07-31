package com.songzm.demo3.preparedstatement.crud;

import com.songzm.demo3.bean.Customer;
import com.songzm.demo3.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementQueryTest {

    @Test
    public void testGetForList(){
        String sql = "select id,name,email from customers where id < ? ";
        List<Customer> list = getForList(Customer.class,sql,12);
        list.forEach(System.out::println);
    }

    public <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = JDBCUtils.getConnection();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                 ps.setObject(i+1,args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            ArrayList<T> list = new ArrayList<>();
            while(rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object objectVal = rs.getObject(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t,objectVal);
                }
                list.add(t);
            }
            return list;


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(con,ps,rs);
        }


        return null;

    }
}
