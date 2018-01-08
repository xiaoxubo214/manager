package com.wind.dao;

import com.wind.entity.ProjectAchievementEntity;
import com.wind.entity.ProjectEntity;

import java.util.List;

public interface ProjectAchievementDao extends BaseDao<ProjectAchievementEntity> {

    ProjectAchievementEntity queryById(String id);

    List<ProjectAchievementEntity> queryAll();
}
