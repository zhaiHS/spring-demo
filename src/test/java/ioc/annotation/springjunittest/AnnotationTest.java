package ioc.annotation.springjunittest;

import ioc.annotation.config.SpringConfiguration;
import ioc.annotation.dao.UserDao;
import ioc.annotation.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class AnnotationTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DataSource dataSource;

    @Test
    public void userDaoTest() {
        userDao.save();
    }

    @Test
    public void userServiceTest() {
        userService.save();
    }

    @Test
    public void dataSourceTest() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
