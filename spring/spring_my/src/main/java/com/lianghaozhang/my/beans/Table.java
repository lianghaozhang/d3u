package com.lianghaozhang.my.beans;

import com.lianghaozhang.anno.MyComponent;

@MyComponent()
public class Table {
    private int id;
    private String name;
    private int age;

    public Table() {
    }

    public Table(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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
