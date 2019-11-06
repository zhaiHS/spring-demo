package transaction.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import transaction.dao.UserDao;

/**
 * @author zhaihs
 * @date 2019/11/6
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void out(String name, Integer money) {
        jdbcTemplate.update("update account set balance = balance - ? where name=?", money, name);
    }

    @Override
    public void in(String name, Integer money) {
        jdbcTemplate.update("update account set balance = balance + ? where name=?", money, name);
    }

    @Override
    public Long getBalance(String name) {
        return jdbcTemplate.queryForObject("select balance from account where name = ?", new String[]{name}, Long.class);
    }
}
