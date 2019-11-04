package dao.factory;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class UserDaoDynamicFactory {
    public UserDao createUserDao() {
        return new UserDaoImpl();
    }
}
