package com.lianghaozhang.aaa.bbb.ccc.ddd;

import com.lianghaozhang.my.anno.MyComponent;

@MyComponent
public class TTT {
    private int id;
    private String name;

    public TTT() {
    }

    public TTT(int id, String name) {
        this.id = id;
        this.name = name;
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
}
