package com.wind.dao;

import com.wind.entity.AchievementEntity;
import com.wind.entity.GroupEntity;
import com.wind.entity.ProjectAchievementEntity;

import java.util.List;

public interface AchievementDao extends BaseDao<AchievementEntity> {

    AchievementEntity queryById(String id);

    List<AchievementEntity> queryAll();

    List<AchievementEntity> queryAchievementStandard(ProjectAchievementEntity projectAchievementEntity);
}
