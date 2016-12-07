package net.xuele.spring.aop;


/**
 * Created by yejunjie on 2016/12/6.
 */
public class UserServiceImpl implements UserService {
    public void delete(){
        System.out.println("删除用户信息");

        Integer a =null;
        a.longValue();
    }

    public void save() {
        System.out.println("保存用户信息");
    }

    public void update() {
        System.out.println("更新用户信息");
    }
}
