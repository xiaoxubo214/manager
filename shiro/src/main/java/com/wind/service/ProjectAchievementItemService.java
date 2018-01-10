package com.wind.service;

import com.wind.entity.ProjectAchievementItemEntity;

import java.util.List;
import java.util.Map;

/**
 * 项目绩效子项
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-01-09 20:21:26
 */
public interface ProjectAchievementItemService {
	
	ProjectAchievementItemEntity queryObject(Long itemId);
	
	List<ProjectAchievementItemEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ProjectAchievementItemEntity projectAchievementItem);
	
	void update(ProjectAchievementItemEntity projectAchievementItem);
	
	void delete(Long itemId);
	
	void deleteBatch(Long[] itemIds);
}
