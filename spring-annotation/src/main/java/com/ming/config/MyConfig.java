package com.ming.config;

import com.ming.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScans(
        {
                @ComponentScan(value = "com.ming",includeFilters = {
                        //@ComponentScan.Filter(type = FilterType.ANNOTATION,classes ={Controller.class} ),

                        @ComponentScan.Filter(type = FilterType.CUSTOM,classes ={CustomFilter.class} )

                },useDefaultFilters = false)
        }

)
public class MyConfig {


    //singleton prototype request session
   /* @Bean
    @Lazy
    @Scope(value = "singleton")
    public Person person() {
        System.out.println("实例化。。。。。。。。。");
        return new Person("张三",19);
    }*/
}
