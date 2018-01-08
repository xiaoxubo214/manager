package com.wind.service;

import com.wind.entity.ProjectEntity;

import java.util.List;
import java.util.Map;

public interface ProjectAchievementService {

    List<ProjectEntity> queryList(Map<String, Object> map);

    void save(ProjectEntity projectEntity);

    void update(ProjectEntity projectEntity);

    void deleteBatch(Long[] projectIds);

    int queryTotal(Map<String, Object> map);
}
