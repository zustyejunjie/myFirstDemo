package net.xuele.spring.aop.annotation;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yejunjie on 2016/12/7.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name="jdbcUserDao")
    private UserDAO userDao;

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public void regist() {
        System.out.println("Service##用户注册处理");
        userDao.save();
    }

    public void update() {
        System.out.println("Service##用户修改个人信息处理");
        userDao.update();
    }
}
