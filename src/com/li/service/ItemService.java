package com.li.service;

import java.util.List;

import com.li.base.BaseService;
import com.li.entity.Item;
import com.li.utils.Pager;

public interface ItemService extends BaseService<Item> {
	
	/**
	 * 热销产品，销量最高前10名
	 */
	public List<Item> hotProducts();
	
	/**
	 * 打折商品，打折力度前十
	 */
	public List<Item> onSale();
	
	/**
	 * 商品的模糊查询，支持价格或购买数量排序，如果都没有则按照id排序
	 */
	public Pager<Item> listItemByFuzzyDesc(Item item);
	
	/**查询二级类目下对应商品的数量*/
	public Long getItemNum(Integer categoryIdTwo);
	

}
