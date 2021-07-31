package com.ming.dao;

import com.ming.bean.User;
import com.sun.org.apache.xpath.internal.objects.XObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert() {
        String sql = "insert into `user` (id,name,age,account,password) values (?,?,?,?,?)";
        String uuid = UUID.randomUUID().toString();
        jdbcTemplate.update(sql,uuid,"张飞",18,"admin123","admin123");
    }

    public User query() {
        List<Object> params = new ArrayList<Object>();
        String sql = "SELECT id,name,age,account,password FROM `user` where name like ? limit 1";
        params.add("%张%");
        BeanPropertyRowMapper<User> beanPropertyRowMapper = new BeanPropertyRowMapper<User>(User.class);

        List<User> users = jdbcTemplate.query(sql,params.toArray(),beanPropertyRowMapper);
        User user = users.get(0);
        return user;
    }

    public List<User> queryAll() {
        String sql = "SELECT * FROM `user` ";
        List<User> users = jdbcTemplate.queryForList(sql, User.class);
        return users;
    }
}
