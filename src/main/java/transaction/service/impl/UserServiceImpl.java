package transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transaction.dao.UserDao;
import transaction.service.UserService;

/**
 * @author zhaihs
 * @date 2019/11/6
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void transfer(String inName, String outName, int money) throws Exception {
        if (userDao.getBalance(outName) < money) {
            throw new Exception("money is not enough in account: " + inName);
        }

        userDao.out(outName, money);
//       generate java.lang.ArithmeticException
//        int i = 1 / 0;
        userDao.in(inName, money);
    }
}
