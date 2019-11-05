package ioc.xml.instantiation;

import ioc.xml.pojo.User;

public class UserDynamicFactory {
    public User createUser() {
        return new User("dynamic factory method instantiation");
    }
}
