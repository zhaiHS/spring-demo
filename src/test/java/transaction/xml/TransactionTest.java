package transaction.xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import transaction.service.UserService;

/**
 * @author zhaihs
 * @date 2019/11/6
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-tx-xml.xml")
public class TransactionTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() throws Exception {
        userService.transfer("lisa", "wangwu", 2000);
    }
}
