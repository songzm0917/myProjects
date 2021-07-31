package com.ming.config;

import com.ming.bean.C;
import com.ming.bean.Car;
import com.ming.bean.Person;
import com.ming.bean.Red;
import com.ming.condition.LinuxCondition;
import com.ming.condition.WindowsCondition;
import com.ming.dao.CustomerDao;
import com.ming.factory.DemoFactoryBean;
import com.ming.selector.MyImportBeanDefinitionRegistrar;
import com.ming.selector.MyImportSelector;
import org.springframework.context.annotation.*;

@PropertySource(value={"classpath:/person.properties","classpath:/db.properties"},encoding="UTF-8")
@ComponentScan("com.ming")
@Configuration
@Import({Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MyConfig2 {

    @Bean(initMethod="init",destroyMethod="detory")
    public Car car(){
        return new Car();
    }

    @Conditional(value = WindowsCondition.class)
    @Bean
    public Person person1(){
        return new Person("window",18);
    }

    @Conditional(value = LinuxCondition.class)
    @Bean
    public Person person2(){
        return new Person("linux",16);
    }

    @Bean("Demo")
    public DemoFactoryBean demoFactoryBean() {
        return new DemoFactoryBean();
    }

    @Primary
    @Bean("customerDao2")
    public CustomerDao customerDao() {
        CustomerDao customerDao = new CustomerDao();
        customerDao.setLabel("2");
        return customerDao;
    }
}
