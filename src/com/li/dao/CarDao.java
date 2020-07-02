package com.li.dao;

import java.util.List;

import com.li.base.BaseDao;
import com.li.entity.Car;

public interface CarDao extends BaseDao<Car>{

	/**
	 * 根据useid查询对应user购物车，按照购物车的主键id排序(倒序)
	 */
	List<Car> listCarByUserId(Integer userId);

}
