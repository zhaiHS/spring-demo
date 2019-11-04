package service.impl;

import dao.UserDao;
import service.UserService;

public class UserServiceImpl2 implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {

    }
}
