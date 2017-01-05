package net.xuele.spring.aop;


import org.aspectj.lang.ProceedingJoinPoint;

/** 通过 ProceedingJoinPoint 来获取类名方法名的信息  只有环绕通知才能有此入参
* Created by yejunjie on 2016/12/6.
*/
public class OptLogger {

    public Object logger(ProceedingJoinPoint pjp) throws Throwable {
        //proceed()方法有执行目标对象的功能
        Object obj = pjp.proceed();
        //获取方法名
        String method = pjp.getSignature().getName();
        //获取目标对象类名
        String clazzName = pjp.getTarget().getClass().getName();
        System.out.println( "执行了" + clazzName + "的" + method + "方法");
        return obj;
    }

}
