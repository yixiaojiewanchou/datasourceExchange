package com.datasourceExchange.service.impl;

import com.datasourceExchange.dao.ClassesDao;
import com.datasourceExchange.pojo.Classes;
import com.datasourceExchange.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * mybatis查询list嵌套list
 */
@Service
public class ClassesServiceImpl implements IClassesService {

    @Autowired
    private ClassesDao classesDao;

    @Override
    public List<Classes> selectClassesList() {
        return classesDao.selectClassesList();
    }
}
