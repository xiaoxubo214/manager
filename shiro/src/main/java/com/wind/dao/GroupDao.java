package com.wind.dao;

import com.wind.entity.GroupEntity;

import java.util.List;

public interface GroupDao extends BaseDao<GroupEntity> {

    GroupEntity queryById(String id);

    List<GroupEntity> queryAll();
}
