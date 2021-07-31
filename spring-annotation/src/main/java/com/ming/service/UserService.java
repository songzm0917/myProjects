package com.ming.service;

import com.ming.bean.User;
import com.ming.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    @Transactional
    public void insertUser () {
        userDao.insert();
        System.out.println("插入完成！");
        int i = 10 /0 ;
    }

    public void queryUser () {
        User query = userDao.query();
        if(query ==null ) {
            System.out.println("空");
        }else {
            System.out.println(query);
        }

    }

    public void queryAllUser () {
        List<User> users = userDao.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
