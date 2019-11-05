package ioc.xml.bean;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import ioc.xml.di.BasicDI;
import ioc.xml.di.ListDI;
import ioc.xml.di.MapDI;
import ioc.xml.di.PropertiesDI;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ioc.xml.pojo.User;

import javax.sql.DataSource;
import java.sql.SQLException;

public class BeanTest {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-xml.xml");

    @Test
    public void lifeCycleTest() {
        User user = (User) applicationContext.getBean("lifeCycleUser");
        ClassPathXmlApplicationContext app = (ClassPathXmlApplicationContext) this.applicationContext;
        app.close();
    }

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
    public void DatasourceTest() throws SQLException {
        DataSource bean = applicationContext.getBean(ComboPooledDataSource.class);
        System.out.println(bean.getConnection());
    }
}
