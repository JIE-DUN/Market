package com.li.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.li.base.BaseController;
import com.li.entity.Message;
import com.li.service.MessageService;
import com.li.utils.Pager;

/**
 * 留言管理
 */
@Controller
@RequestMapping("/manager/message")
public class MessageManagerController extends BaseController {

    @Autowired
    private MessageService messageService;

    /**
     * 留言列表
     */
    @RequestMapping("/findAllMessage")
    public String findAllMessage(Message message, Model model){
        Message m = new Message();
        m.setName(message.getName());
        Pager<Message> pagers = messageService.findByEntityPaging(m);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",message);
        return "message/message";
    }

    /**
     * 删除留言
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        messageService.deleteById(id);
        return "redirect:/manager/message/findAllMessage";
    }
}
