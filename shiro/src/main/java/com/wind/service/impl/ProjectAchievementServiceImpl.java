package com.wind.service.impl;

import com.wind.dao.ProjectAchievementDao;
import com.wind.entity.ProjectAchievementEntity;
import com.wind.service.ProjectAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service("workAchievementService")
class ProjectAchievementServiceImpl implements ProjectAchievementService {
	@Autowired
	private ProjectAchievementDao projectAchievementDao;


	@Override
	public List<ProjectAchievementEntity> queryList(Map<String, Object> map) {
		return projectAchievementDao.queryList(map);
	}

	@Override
	public void save(ProjectAchievementEntity projectAchievementEntity) {
		projectAchievementDao.save(projectAchievementEntity);
	}

	@Override
	public void update(ProjectAchievementEntity projectAchievementEntity) {
		projectAchievementDao.update(projectAchievementEntity);
	}

	@Override
	public void deleteBatch(Long[] projectIds) {
		projectAchievementDao.deleteBatch(projectIds);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return projectAchievementDao.queryTotal(map);
	}
}
