package aop.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhaihs
 * @date 2019/11/6
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-aop-annotation.xml")
public class AopTest {
    @Autowired
    private TargetInterface targetInterface;

    @Test
    public void aopTest() {
        targetInterface.method();
    }
}
