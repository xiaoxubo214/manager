package com.wind.service;

import com.wind.entity.GroupEntity;

import java.util.List;
import java.util.Map;

public interface GroupService {

    List<GroupEntity> queryList(Map<String, Object> map);

    void save(GroupEntity groupEntity);

    void update(GroupEntity groupEntity);

    void deleteBatch(Long[] groupIds);

    int queryTotal(Map<String, Object> map);
}
