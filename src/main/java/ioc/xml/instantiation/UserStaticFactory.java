package ioc.xml.instantiation;

import ioc.xml.pojo.User;

public class UserStaticFactory {
    public static User createUser() {
        return  new User("static factory instantitation");
    }
}
