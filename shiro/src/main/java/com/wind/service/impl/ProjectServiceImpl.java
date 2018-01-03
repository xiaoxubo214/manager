package com.wind.service.impl;

import com.wind.dao.ProjectDao;
import com.wind.entity.ProjectEntity;
import com.wind.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;
    @Override
    public List<ProjectEntity> queryList(Map<String, Object> map) {
        return projectDao.queryList(map);
    }

    @Override
    public void save(ProjectEntity projectEntity) {
        projectDao.save(projectEntity);
    }

    @Override
    public void update(ProjectEntity projectEntity) {
        projectDao.update(projectEntity);
    }

    @Override
    public void deleteBatch(Long[] projectDao){
        //projectDao.
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return projectDao.queryTotal(map);
    }

}
