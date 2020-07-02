package com.li.service;

import java.util.Set;

import com.li.base.BaseService;
import com.li.entity.Manage;

public interface ManageService extends BaseService<Manage> {
	
	/**根据id查询该管理员role*/
	public Set<String> findRoleByManageId(Manage manage);
	
	/**根据id查询该管理员permission*/
	public Set<String> findPermissionByManageId(Manage manage);
}
