package com.datasourceExchange.dao;

import com.datasourceExchange.pojo.Classes;
import com.datasourceExchange.pojo.User;

import java.util.List;

public interface ClassesDao {
    List<Classes> selectClassesList();

    List<User> selectUserList();
}
