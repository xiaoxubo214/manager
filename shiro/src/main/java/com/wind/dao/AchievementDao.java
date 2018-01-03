package com.wind.dao;

import com.wind.entity.AchievementEntity;
import com.wind.entity.GroupEntity;

import java.util.List;

public interface AchievementDao extends BaseDao<AchievementEntity> {

    AchievementEntity queryById(String id);

    List<AchievementEntity> queryAll();
}
