package instantiation;

import pojo.User;

public class UserDynamicFactory {
    public User createUser() {
        return new User("dynamic factory method instantiation");
    }
}
