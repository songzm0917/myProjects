package com.ming.factory;

import com.ming.bean.Demo;
import org.springframework.beans.factory.FactoryBean;

public class DemoFactoryBean implements FactoryBean<Demo> {

    public Demo getObject() throws Exception {
        return new Demo();
    }

    public Class<?> getObjectType() {
        return Demo.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
