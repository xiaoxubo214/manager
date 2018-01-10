package com.wind.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.wind.dao.ProjectAchievementItemDao;
import com.wind.entity.ProjectAchievementItemEntity;
import com.wind.service.ProjectAchievementItemService;



@Service("projectAchievementItemService")
public class ProjectAchievementItemServiceImpl implements ProjectAchievementItemService {
	@Autowired
	private ProjectAchievementItemDao projectAchievementItemDao;
	
	@Override
	public ProjectAchievementItemEntity queryObject(Long itemId){
		return projectAchievementItemDao.queryObject(itemId);
	}
	
	@Override
	public List<ProjectAchievementItemEntity> queryList(Map<String, Object> map){
		return projectAchievementItemDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return projectAchievementItemDao.queryTotal(map);
	}
	
	@Override
	public void save(ProjectAchievementItemEntity projectAchievementItem){
		projectAchievementItemDao.save(projectAchievementItem);
	}
	
	@Override
	public void update(ProjectAchievementItemEntity projectAchievementItem){
		projectAchievementItemDao.update(projectAchievementItem);
	}
	
	@Override
	public void delete(Long itemId){
		projectAchievementItemDao.delete(itemId);
	}
	
	@Override
	public void deleteBatch(Long[] itemIds){
		projectAchievementItemDao.deleteBatch(itemIds);
	}
	
}
