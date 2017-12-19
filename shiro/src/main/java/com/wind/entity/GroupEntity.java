package com.wind.entity;

import java.io.Serializable;

public class GroupEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //用户ID
    private Long groupId;
    //用户名
    private String groupName;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
