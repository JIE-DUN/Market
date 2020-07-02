package com.li.service;

import java.util.Set;

import com.li.base.BaseService;
import com.li.entity.User;
import com.li.utils.Pager;

public interface UserService extends BaseService<User> {
	
	/**
	 * 根据User.userName模糊查询，暂时只支持userName
	 */
	public Pager<User> listUserByFuzzy(User user);
	
	/**根据id查询用户role*/
	public Set<String> findRoleByUserId(User user);

	/**根据id查询该用户Permission*/
	public Set<String> findPermissionByUserId(User user);
}
