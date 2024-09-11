package com.lianghaozhang.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("spring自动调用了BeanFactoyPostProcessor");
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userDao");
//        System.out.println(beanDefinition);
        beanDefinition.setBeanClassName("com.lianghaozhang.beans.Abc");
    }
}
