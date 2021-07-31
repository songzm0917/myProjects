package com.ming.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class B {

    @PostConstruct
    public void init() {

        System.out.println("B..init");
    }

    @PreDestroy
    public void stop() {
        System.out.println("B..stop");
    }
}
