package com.li.dao;

import java.io.Serializable;

import com.li.entity.shiro.UserRole;

public interface UserRoleDao {

	/**
	 * 新增实体
	 * 用于赋予新注册用户角色
	 */
	Integer insert(UserRole userRole);

	/**  
     * 根据实体删除一个实体
     */ 
	void delete(UserRole userRole);

	/**  
	 * 更新一个实体  
	 */  
	void updateRoleByUserId(UserRole userRole);

    /**
     * 查询
     */
	UserRole select(UserRole userRole);

}
