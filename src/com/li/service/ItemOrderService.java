package com.li.service;

import java.util.List;

import com.li.base.BaseService;
import com.li.entity.ItemOrder;

public interface ItemOrderService extends BaseService<ItemOrder> {
	
	/**  
     * 查询所有实体,根据实体属性值为判断条件查询
     */ 
	public List<ItemOrder> listAllByEntityDesc(ItemOrder itemOrder);
}
