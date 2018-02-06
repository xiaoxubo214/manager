package com.wind.service.impl;

import com.wind.DataSourceContextHolder;
import com.wind.dao.HRDao;
import com.wind.dao.ProjectDao;
import com.wind.data.DataSource;
import com.wind.entity.HREntity;
import com.wind.entity.ProjectEntity;
import com.wind.service.HRService;
import com.wind.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("hrService")
public class HRServiceImpl implements HRService {

    @Autowired
    private HRDao hrDao;

    @DataSource(DataSourceContextHolder.DATA_SOURCE_B)
    @Override
    public List<HREntity> queryList(Map<String, Object> map) {
        return hrDao.queryList(map);
    }

    @Override
    public void save(HREntity hrEntity) {

    }

    @Override
    public void update(HREntity hrEntity) {

    }

    @Override
    public void deleteBatch(Long[] projectIds) {

    }
    @DataSource(DataSourceContextHolder.DATA_SOURCE_B)
    @Override
    public int queryTotal(Map<String, Object> map) {
        return hrDao.queryTotal();
    }
}
