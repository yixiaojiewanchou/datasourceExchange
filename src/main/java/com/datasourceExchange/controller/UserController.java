package com.datasourceExchange.controller;

import com.datasourceExchange.pojo.User;
import com.datasourceExchange.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

//  @Resource(name="userServiceImpl")
    @Autowired
    @Qualifier("userServiceImpl")
    private IUserService userService;

//  @Resource(name="userServiceAnnoImpl")
    @Autowired
    @Qualifier("userServiceAnnoImpl")
    private IUserService userServiceAnno;

    @GetMapping("/test1")
    public List<User> test1(){
        return userService.selectUserFromDB1();
    }


    @GetMapping("/test2")
    public List<User> test2(){
        return userService.selectUserFromDB2();
    }

    @GetMapping("/test3")
    public List<User> test3(){
        return userService.selectUserFromDB11();
    }

    @GetMapping("/test4")
    public List<User> test4(){
        return userService.selectUserFromDB22();
    }




    @GetMapping("/test5")
    public List<User> test5(){
        return userServiceAnno.selectUserFromDB1();
    }

    @GetMapping("/test6")
    public List<User> test6(){
        return userServiceAnno.selectUserFromDB2();
    }

    @GetMapping("/test7")
    public List<User> test7(){
        return userServiceAnno.selectUserFromDB11();
    }

    @GetMapping("/test8")
    public List<User> test8(){
        return userServiceAnno.selectUserFromDB22();
    }

}
