package com.wind.service.impl;

import com.wind.dao.GroupDao;
import com.wind.entity.GroupEntity;
import com.wind.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("groupService")
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;
    @Override
    public List<GroupEntity> queryList(Map<String, Object> map) {
        return groupDao.queryList(map);
    }

    @Override
    public void save(GroupEntity groupEntity) {

       groupDao.save(groupEntity);
    }

    @Override
    public void update(GroupEntity groupEntity) {
        groupDao.update(groupEntity);
    }

    @Override
    public void deleteBatch(Long[] groupIds){
        groupDao.deleteBatch(groupIds);
    }
    @Override
    public int queryTotal(Map<String, Object> map) {
        return groupDao.queryTotal(map);
    }

}
