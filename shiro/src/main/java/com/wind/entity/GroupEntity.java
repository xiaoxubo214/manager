package com.wind.entity;

import java.io.Serializable;

public class GroupEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //组ID
    private Long id;
    //用户名
    private String Name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
