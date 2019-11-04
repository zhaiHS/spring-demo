package instantiation;

import pojo.User;

public class UserStaticFactory {
    public static User createUser() {
        return  new User("static factory instantitation");
    }
}
