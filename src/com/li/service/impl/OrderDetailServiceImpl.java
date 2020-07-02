package com.li.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.base.BaseDao;
import com.li.base.BaseServiceImpl;
import com.li.dao.OrderDetailDao;
import com.li.entity.OrderDetail;
import com.li.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail> implements OrderDetailService {
    @Autowired
    private OrderDetailDao orderDetailDao;

	@Override
	public BaseDao<OrderDetail> getBaseDao() {
		return orderDetailDao;
	}

}
