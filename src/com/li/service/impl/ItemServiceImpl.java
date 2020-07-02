package com.li.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.li.base.BaseDao;
import com.li.base.BaseServiceImpl;
import com.li.dao.ItemDao;
import com.li.entity.Item;
import com.li.service.ItemService;
import com.li.utils.Pager;
import com.li.utils.SystemContext;

@Service
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {

    @Autowired
    private ItemDao itemDao;

	@Override
	public BaseDao<Item> getBaseDao() {
		return itemDao;
	}

	/**
	 * 热销产品，销量最高前10名
	 */
	@Override
	public List<Item> hotProducts() {
		return itemDao.hotProducts();
	}

	/**
	 * 打折商品，打折力度前十
	 */
	@Override
	public List<Item> onSale() {
		return itemDao.onSale();
	}

	/**
	 * 商品的模糊查询，支持价格或购买数量排序，如果都没有则按照id排序
	 */
	@Override
	public Pager<Item> listItemByFuzzyDesc(Item item) {
		/**
		 * 执行分页
		 */
    	Integer pageSize = SystemContext.getPageSize();
		Integer pageOffset = SystemContext.getPageOffset();
		if(pageOffset==null||pageOffset<0) pageOffset = 0;
		if(pageSize==null||pageSize<0) pageSize = 15;
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		Integer pageNum = null;
		if(pageOffset == 0){
			pageNum = 1;
		}else{
			pageNum = pageOffset/pageSize+1;
		}
		PageHelper.startPage(pageNum, pageSize);
		Pager<Item> pages = new Pager<Item>(itemDao.listItemByFuzzyDesc(item));
    	return pages;
	}

	/**查询二级类目下对应商品的数量*/
	@Override
	public Long getItemNum(Integer categoryIdTwo) {
		return itemDao.getItemNum(categoryIdTwo);
	}
}
