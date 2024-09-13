package com.lianghaozhang.processor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyBeanDefinitionRegistryPostProcessor {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanDefinitionRegistryPostProcessor.xml");
        System.out.println(context.getBeanDefinitionCount());
    }
}
