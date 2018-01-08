package com.wind.entity;

import java.io.Serializable;

public class GroupEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //组ID
    private Long id;

    //用户名
    private String groupName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
