package com.lianghaozhang.factory;

import com.lianghaozhang.beans.Abc;
import com.lianghaozhang.dao.UserDao;
import com.lianghaozhang.dao.impl.UserDaoImpl;

public class MyBeanModel_static {

    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }

    public static Abc getAbc() {
        return new Abc();
    }
}
