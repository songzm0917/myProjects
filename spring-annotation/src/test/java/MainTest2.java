import com.ming.bean.Person;
import com.ming.config.MyConfig;
import com.ming.config.MyConfig2;
import com.ming.controller.CustomerController;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class MainTest2 {
    @Test
    public void test01 () {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfig2.class);

        /*String[] names = ioc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }*/

        CustomerController bean = (CustomerController)ioc.getBean("customerController");
        System.out.println(bean);

        ioc.close();
    }
}
