package com.lianghaozhang.my.start;

import com.lianghaozhang.my.anno.MyComponent;
import com.lianghaozhang.my.beans.MyBeanDefinition;
import com.lianghaozhang.my.utils.ScanPackage;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 模拟spring的ioc容器初始化过程
* 1. 从xml配置文件中读取bean，并封装成BeanDefinition对象(我用的注解)
* 2. 将BeanDefinition对象放入BeanDefinitionMap中
* 3. ioc容器循环遍历BeanDefinitionMap，对每个BeanDefinition进行实例化
* */

public class Test {
    public static final Map<String, Object> BeanDefinitionMap = new HashMap<>();
    public static void main(String[] args) throws ClassNotFoundException {
        addBeanDefinition(scanAnnotation());
        BeanDefinitionMap.forEach((k, v) -> System.out.println("key: " + k + "\n" + "value: " + v +
                "\n-----------------------------------------------------------"));
    }

    // 扫描bean，获取有MyComponent注解的类并放入ioc容器中
    public static List<Class<?>> scanAnnotation() throws ClassNotFoundException {
        System.out.println("扫描指定包获取要放入ioc的class");
        List<Class<?>> list = new ArrayList<>();
        for (Class<?> clazz : ScanPackage.getClasses("com.lianghaozhang")) {
            for (Annotation annotation : clazz.getDeclaredAnnotations()) {
                if(annotation instanceof MyComponent) {
                    // 处理有@MyComponent注解的类
                    list.add(clazz);
                }
            }
        }
        System.out.println("扫描结束\n");
        return list;
    }

    // 将要放入容器中的类封装成BeanDefinition对象，并放入BeanDefinitionMap
    public static void addBeanDefinition(List<Class<?>> list){
        System.out.println("将bean封装成BeanDefinition对象，并放入BeanDefinitionMap中");
        String id;
        // 遍历集合，将每个class对象封装成BeanDefinition对象
        for (Class<?> clazz : list) {
            id = clazz.getAnnotation(MyComponent.class).value().isEmpty() ? clazz.getName() : clazz.getAnnotation(MyComponent.class).value();
            BeanDefinitionMap.put(id, new MyBeanDefinition(id, clazz));
        }
        System.out.println("BeanDefinition属性注入完成\n");
    }

}
