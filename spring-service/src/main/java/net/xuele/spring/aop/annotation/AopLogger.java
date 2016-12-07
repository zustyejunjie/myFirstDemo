package net.xuele.spring.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by yejunjie on 2016/12/7.
 */
@Component("aopLogger")
@Aspect //声明是
public class AopLogger {

    @Pointcut("within(net.xuele.spring.aop.annotation.*)")
    public void servicePointcut() {
    }

    @Around("servicePointcut()")
    public Object logger(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("-------");
        //proceed()方法有执行目标对象的功能
        Object obj = pjp.proceed();
        //获取方法名
        String method = pjp.getSignature().getName();
        //获取目标对象类名
        String clazzName = pjp.getTarget().getClass().getName();
//        System.out.println("执行了" + clazzName + "的" + method + "方法");
        return obj;
    }
}
