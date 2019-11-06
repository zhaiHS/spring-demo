package aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author zhaihs
 * @date 2019/11/6
 */
@Component("myAspect")
@Aspect
public class MyAspect {

    @Around("MyAspect.pointcut()")
    public Object around(ProceedingJoinPoint pjb) throws Throwable {
        System.out.println("enhance before method");
        Object proceed = pjb.proceed();
        System.out.println("enhance after method");
        return proceed;
    }

    @Pointcut("execution(* aop.annotation.Target.method(..))")
    public void pointcut() {}
}
