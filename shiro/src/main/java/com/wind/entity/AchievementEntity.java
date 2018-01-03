package com.wind.entity;

import java.io.Serializable;

public class AchievementEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //绩效项ID
    private Long id;

    //绩效内容
    private String name;

    //分数
    private Integer score;
    //组ID
    private Long groupId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
