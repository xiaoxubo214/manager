package com.wind.service;

import com.wind.entity.CoupletEntity;
import com.wind.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:22:06
 */
public interface CoupletService {

	CoupletEntity queryObject(Long id);
	
	List<CoupletEntity> queryList(String type);

}
