package com.wind.entity;

import java.io.Serializable;

public class GroupEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //用户ID
    private Long groupId;
    //用户名
    private String name;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return name;
    }

    public void setGroupName(String name) {
        this.name = name;
    }
}
