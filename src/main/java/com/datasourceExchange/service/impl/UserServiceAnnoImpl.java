package com.datasourceExchange.service.impl;

import com.datasourceExchange.dao.UserDao;
import com.datasourceExchange.datasource.DataSource;
import com.datasourceExchange.pojo.User;
import com.datasourceExchange.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 注解的方式切换数据源：
 *     在类上面加注解，添加所有方法的默认数据源，所以用完不用还回去，每次都会赋值默认数据源
 *     在方法上面的数据源会覆盖类的注解，以此实现切换其他的数据源
 */

/**
 *      注解指明使用哪一个数据源
 *      aop指明在那些方法前添加intercept()方法，即intercept()会拦截哪些方法
 *      intercept()方法寻找完注解后，根据注解判断切换哪一个数据源数据源
 */

//@DataSource(DataSource.mysql1)
@Service("userServiceAnnoImpl")
public class UserServiceAnnoImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectUserFromDB1() {
        return userDao.selectUserFromDB1();
    }

    @DataSource(DataSource.mysql2)
    @Override
    public List<User> selectUserFromDB2() {
        return userDao.selectUserFromDB2();
    }

    @Override
    public List<User> selectUserFromDB11() {
        return userDao.selectUserFromDB1();
    }

    @Override
    public List<User> selectUserFromDB22() {
        return userDao.selectUserFromDB2();
    }
}
