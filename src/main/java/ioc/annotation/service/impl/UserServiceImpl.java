package ioc.annotation.service.impl;

import ioc.annotation.dao.UserDao;
import ioc.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

// @Component("userService")
@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {
    //@Autowired
    /**
     * @Autowired
     * @Qualifier("userDao")
     */
    @Resource(name = "userDao")
    private UserDao userDao;

    @Value("string")
    private String str;

    @Value("12")
    private int num;

    @Override
    public void save() {
        System.out.println(toString());
        userDao.save();
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "userDao=" + userDao +
                ", str='" + str + '\'' +
                ", num=" + num +
                '}';
    }

    @PostConstruct
    public void init() {
        System.out.println("init .........");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy .........");
    }
}
