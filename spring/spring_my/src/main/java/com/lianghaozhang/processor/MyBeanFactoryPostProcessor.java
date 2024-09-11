package com.lianghaozhang.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory);
//        在Bean实例化之前修改Bean的类型
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("user");
        beanDefinition.setBeanClassName("com.lianghaozhang.beans.Table");

//        手动将Bean配置到BeanDefinitionMap中
//        注册BeanDefinition
        BeanDefinition tableBean = new RootBeanDefinition();
//        设置BeanDefinition的类
        tableBean.setBeanClassName("com.lianghaozhang.beans.Table");
        /*
        *   因为ConfigurableListableBeanFactory中没有注册BeanDefinition的方法，
        *   但是DefaultListableBeanFactory是ConfigurableListableBeanFactory
        *   的子类实现的功能更多，所以将bean强转成DefaultListableBeanFactory类型
        *   就可以调用注册BeanDefinition方法
        * */
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
        defaultListableBeanFactory.registerBeanDefinition("table", tableBean);
    }
}
