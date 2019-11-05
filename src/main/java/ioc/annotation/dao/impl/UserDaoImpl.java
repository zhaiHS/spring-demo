package ioc.annotation.dao.impl;

import ioc.annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

//@Component("userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("saving ............");
    }
}
