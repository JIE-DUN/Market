package com.li.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.li.base.BaseDao;
import com.li.base.BaseServiceImpl;
import com.li.dao.MessageDao;
import com.li.entity.Message;
import com.li.service.MessageService;

@Service
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService {

    @Autowired
    private MessageDao messageDao;

	@Override
	public BaseDao<Message> getBaseDao() {
		return messageDao;
	}

}
