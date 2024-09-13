package com.lianghaozhang.beans;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private int age;

    public Student() {
//        System.out.println("调用了无参构造");
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
//        System.out.println("调用了有参构造");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
