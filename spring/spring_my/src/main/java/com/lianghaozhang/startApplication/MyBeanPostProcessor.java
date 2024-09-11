package com.lianghaozhang.startApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanPostProcessor {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("myBeanPostProcessor.xml");
        System.out.println(context.getBean("user"));
    }
}
