package com.li.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.base.BaseDao;
import com.li.base.BaseServiceImpl;
import com.li.dao.CarDao;
import com.li.entity.Car;
import com.li.service.CarService;

@Service
public class CarServiceImpl extends BaseServiceImpl<Car> implements CarService {

    @Autowired
    private CarDao carDao;

	@Override
	public BaseDao<Car> getBaseDao() {
		return carDao;
	}

	/**
	 * 根据useid查询对应user购物车，按照购物车的主键id排序(倒序)
	 */
	@Override
	public List<Car> listCarByUserId(Integer userId) {
		return carDao.listCarByUserId(userId);
	}

}
