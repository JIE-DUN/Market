package com.li.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.li.base.BaseDao;
import com.li.base.BaseServiceImpl;
import com.li.dao.UserDao;
import com.li.entity.User;
import com.li.service.UserService;
import com.li.utils.Pager;
import com.li.utils.SystemContext;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserDao userDao;

	@Override
	public BaseDao<User> getBaseDao() {
		return userDao;
	}

	/**
	 * 根据User.userName模糊查询，暂时只支持userName
	 */
	@Override
	public Pager<User> listUserByFuzzy(User user) {
		/**
		 * 执行分页
		 */
    	Integer pageSize = SystemContext.getPageSize();
		Integer pageOffset = SystemContext.getPageOffset();
		if(pageOffset==null||pageOffset<0) pageOffset = 0;
		if(pageSize==null||pageSize<0) pageSize = 15;
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		Integer pageNum = null;
		if(pageOffset == 0){
			pageNum = 1;
		}else{
			pageNum = pageOffset/pageSize+1;
		}
		PageHelper.startPage(pageNum, pageSize);
		Pager<User> pages = new Pager<User>(userDao.listUserByFuzzy(user));
    	return pages;
	}

	/**根据id查询用户role*/
	@Override
	public Set<String> findRoleByUserId(User user) {
		return userDao.findRoleByUserId(user);
	}

	/**根据id查询该用户Permission*/
	@Override
	public Set<String> findPermissionByUserId(User user) {
		return userDao.findPermissionByUserId(user);
	}

}
