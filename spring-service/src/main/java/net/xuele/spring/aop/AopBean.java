package net.xuele.spring.aop;

/**
 * Created by yejunjie on 2016/12/7.
 */
public class AopBean {

    //前置通知方法
    public void mybefore(){
        System.out.println("--前置通知--");
    }

    //后置通知方法 方法未抛出异常时   可以得到方法的返回值
    public void myafterReturning(Object retVal){
        System.out.println("--后置通知--" + retVal);
    }

    //异常通知方法 方法抛出异常后 可以得到异常实例
    public void myafterException(Exception ex){
        System.out.println("--异常通知begin--");
        ex.printStackTrace();
        System.out.println("--异常通知end--");
    }

    //最终通知 不管是否抛出异常
    public void myafter(){
        System.out.println("--最终通知--");
    }
}
