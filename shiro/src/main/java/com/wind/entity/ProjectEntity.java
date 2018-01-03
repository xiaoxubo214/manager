package com.wind.entity;

import java.io.Serializable;

public class ProjectEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //项目ID
    private Long id;

    //项目名称
    private String name;
    //项目负责人ID
    private Long userId;
    //负责人名称
    private String ownerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
