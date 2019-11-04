package pojo;

public class User {
    private String createMethod;
    private String name;
    private Integer age;

    public User(String name, Integer age,String createMethod) {
        this.name = name;
        this.age = age;
        this.createMethod = createMethod;
    }

    public User() {
        this.createMethod = "No Arguments instantiation";
    }

    public User(String method) {
        this.createMethod = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateMethod() {
        return createMethod;
    }

    public void setCreateMethod(String createMethod) {
        this.createMethod = createMethod;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "createMethod='" + createMethod + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
