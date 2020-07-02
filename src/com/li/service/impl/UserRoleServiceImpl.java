package com.li.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.dao.UserRoleDao;
import com.li.entity.shiro.UserRole;
import com.li.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
    private UserRoleDao userRoleDao;

	/**
	 * 新增实体
	 * 用于赋予新注册用户角色
	 */
	@Override
	public Integer insert(UserRole userRole) {
		return userRoleDao.insert(userRole);
	}

	/**  
     * 根据实体主键删除一个实体
     */  
	@Override
	public void delete(UserRole userRole) {
		this.userRoleDao.delete(userRole);
	}

	/**  
	 * 更新一个实体  
	 */  
	@Override
	public void updateRoleByUserId(UserRole userRole) {
		this.userRoleDao.updateRoleByUserId(userRole);
	}

    /**
     * 查询
     */
	@Override
	public UserRole select(UserRole userRole) {
		return userRoleDao.select(userRole);
	}

}
