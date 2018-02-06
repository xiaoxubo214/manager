package com.wind.dao;

import com.wind.entity.HREntity;
import com.wind.entity.ProjectEntity;

import java.util.List;
import java.util.Map;

public interface HRDao extends BaseDao<HREntity> {
    List<HREntity> queryList(Map<String, Object> map);
}
