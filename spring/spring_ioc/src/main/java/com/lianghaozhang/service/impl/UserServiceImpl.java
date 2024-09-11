package com.lianghaozhang.service.impl;

import com.lianghaozhang.dao.UserDao;
import com.lianghaozhang.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    //这个方法用于进行userDao的依赖注入，配置文件中的属性名就是方法名去掉set，大小写不敏感
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
//        System.out.println("这是bean工厂自动注入的userDao: " + userDao);
    }
}
