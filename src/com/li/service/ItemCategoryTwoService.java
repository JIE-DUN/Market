package com.li.service;

import com.li.base.BaseService;
import com.li.entity.ItemCategoryTwo;

public interface ItemCategoryTwoService extends BaseService<ItemCategoryTwo> {
	
	/**
	 * 查询一级类目下对应二级类目的数量
	 */
	Long getItemCategoryTwoNum(Integer oid);
}
