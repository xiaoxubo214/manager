package com.wind.service;

import com.wind.entity.ProjectAchievementEntity;

import java.util.List;
import java.util.Map;

/**
 * 项目绩效
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-01-10 10:00:55
 */
public interface ProjectAchievementService {
	
	ProjectAchievementEntity queryObject(Long id);
	
	List<ProjectAchievementEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ProjectAchievementEntity projectAchievement);

	Long getSaveKey(ProjectAchievementEntity projectAchievement);
	
	void update(ProjectAchievementEntity projectAchievement);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
