package com.wind.dao;

import com.wind.entity.ProjectAchievementEntity;

/**
 * 项目绩效
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-01-10 10:00:55
 */
public interface ProjectAchievementDao extends BaseDao<ProjectAchievementEntity> {
    public Long getSaveKey(ProjectAchievementEntity projectAchievementEntity);
	
}
