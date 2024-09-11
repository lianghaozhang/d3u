package com.lianghaozhang.factory;

import com.lianghaozhang.beans.Abc;
import com.lianghaozhang.dao.UserDao;
import com.lianghaozhang.dao.impl.UserDaoImpl;

public class MyBeanModel {

    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

    public Abc getAbc() {
        return new Abc();
    }
}
