package com.wind.service;

import com.wind.entity.AchievementEntity;
import com.wind.entity.ProjectAchievementEntity;

import java.util.List;
import java.util.Map;

public interface AchievementService {

    List<AchievementEntity> queryList(Map<String, Object> map);

    List<AchievementEntity> queryAchievementStandard(ProjectAchievementEntity projectAchievementEntity);

    void save(AchievementEntity achievementEntity);

    void update(AchievementEntity achievementEntity);

    void deleteBatch(Long[] achievementIds);

    int queryTotal(Map<String, Object> map);
}
