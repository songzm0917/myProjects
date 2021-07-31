package com.ming.controller;

import com.ming.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Override
    public String toString() {
        return "CustomerController{" +
                "customerService=" + customerService +
                '}';
    }
}
