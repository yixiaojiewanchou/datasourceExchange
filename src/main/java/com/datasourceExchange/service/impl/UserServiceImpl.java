package com.datasourceExchange.service.impl;

import com.datasourceExchange.dao.UserDao;
import com.datasourceExchange.datasource.DataSourceContextHolder;
import com.datasourceExchange.pojo.User;
import com.datasourceExchange.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 代码的方式手动切换数据源：
 *
 * 切换完数据源后，记得需要清除数据源，然后会还给默认的数据源
 */

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    public void test(){
        //切换到mysql2_dataSource的数据源
        DataSourceContextHolder.setDBType("mysql2_dataSource");
        // 清除mysql2_dataSource数据源，会还给默认的数据源
        DataSourceContextHolder.clearDBType();
    }


    @Override
    public List<User> selectUserFromDB1() {
        DataSourceContextHolder.setDBType("mysql1_dataSource");
        return userDao.selectUserFromDB1();
    }

    @Override
    public List<User> selectUserFromDB2() {
        DataSourceContextHolder.setDBType("mysql2_dataSource");
        List<User> userList=userDao.selectUserFromDB2();
        DataSourceContextHolder.clearDBType();
        return userList;
    }

    //因为上面selectUserFromDB2()方法，还给了默认数据源，所以用的1数据库，没问题
    @Override
    public List<User> selectUserFromDB11() {
        return userDao.selectUserFromDB1();
    }

    //因为上面selectUserFromDB2()方法，还给了默认数据源，所以用的1数据库，会冲突了
    @Override
    public List<User> selectUserFromDB22() {
        return userDao.selectUserFromDB2();
    }
}
