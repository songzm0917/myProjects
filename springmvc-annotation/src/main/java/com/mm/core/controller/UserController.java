package com.mm.core.controller;

import com.mm.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        userService.say();
        return "success";
    }


    @RequestMapping("/users")
    public String users() {
        userService.say();
        return "hello";
    }
}
