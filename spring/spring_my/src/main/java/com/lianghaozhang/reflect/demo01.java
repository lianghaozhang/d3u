package com.lianghaozhang.reflect;

import com.lianghaozhang.beans.Student;
import com.lianghaozhang.beans.User;

import java.lang.reflect.Field;

/*
*  实现对于任意对象都可以拿到字段名对应的值
*
* */
public class demo01 {
    public static void main(String[] args) throws IllegalAccessException {
        Student student = new Student(10011, "小野", 20);
        User user = new User(10012, "aniu", 21, "xxx-xxx-xxx", "13977133257");
        saveField(student);
        saveField(user);
    }

    public static void saveField(Object o) throws IllegalAccessException {
        // 拿到传入对象的字节码对象
        Class<?> clazz = o.getClass();
        String simpleName = clazz.getSimpleName();
        System.out.println("------" + simpleName + "------");
        // 获取所有属性，并遍历所有属性
        for (Field declaredField : clazz.getDeclaredFields()) {
//            System.out.println(declaredField.getName());
            // 不进行权限校验
            declaredField.setAccessible(true);
            // 获取每个属性的名字和每个属性的值
            /*
            * 当传入的对象是Student时，就相当于获取student中每个属性的值
            * 当传入的对象是User时，就相当于获取user中每个属性的值
            *
            * */
            System.out.println(declaredField.getName() + ": " + declaredField.get(o));
        }
        System.out.println();
    }
}
