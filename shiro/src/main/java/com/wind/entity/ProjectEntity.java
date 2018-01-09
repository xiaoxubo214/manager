package com.wind.entity;

import java.io.Serializable;

public class ProjectEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //项目ID
    private Long id;

    //项目名称
    private String projectName;
    //项目负责人ID
    private Long ownerId;

    //负责人名称
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
