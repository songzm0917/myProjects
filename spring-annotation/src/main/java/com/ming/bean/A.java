package com.ming.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class A implements InitializingBean, DisposableBean {
    public void destroy() throws Exception {
        System.out.println("A....destroy");
    }

    public void afterPropertiesSet() throws Exception {

        System.out.println("A....init");
    }
}
