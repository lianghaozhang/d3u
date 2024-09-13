package com.lianghaozhang.processor;

import com.lianghaozhang.anno.MyComponent;
import com.lianghaozhang.my.utils.ScanPackage;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.List;

/*
* 通过BeanDefinitionRegistryPostProcessor后处理器配合扫描注解进行将带有自定义
* 注解的类进行配置到BeanDefinitionMap中
*
* */

public class MyBeanDefinitionRegistryPostProcessor2 implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        List<Class<?>> classes;
        String value;
        try {
            classes = ScanPackage.getClasses("com.lianghaozhang.my.beans");
            for (Class<?> clazz : classes) {
                if (!clazz.getDeclaredAnnotation(MyComponent.class).value().isEmpty()) {
                    value = clazz.getAnnotation(MyComponent.class).value();
                }else {
                    value = clazz.getName();
                }
//                System.out.println(value);
                beanDefinitionRegistry.registerBeanDefinition(value, new RootBeanDefinition(clazz));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }

}
