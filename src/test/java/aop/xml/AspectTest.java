package aop.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaihs
 * @date 2019/11/5
 */
public class AspectTest {
    ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext-aop-xml.xml");

    @Test
    public void aspectTest() {
        TargetInterface bean = app.getBean(TargetInterface.class);
        bean.method();
    }
}
