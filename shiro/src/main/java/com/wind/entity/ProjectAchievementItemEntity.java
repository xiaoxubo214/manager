package com.wind.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 项目绩效子项
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-01-09 20:21:26
 */
public class ProjectAchievementItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long itemId;
	//绩效项ID
	private Long achievementId;
	//owner id
	private Long planScore;
	//owner id
	private Long getScore;

	/**
	 * 设置：
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	/**
	 * 获取：
	 */
	public Long getItemId() {
		return itemId;
	}
	/**
	 * 设置：绩效项ID
	 */
	public void setAchievementId(Long achievementId) {
		this.achievementId = achievementId;
	}
	/**
	 * 获取：绩效项ID
	 */
	public Long getAchievementId() {
		return achievementId;
	}
	/**
	 * 设置：owner id
	 */
	public void setPlanScore(Long planScore) {
		this.planScore = planScore;
	}
	/**
	 * 获取：owner id
	 */
	public Long getPlanScore() {
		return planScore;
	}
	/**
	 * 设置：owner id
	 */
	public void setGetScore(Long getScore) {
		this.getScore = getScore;
	}
	/**
	 * 获取：owner id
	 */
	public Long getGetScore() {
		return getScore;
	}
}
