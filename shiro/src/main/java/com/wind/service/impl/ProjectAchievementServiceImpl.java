package com.wind.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.wind.dao.ProjectAchievementDao;
import com.wind.entity.ProjectAchievementEntity;
import com.wind.service.ProjectAchievementService;



@Service("projectAchievementService")
public class ProjectAchievementServiceImpl implements ProjectAchievementService {
	@Autowired
	private ProjectAchievementDao projectAchievementDao;
	
	@Override
	public ProjectAchievementEntity queryObject(Long id){
		return projectAchievementDao.queryObject(id);
	}
	
	@Override
	public List<ProjectAchievementEntity> queryList(Map<String, Object> map){
		return projectAchievementDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return projectAchievementDao.queryTotal(map);
	}

	@Override
	public void save(ProjectAchievementEntity projectAchievement) {
		projectAchievementDao.save(projectAchievement);
	}

	@Override
	public Long getSaveKey(ProjectAchievementEntity projectAchievement) {
		return projectAchievementDao.getSaveKey(projectAchievement);
	}

	@Override
	public void update(ProjectAchievementEntity projectAchievement){
		projectAchievementDao.update(projectAchievement);
	}
	
	@Override
	public void delete(Long id){
		projectAchievementDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		projectAchievementDao.deleteBatch(ids);
	}
	
}
