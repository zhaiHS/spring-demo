package dao.factory;

import dao.UserDao;
import dao.impl.UserDaoImpl;

public class UserDaoStaticFactory {
    public static UserDao createUserDao() {
        return new UserDaoImpl();
    }
}
