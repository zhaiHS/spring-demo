package ioc.annotation.test;

import ioc.annotation.config.SpringConfiguration;
import ioc.annotation.dao.UserDao;
import ioc.annotation.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class AnnotationTest {
    ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//    ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext-annotation.xml");


    private UserDao userDao = app.getBean(UserDao.class);

    private UserService userService = app.getBean(UserService.class);

    private DataSource dataSource = app.getBean(DataSource.class);
    @Test
    public void userDaoTest() {
        userDao.save();
    }

    @Test
    public void userServiceTest() {
        userService.save();
    }

    @Test
    public void lifeCycleTest() {
        ClassPathXmlApplicationContext applicationContext = (ClassPathXmlApplicationContext) app;
        applicationContext.close();
    }


    @Test
    public void dataSourceTest() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
