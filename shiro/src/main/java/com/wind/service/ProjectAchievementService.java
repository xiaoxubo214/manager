package com.wind.service;

import com.wind.entity.ProjectAchievementEntity;
import com.wind.entity.ProjectEntity;

import java.util.List;
import java.util.Map;

public interface ProjectAchievementService {

    List<ProjectAchievementEntity> queryList(Map<String, Object> map);

    void save(ProjectAchievementEntity projectAchievementEntity);

    void update(ProjectAchievementEntity projectAchievementEntity);

    void deleteBatch(Long[] projectIds);

    int queryTotal(Map<String, Object> map);
}
