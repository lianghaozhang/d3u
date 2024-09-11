package com.lianghaozhang.processor;

import com.lianghaozhang.beans.AAA;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof AAA){
            AAA aaa = (AAA)bean;
            aaa.setName("阿牛");
            aaa.setAge(20);
        }
        System.out.println("bean的后处理器，在bean的初始化之前执行");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean的后处理器，在bean初始化之后执行");
        return bean;
    }
}
