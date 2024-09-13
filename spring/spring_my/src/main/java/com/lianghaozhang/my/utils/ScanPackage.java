package com.lianghaozhang.my.utils;

import com.lianghaozhang.anno.MyComponent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ScanPackage {

    private static List<Class<?>> allClasses = new ArrayList<>();

    public static void main(String[] args){
//        String packageName = "com.lianghaozhang";
//        getAllClasses(packageName);
//        for (Class<?> clazz : chooseClasses()) {
//            System.out.println(clazz.getName());
//        }
//        System.out.println(allClasses.size());
//        for (Class<?> clazz : allClasses) {
//            System.out.println(clazz.getSimpleName());
//        }
    }

   /* public static List<Class<?>> getClasses(String packageName) throws ClassNotFoundException {
        String path = packageName.replace('.', '/');
        File directory = new File(Thread.currentThread().getContextClassLoader().getResource(path).getFile());
        List<Class<?>> classes = new ArrayList<>();

        if (directory.exists()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.getName().endsWith(".class")) {
                    String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                    classes.add(Class.forName(className));
                }
            }
        }
        return classes;
    }*/

    public static List<Class<?>> getClasses(String packageName) throws ClassNotFoundException {
        getAllClasses(packageName);
        return chooseClasses();
    }

    // 扫描指定包名及其子包下的字节码文件并存储
    private static void getAllClasses(String packageName) throws ClassNotFoundException {
        // 将包名中的.换成/
        String path = packageName.replace('.', '/');
        // 获取当前线程的类加载器，getResource(path)是获取path的URL对象，getFile()表示获取URL中的文件系统路径
        String file = Thread.currentThread().getContextClassLoader().getResource(path).getFile();
        // 创建一个文件对象
        File directory = new File(file);
        /*System.out.println("当前位置：" + directory);
        System.out.println("-----");*/

        // 判断该文件是否存在
        if (directory.exists()) {
            // 存在的话获取文件夹下的文件列表
            File[] files = directory.listFiles();
            // 循环文件列表并判断是文件还是文件夹
            for (File f : files) {
                // 如果是文件夹则递归的进入文件夹进行遍历
                if (f.isDirectory()) {
                    // System.out.println("进入" + packageName + "." + f.getName());
                    // packageName是该层文件夹，拼接要进入的文件夹名称进行递归
                    getAllClasses(packageName + "." + f.getName());
                } else {
                    // 如果不是文件夹就判断是否是以.class结尾的字节码文件
                    if (f.getName().endsWith(".class")) {
                        // 去除后面的.class后缀
                        String className = packageName + '.' + f.getName().substring(0, f.getName().length() - 6);
                        // 将字节码文件放入全局变量list中，以便后续通过注解筛选
                        allClasses.add(Class.forName(className));
                    }
                }
            }
        }
    }

    // 在allClasses中筛选出使用了@MyComponent注解的类
    private static List<Class<?>> chooseClasses(){
        List<Class<?>> list = new ArrayList<>();
        for (Class<?> clazz : allClasses) {
            if(clazz.getDeclaredAnnotation(MyComponent.class) != null){
                list.add(clazz);
            }
        }
        return list;
    }

}
