package com.lianghaozhang.my.beans;

import org.springframework.lang.Nullable;

public class MyBeanDefinition {
    private String beanName;
    private Class<?> beanClass;
    @Nullable()
    private String[] properties = new String[0];

    public MyBeanDefinition() {
    }

    public MyBeanDefinition(String beanName, Class<?> beanClass) {
        this.beanName = beanName;
        this.beanClass = beanClass;
    }

    public MyBeanDefinition(String beanName, Class<?> beanClass, @Nullable String[] properties) {
        this.beanName = beanName;
        this.beanClass = beanClass;
        this.properties = properties;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    @Nullable
    public String[] getProperties() {
        return properties;
    }

    public void setProperties(@Nullable String[] properties) {
        this.properties = properties;
    }
}
