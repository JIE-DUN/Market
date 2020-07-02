package com.li.dao;

import com.li.base.BaseDao;
import com.li.entity.ItemCategoryTwo;

public interface ItemCategoryTwoDao extends BaseDao<ItemCategoryTwo> {

	/**
	 * 查询一级类目下对应二级类目的数量
	 */
	Long getItemCategoryTwoNum(Integer oid);

}
