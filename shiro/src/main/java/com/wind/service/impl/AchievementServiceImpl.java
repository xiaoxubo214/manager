package com.wind.service.impl;

import com.wind.dao.AchievementDao;
import com.wind.entity.AchievementEntity;
import com.wind.entity.ProjectAchievementEntity;
import com.wind.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("achievementService")
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementDao achievementDao;
    @Override
    public List<AchievementEntity> queryList(Map<String, Object> map) {
        return achievementDao.queryList(map);
    }

    @Override
    public List<AchievementEntity> queryAchievementStandard(ProjectAchievementEntity projectAchievementEntity) {
        return achievementDao.queryAchievementStandard(projectAchievementEntity);
    }

    @Override
    public void save(AchievementEntity achievementEntity) {

        achievementDao.save(achievementEntity);
    }

    @Override
    public void update(AchievementEntity achievementEntity) {
        achievementDao.update(achievementEntity);
    }

    @Override
    public void deleteBatch(Long[] achievementIds){
        achievementDao.deleteBatch(achievementIds);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return achievementDao.queryTotal(map);
    }


}
