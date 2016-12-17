package net.xuele.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by yejunjie on 2016/12/14.
 */
public class ProxyTest {

    public static void main(String[] args) throws Exception{
        Car car = new Car();
        InvocationHandler h = new TimeHandler(car);
        Class<?> cls = car.getClass();
        /**
         *loader 类加载器
         *interfaces 实现接口
         *h InvocationHandler
         */
        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
        m.move();
    }
}
