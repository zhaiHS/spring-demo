package aop.annotation;

import org.springframework.stereotype.Component;

/**
 * @author zhaihs
 * @date 2019/11/6
 */
@Component
public class Target implements TargetInterface {
    @Override
    public void method() {
        System.out.println("target method run.........");
    }
}
