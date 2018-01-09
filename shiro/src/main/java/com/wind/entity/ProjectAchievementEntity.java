package com.wind.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProjectAchievementEntity implements Serializable,Cloneable {

    private static final long serialVersionUID = 1L;

    //ID
    private Long id;

    //项目名称
    private String projectName;
    //项目负责人ID
    private Long userId;

    //项目参与人员列表
    private List<Long> userIdList;

    //项目ID
    private Long projectId;

    //打分人名字
    private String ownerName;

    //被打分人名字
    private String workName;

    //是否完成 1 finish
    //0 not finish
    private Integer finish;

    private Date startTime;
    private Date endTime;

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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }


    public List<Long> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Long> userIdList) {
        this.userIdList = userIdList;
    }

}
