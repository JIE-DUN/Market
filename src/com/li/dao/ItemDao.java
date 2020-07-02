package com.li.dao;

import java.util.List;

import com.li.base.BaseDao;
import com.li.entity.Item;

public interface ItemDao extends BaseDao<Item> {

	/**
	 * 热销产品，销量最高前10名
	 */
	List<Item> hotProducts();

	/**
	 * 打折商品，打折力度前十
	 */
	List<Item> onSale();

	/**
	 * 商品的模糊查询，支持价格或购买数量排序，如果都没有则按照id排序
	 */
	List<Item> listItemByFuzzyDesc(Item item);

	/**查询二级类目下对应商品的数量*/
	Long getItemNum(Integer categoryIdTwo);

}
