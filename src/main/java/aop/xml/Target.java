package aop.xml;

/**
 * @author zhaihs
 * @date 2019/11/5
 */
public class Target implements TargetInterface {
    @Override
    public void method() {
        System.out.println("target method running");
    }
}
