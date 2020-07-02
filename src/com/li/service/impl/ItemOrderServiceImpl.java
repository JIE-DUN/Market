package com.li.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.base.BaseDao;
import com.li.base.BaseServiceImpl;
import com.li.dao.ItemOrderDao;
import com.li.entity.ItemOrder;
import com.li.service.ItemOrderService;

@Service
public class ItemOrderServiceImpl extends BaseServiceImpl<ItemOrder> implements ItemOrderService {

    @Autowired
    private ItemOrderDao itemOrderDao;

	@Override
	public BaseDao<ItemOrder> getBaseDao() {
		return itemOrderDao;
	}

	/**  
     * 查询所有实体,根据实体属性值为判断条件查询所有实体
     */ 
	@Override
	public List<ItemOrder> listAllByEntityDesc(ItemOrder itemOrder) {
		return itemOrderDao.listAllByEntityDesc(itemOrder);
	}

}
