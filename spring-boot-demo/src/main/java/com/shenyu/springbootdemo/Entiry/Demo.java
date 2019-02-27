package com.shenyu.springbootdemo.Entiry;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Demo implements Serializable {

    @Id // 指定主键
    @GeneratedValue(strategy = GenerationType.AUTO) //自动增长
    private int id;
    @Column
    private String name;

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
