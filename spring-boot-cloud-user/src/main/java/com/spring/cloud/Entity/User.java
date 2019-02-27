package com.spring.cloud.Entity;

public class User {
    private String id;
    private String Name;

    public User(String id, String name) {
        this.id = id;
        Name = name;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
