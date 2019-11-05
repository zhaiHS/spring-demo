package dynamic.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhaihs
 * @date 2019/11/5
 */
public class TargetProxy {
    public static void main(final String[] args) {
        final Target target = new Target();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before enhance");
                Object invoke = method.invoke(target, objects);
                System.out.println("after enhance");
                return invoke;
            }
        });
        Target proxyTarget = (Target) enhancer.create();
        proxyTarget.method();
    }
}
