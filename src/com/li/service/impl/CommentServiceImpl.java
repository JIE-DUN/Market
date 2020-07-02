package com.li.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.base.BaseDao;
import com.li.base.BaseServiceImpl;
import com.li.dao.CommentDao;
import com.li.entity.Comment;
import com.li.service.CommentService;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {

    @Autowired
    private CommentDao commentDao;

	@Override
	public BaseDao<Comment> getBaseDao() {
		return commentDao;
	}

}
