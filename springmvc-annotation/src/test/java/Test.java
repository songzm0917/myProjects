import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;

public class Test {

    @org.junit.Test
    public void appTest(){
        WebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();


        String[] beanDefinitionNames = webApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
