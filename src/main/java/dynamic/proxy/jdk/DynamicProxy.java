package dynamic.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhaihs
 * @date 2019/11/5
 */
public class DynamicProxy {

    /**
     * 增强的目标方法名
     */
    private static String targetMethodName = "targetMethod";

    /**
     * 创建目标对象
     */
    private static Target target = new Target();

    public static void proxy() {

        // 获取代理对象
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 判断是否为目标方法
                if (targetMethodName.equals(method.getName())) {
                    // 前置增强
                    System.out.println("before enhance");
                    // 目标方法执行
                    Object invoke = method.invoke(target, args);
                    // 后置增强
                    System.out.println("after enhance");
                    // 返回结果
                    return invoke;
                }
                // 非需增强的目标方法，直接执行
                return method.invoke(target, args);
            }
        });

        // 执行代理对象的增强方法
        proxy.targetMethod();
    }

    /**
     * main 方法测试
     */
    public static void main(String[] args) {
        proxy();
    }
}
