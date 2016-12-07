package net.xuele.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yejunjie on 2016/12/6.
 */
public class Test {

    private static final String CONFIG = "aop.xml";

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(CONFIG);
        UserService userService = (UserService) ac.getBean("userserivce");
        userService.update();
        userService.save();
        userService.delete();
    }
}
