package com.li.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.base.BaseDao;
import com.li.base.BaseServiceImpl;
import com.li.dao.ManageDao;
import com.li.entity.Manage;
import com.li.service.ManageService;

@Service
public class ManageServiceImpl extends BaseServiceImpl<Manage> implements ManageService {
	
    @Autowired
    private ManageDao manageDao;

	@Override
	public BaseDao<Manage> getBaseDao() {
		return manageDao;
	}

	/**根据id查询该管理员role*/
	public Set<String> findRoleByManageId(Manage manage) {
		return manageDao.findRoleByManageId(manage);
	}

	@Override
	public Set<String> findPermissionByManageId(Manage manage) {
		return manageDao.findPermissionByManageId(manage);
	}

	

}
