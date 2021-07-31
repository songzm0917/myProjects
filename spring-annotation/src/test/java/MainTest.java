import com.ming.bean.Person;
import com.ming.config.MyConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    @Test
    public void test01 () {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("容器初始化完成。。。。。。");
        /*String[] names = ioc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }*/
        Person person1 = (Person) ioc.getBean("person");
        Person person2 = (Person) ioc.getBean("person");
        System.out.println(person1 == person2);
    }
}
