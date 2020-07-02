package com.li.dao;

import java.util.Set;

import com.li.base.BaseDao;
import com.li.entity.Manage;

public interface ManageDao extends BaseDao<Manage> {

	/**根据id查询该管理员role*/
	Set<String> findRoleByManageId(Manage manage);

	/**根据id查询该管理员Permission*/
	Set<String> findPermissionByManageId(Manage manage);


}
