package com.li.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.base.BaseDao;
import com.li.base.BaseServiceImpl;
import com.li.dao.ItemCategoryOneDao;
import com.li.entity.ItemCategoryOne;
import com.li.service.ItemCategoryOneService;

@Service
public class ItemCategoryOneServiceImpl extends BaseServiceImpl<ItemCategoryOne> implements ItemCategoryOneService {
	
    @Autowired
    private ItemCategoryOneDao itemCategoryOneDao;

	@Override
	public BaseDao<ItemCategoryOne> getBaseDao() {
		return itemCategoryOneDao;
	}

}
