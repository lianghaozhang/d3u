import Beans.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection {
    public static void main(String[] args) throws Exception {
//        通过反射获取类信息
        Class<?> clazz = Class.forName("Beans.User");

//        通过反射获取类中的成员
        Field id = clazz.getField("id");
        System.out.println(id);
        //获取公共的属性，私有的获取不到
        Field[] fields = clazz.getFields();
        // 获取所有属性，包括私有属性，获取类中私有的属性或者方法要使用带有Declared的方法
        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println(Arrays.toString(fields));
        System.out.println(Arrays.toString(declaredFields));
        System.out.println("=================================================================");


//        通过反射获取类的方法
        //获取单个指定方法
        Method method = clazz.getMethod("getId");
        System.out.println(method);

        User u1 = (User) clazz.getDeclaredConstructor().newInstance();
//        获取指定方法，参数为方法名和方法的参数类型，通过这个参数指定可以区分方法的重载
        Method setName = clazz.getDeclaredMethod("setName", String.class);
//        invoke方法的参数表示的是要执行哪个user对象的setName方法，并且参数是什么
        setName.invoke(u1, "妈滴雅");
        System.out.println(u1.getName());
        System.out.println("=================================================================");
        // 获取所有方法，包括私有的
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));

//        通过反射获取类的构造方法
        // 获取无参构造
        Constructor<?> constructor1 = clazz.getConstructor();
        System.out.println(constructor1);
        // 获取指定参数的构造方法
        Constructor<?> constructor2 = clazz.getConstructor(int.class);
        System.out.println(constructor2);
        // 获取所有构造方法
        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println(Arrays.toString(constructors));

//        通过构造方法进行对象的创建
        // 直接通过获取的类对象进行实例化
        Object o1 = clazz.newInstance();
        System.out.println(o1);
        // 通过获取类的构造方法进行实例化
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(int.class, String.class, int.class);
        Object o2 = declaredConstructor.newInstance(001, "aniu", 20);
        System.out.println(o2);

//        通过反射API对属性进行操作
//        通过构造函数创建实例
        User u3 = (User) clazz.getConstructor().newInstance();
//        获取类中的属性，因为id是public修饰的属性，所以不用getDeclaredField()方法
        Field u3_id = clazz.getField("id");
//        将属性u3_id设置到哪个对象中，值是1234； 相当于u3.setId(1234)
        u3_id.set(u3, 1234);
//        相当于u3.getId()
        System.out.println(u3_id.get(u3));
//        因为name属性是private修饰的属性，所以获取的时候使用普通的getField()方法是获取不到的，所以要使用getDeclareField()方法获取私有的属性
        Field u3_name = clazz.getDeclaredField("name");
//        以为这个属性是私有的，所以直接使用set进行赋值的时候会报错，所以需要这行代码。
//        这行代码表示的意思是这个属性不用做安全检验了，直接可以访问。在私有的方法中也可以通过这样的方式进行访问
        u3_name.setAccessible(true);
        u3_name.set(u3, "翻盖");
        System.out.println(u3_name.get(u3));
    }
}
