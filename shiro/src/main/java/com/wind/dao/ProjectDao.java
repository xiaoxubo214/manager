package com.wind.dao;

import com.wind.entity.ProjectEntity;

import java.util.List;

public interface ProjectDao extends BaseDao<ProjectEntity> {

    ProjectEntity queryById(String id);

    List<ProjectEntity> queryAll();
}
