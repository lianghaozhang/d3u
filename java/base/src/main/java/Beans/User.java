package Beans;

import Annotation.MyComponent;
import lombok.Data;

@Data
@MyComponent("user")
public class User {
    public int id;
    private String name;
    private int age;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
