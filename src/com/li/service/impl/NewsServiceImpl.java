package com.li.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.base.BaseDao;
import com.li.base.BaseServiceImpl;
import com.li.dao.NewsDao;
import com.li.entity.News;
import com.li.service.NewsService;

@Service
public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService {

    @Autowired
    private NewsDao newsDao;

	@Override
	public BaseDao<News> getBaseDao() {
		return newsDao;
	}
}
