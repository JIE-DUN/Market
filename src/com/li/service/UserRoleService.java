package com.li.service;


import java.io.Serializable;

import com.li.entity.shiro.UserRole;

/**
 * 由于这个表只需要增删改查，所以不继承BaseService了
 *
 */
public interface UserRoleService {
	
	/**
	 * 新增实体
	 * 用于赋予新注册用户角色
	 */
	Integer insert(UserRole userRole);
      
    /**  
     * 根据实体主键删除一个实体
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
