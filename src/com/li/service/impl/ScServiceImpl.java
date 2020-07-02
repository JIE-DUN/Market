package com.li.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.base.BaseDao;
import com.li.base.BaseServiceImpl;
import com.li.dao.ScDao;
import com.li.entity.Sc;
import com.li.service.ScService;

@Service
public class ScServiceImpl extends BaseServiceImpl<Sc> implements ScService {

    @Autowired
    private ScDao scDao;

	@Override
	public BaseDao<Sc> getBaseDao() {
		return scDao;
	}

}
