package com.lianghaozhang.factory;

import com.lianghaozhang.beans.Abc;
import org.springframework.beans.factory.FactoryBean;

public class MyBeanModel3 implements FactoryBean<Abc> {

    @Override
    public Abc getObject() throws Exception {
        System.out.println("执行了getObject");
        return new Abc();
    }

    @Override
    public Class<?> getObjectType() {
        return Abc.class;
    }
}
