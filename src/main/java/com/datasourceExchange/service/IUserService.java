package com.datasourceExchange.service;

import com.datasourceExchange.pojo.User;

import java.util.List;

public interface IUserService {

    List<User> selectUserFromDB1();

    List<User> selectUserFromDB2();

    List<User> selectUserFromDB11() ;

    List<User> selectUserFromDB22();
}
