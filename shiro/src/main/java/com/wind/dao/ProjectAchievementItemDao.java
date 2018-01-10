package com.wind.dao;

import com.wind.entity.ProjectAchievementEntity;
import com.wind.entity.ProjectAchievementItemEntity;

/**
 * 项目绩效子项
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-01-09 20:21:26
 */
public interface ProjectAchievementItemDao extends BaseDao<ProjectAchievementItemEntity> {
	public Integer getSaveKey(ProjectAchievementEntity projectAchievementEntity);
}
