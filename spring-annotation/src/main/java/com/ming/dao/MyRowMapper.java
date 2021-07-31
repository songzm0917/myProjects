package com.ming.dao;

import com.ming.bean.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyRowMapper implements org.springframework.jdbc.core.RowMapper<Object> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        String id = rs.getString("id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        /*String age = rs.getString("id");
        String id = rs.getString("id");*/

        return null;
    }
}
