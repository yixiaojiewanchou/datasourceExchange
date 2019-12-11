package com.datasourceExchange.controller;

import com.datasourceExchange.dao.ClassesDao;
import com.datasourceExchange.pojo.Classes;
import com.datasourceExchange.pojo.User;
import com.datasourceExchange.service.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * mybatis查询list嵌套list
 */
@RestController
public class ClassesController {

    @Autowired
    private IClassesService classesService;

    @Autowired
    private ClassesDao classesDao;

    @GetMapping("/classes")
    public List<Classes> selectClassesList(){
        return classesService.selectClassesList();
    }

    @GetMapping("/classes1")
    public List<User> selectClassesList1(){
        return classesDao.selectUserList();
    }
}
