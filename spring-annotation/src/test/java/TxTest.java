import com.ming.config.TxConfig;
import com.ming.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TxTest {

    @Test
    public void test01() throws SQLException {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(TxConfig.class);

        UserService userService = ioc.getBean(UserService.class);

        userService.queryUser();

    }
}
