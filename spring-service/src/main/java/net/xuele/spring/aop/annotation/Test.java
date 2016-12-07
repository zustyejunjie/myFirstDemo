package net.xuele.spring.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yejunjie on 2016/12/7.
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("annotation.xml");
        UserService userService = (UserService) ac.getBean("userService");
        userService.regist();
        userService.update();
    }
}
