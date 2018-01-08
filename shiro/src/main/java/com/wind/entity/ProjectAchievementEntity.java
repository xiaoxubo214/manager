package com.wind.entity;

import java.io.Serializable;

public class ProjectAchievementEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //项目ID
    private Long id;

    //项目名称
    private String projectName;
    //项目负责人ID
    private Long userId;

    //负责人名称
    private String name;

    //是否完成 1 finish
    //0 not finish
    private Integer finish;

    private String startTime;
    private String endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
