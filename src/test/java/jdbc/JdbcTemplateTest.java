package jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import transaction.pojo.User;

import java.util.List;

/**
 * @author zhaihs
 * @date 2019/11/6
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-jdbc.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void jdbcTemplateTest() {
        List<User> query =
                jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<User>(User.class));
        System.out.println(query);
    }

}
