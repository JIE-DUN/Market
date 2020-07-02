package com.li.dao;

import java.util.List;

import com.li.base.BaseDao;
import com.li.entity.ItemOrder;

public interface ItemOrderDao extends BaseDao<ItemOrder> {

	/**  
     * 查询所有实体,根据实体属性值为判断条件查询所有实体
     */ 
	List<ItemOrder> listAllByEntityDesc(ItemOrder itemOrder);

}
