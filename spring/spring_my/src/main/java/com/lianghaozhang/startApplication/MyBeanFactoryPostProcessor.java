package com.lianghaozhang.startApplication;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanFactoryPostProcessor {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("myBeanFactoryPostProcessor.xml");
        System.out.println(context.getBean("user100"));
    }
}
