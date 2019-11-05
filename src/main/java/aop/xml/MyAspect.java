package aop.xml;


import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author zhaihs
 * @date 2019/11/5
 *
 * 切面类
 */

public class MyAspect {

    public void around(ProceedingJoinPoint pjb) throws Throwable {
        System.out.println("环绕前通知");
        pjb.proceed();
        System.out.println("环绕后通知");
    }
}
