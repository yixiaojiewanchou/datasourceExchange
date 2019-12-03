package com.datasourceExchange.service.impl;

import com.datasourceExchange.dao.UserDao;
import com.datasourceExchange.pojo.User;
import com.datasourceExchange.service.IUserTransactionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserTransactionServiceServiceImpl implements IUserTransactionService {

    private static final Logger log = Logger.getLogger(UserTransactionServiceServiceImpl.class);

    @Autowired
    private UserDao userDao;

    /**
     * 如果用try-catch捕获业务中的异常，事务注解(基于xml的aop的事务配置也一样)就会失效，第一条sql不会回滚
     * catch完全是画蛇添足
     *
     * @return
     */
    @Override
    //@Transactional(rollbackFor = Exception.class)
    public int insertUser() {
            User user=new User();

            user.setId(3);
            user.setName("1");
            userDao.insertUser(user);

            user.setId(3);//重复key异常
            user.setName("1");
            userDao.insertUser(user);

            return 1;
    }
}
