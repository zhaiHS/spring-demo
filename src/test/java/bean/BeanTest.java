package bean;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import di.BasicDI;
import di.ListDI;
import di.MapDI;
import di.PropertiesDI;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

public class BeanTest {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void noArgumentsInstantiationBeanTest() {
        User bean = (User) applicationContext.getBean("user");
        System.out.println(bean);
    }

    @Test
    public void staticFactoryInstantiationBeanTest() {
        User bean = (User) applicationContext.getBean("user4StaticFactory");
        System.out.println(bean);
    }

    @Test
    public void dynamicFactoryInstantiationBeanTest() {
        User bean = (User) applicationContext.getBean("user4DynamicFactory");
        System.out.println(bean);
    }

    @Test
    public void constructorDITest() {
        User bean = (User) applicationContext.getBean("user4Constructor");
        System.out.println(bean);
    }

    @Test
    public void setDITest() {
        User bean = (User) applicationContext.getBean("user4Set");
        System.out.println(bean);
    }

    @Test
    public void setDIWithPTest() {
        User bean = (User) applicationContext.getBean("user4p");
        System.out.println(bean);
    }
    @Test
    public void basicDITest() {
        BasicDI bean = applicationContext.getBean(BasicDI.class);
        System.out.println(bean);
    }

    @Test
    public void listDITest() {
        ListDI bean = applicationContext.getBean(ListDI.class);
        System.out.println(bean);
    }

    @Test
    public void mapDITest() {
        MapDI bean = applicationContext.getBean(MapDI.class);
        System.out.println(bean);
    }

    @Test
    public void propertiesDITest() {
        PropertiesDI bean = applicationContext.getBean(PropertiesDI.class);
        System.out.println(bean);
    }

    @Test
    public void DatasourceTest() {
        ComboPooledDataSource bean = applicationContext.getBean(ComboPooledDataSource.class);
        System.out.println(bean);
    }
}
