package com.lianghaozhang.myJunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {

//    @MyTest
    public void aaa(){
        System.out.println("111");
    }

    @MyTest
    public void bbb(){
        System.out.println("222");
    }

//    @MyTest
    public void ccc(){
        System.out.println("333");
    }

    @MyTest
    public void ddd(){
        System.out.println("444");
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
//        Demo demo = new Demo();
//        Class<?> clazz = demo.getClass();
        Class<?> clazz = Class.forName("com.lianghaozhang.myJunit.Demo");
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getAnnotation(MyTest.class) != null) {
                method.setAccessible(true);
                method.invoke(new Demo());
            }
        }
    }
}
