package com.lianghaozhang.beans;

import org.springframework.beans.factory.InitializingBean;

public class BBB implements InitializingBean {

    public BBB() {
        System.out.println("bean实例化");
    }

    public void init(){
        System.out.println("bean初始化");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("bean进行属性设置");
    }
}
