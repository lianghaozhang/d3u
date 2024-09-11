package com.lianghaozhang.reflect;

import com.lianghaozhang.beans.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyReflect {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.lianghaozhang.beans.Student");
        Student s1;
        Student s2;
        // 获取类的构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
             System.out.println(declaredConstructor.getName() + " ---> " + declaredConstructor.getParameterCount());
        }
        System.out.println("-----------------------");
        // 使用无参构造创建对象
        Constructor<?> c1 = clazz.getDeclaredConstructor();
        s1 = (Student) c1.newInstance();
        System.out.println(s1);
        System.out.println("-----------------------");
        // 使用有参构造创建对象
        Constructor<?> c2 = clazz.getDeclaredConstructor(int.class, String.class, int.class);
        s2 = (Student) c2.newInstance(1001, "妈滴雅", 20);
        System.out.println(s2);
        System.out.println("-----------------------");

        // 获取类的成员变量
        for (Field declaredField : clazz.getDeclaredFields()) {
            System.out.println(declaredField);
        }
        System.out.println("-----------------------");
        //使用使用成员变量
        Student s3 = new Student();
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(s3, "翻盖");
        System.out.println(name.get(s3));

        // 获取类的成员方法
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            System.out.println(declaredMethod.getName() + " ---> " + declaredMethod.getParameterCount());
        }
        Student s4 = new Student();
        Method setName4 = clazz.getDeclaredMethod("setName", String.class);
        setName4.invoke(s4, "阿牛");
        Method getName4 = clazz.getDeclaredMethod("getName");
        System.out.println(getName4.invoke(s4));
        Field f4 = clazz.getDeclaredField("name");
        f4.setAccessible(true);
        System.out.println(f4.get(s4));
    }
}
