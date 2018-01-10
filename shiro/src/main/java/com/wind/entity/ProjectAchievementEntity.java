package com.wind.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 项目绩效
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-01-10 10:23:51
 */
public class ProjectAchievementEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Long id;
	//project id
	private Long projectId;
	//user id
	private Long userId;
	//user total score
	private Long totalScore;
	//开始时间
	private Date startTime;
	//开始时间
	private Date endTime;
	//状态   0：未完成   1：完成
	private Integer finish;

	private String ownerName;

	private String workName;

	private List<Long> userIdList;

	private String projectName;

	private List<AchievementEntity> achievementEntityList;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：project id
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：project id
	 */
	public Long getProjectId() {
		return projectId;
	}
	/**
	 * 设置：user id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：user id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：user total score
	 */
	public void setTotalScore(Long totalScore) {
		this.totalScore = totalScore;
	}
	/**
	 * 获取：user total score
	 */
	public Long getTotalScore() {
		return totalScore;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：开始时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置：状态   0：未完成   1：完成
	 */
	public void setFinish(Integer finish) {
		this.finish = finish;
	}
	/**
	 * 获取：状态   0：未完成   1：完成
	 */
	public Integer getFinish() {
		return finish;
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

    public List<Long> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Long> userIdList) {
        this.userIdList = userIdList;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<AchievementEntity> getAchievementEntityList() {
        return achievementEntityList;
    }

    public void setAchievementEntityList(List<AchievementEntity> achievementEntityList) {
        this.achievementEntityList = achievementEntityList;
    }
}
