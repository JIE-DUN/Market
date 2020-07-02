package com.li.dao;

import java.util.List;
import java.util.Set;

import com.li.base.BaseDao;
import com.li.entity.User;

public interface UserDao extends BaseDao<User>{

	/**
	 * 根据User.userName模糊查询，暂时只支持userName
	 */
	List<User> listUserByFuzzy(User entity);

	/**根据id查询用户role*/
	Set<String> findRoleByUserId(User user);

	/**根据id查询该用户Permission*/
	Set<String> findPermissionByUserId(User user);

}
