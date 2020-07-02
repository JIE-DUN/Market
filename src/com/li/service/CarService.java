package com.li.service;

import java.util.List;

import com.li.base.BaseService;
import com.li.entity.Car;

public interface CarService extends BaseService<Car> {
	
	/**
	 * 根据useid查询对应user购物车，按照购物车的主键id排序(倒序)
	 */
	List<Car> listCarByUserId(Integer userId);
}
