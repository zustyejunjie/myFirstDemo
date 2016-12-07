package net.xuele.spring.aop.annotation;

import org.springframework.stereotype.Service;

/**
 * Created by yejunjie on 2016/12/7.
 */
@Service("jdbcUserDao")
public class JDBCUserDAO implements UserDAO {
    public void save() {
        System.out.println("DAO##采用JDBC技术保存用户信息！");
    }

    public void update() {
        System.out.println("DAO##采用JDBC技术更新用户信息！");
    }

}
