package com.lianghaozhang.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class MyBeanFactoryPostProcessor2 implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor2正常工作");
//        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userDao");
//        System.out.println(beanDefinition.getBeanClassName());
//        beanDefinition.setBeanClassName("com.lianghaozhang.beans.Abc");
//        System.out.println(beanDefinition.getBeanClassName());
        BeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName("com.lianghaozhang.beans.Abc");
//        设置成懒加载后会先将bean配置到beanDefinitionMap中，但是不会实例化放入单例池中，而是在用到时才会实例化放入单例池中
//        beanDefinition.setLazyInit(true);
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
        defaultListableBeanFactory.registerBeanDefinition("aaabbbccc", beanDefinition);
    }
}
