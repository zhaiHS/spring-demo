package dynamic.proxy.jdk;

/**
 * @author zhaihs
 */
public class Target implements TargetInterface {
    @Override
    public void targetMethod() {
        System.out.println("target method running ......");
    }
}
