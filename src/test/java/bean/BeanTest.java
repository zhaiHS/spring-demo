package bean;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

public class BeanTest {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void noArgumentsInstantiationTest() {
        User bean = (User) applicationContext.getBean("user");
        System.out.println(bean);
    }

    @Test
    public void staticFactoryBeanTest() {
        User bean = (User) applicationContext.getBean("user4StaticFactory");
        System.out.println(bean);
    }
}
