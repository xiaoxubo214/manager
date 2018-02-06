package com.wind.service;

import com.wind.entity.HREntity;
import com.wind.entity.ProjectEntity;

import java.util.List;
import java.util.Map;

public interface HRService {

    List<HREntity> queryList(Map<String, Object> map);

    void save(HREntity hrEntity);

    void update(HREntity hrEntity);

    void deleteBatch(Long[] projectIds);

    int queryTotal(Map<String, Object> map);
}
