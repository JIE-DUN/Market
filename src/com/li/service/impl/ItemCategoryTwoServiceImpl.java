package com.li.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.base.BaseDao;
import com.li.base.BaseServiceImpl;
import com.li.dao.ItemCategoryTwoDao;
import com.li.entity.ItemCategoryTwo;
import com.li.service.ItemCategoryTwoService;

@Service
public class ItemCategoryTwoServiceImpl extends BaseServiceImpl<ItemCategoryTwo> implements ItemCategoryTwoService {
	
    @Autowired
    private ItemCategoryTwoDao itemCategoryTwoDao;

	@Override
	public BaseDao<ItemCategoryTwo> getBaseDao() {
		return itemCategoryTwoDao;
	}

	/**
	 * 查询一级类目下对应二级类目的数量
	 */
	@Override
	public Long getItemCategoryTwoNum(Integer oid) {
		return itemCategoryTwoDao.getItemCategoryTwoNum(oid);
	}

}
