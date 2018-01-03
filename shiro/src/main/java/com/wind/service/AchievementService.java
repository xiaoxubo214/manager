package com.wind.service;

import com.wind.entity.AchievementEntity;

import java.util.List;
import java.util.Map;

public interface AchievementService {

    List<AchievementEntity> queryList(Map<String, Object> map);

    void save(AchievementEntity achievementEntity);

    void update(AchievementEntity achievementEntity);

    void deleteBatch(Long[] achievementIds);

    int queryTotal(Map<String, Object> map);
}
