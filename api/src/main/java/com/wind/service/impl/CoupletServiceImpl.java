package com.wind.service.impl;

import com.wind.dao.CoupletDao;
import com.wind.dao.UserDao;
import com.wind.entity.CoupletEntity;
import com.wind.entity.UserEntity;
import com.wind.service.CoupletService;
import com.wind.service.UserService;
import com.wind.utils.RRException;
import com.wind.validator.Assert;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("coupletService")
public class CoupletServiceImpl implements CoupletService {
	@Autowired
	private CoupletDao coupletDao;


	@Override
	public CoupletEntity queryObject(Long id) {
		return coupletDao.queryObject(id);
	}

	@Override
	public List<CoupletEntity> queryList(String type) {
		return coupletDao.queryList(type);
	}
}
