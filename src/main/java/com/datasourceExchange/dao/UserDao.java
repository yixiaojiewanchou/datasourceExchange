package com.datasourceExchange.dao;

import com.datasourceExchange.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> selectUserFromDB1();

    List<User> selectUserFromDB2();
}
