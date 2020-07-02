package com.li.controller.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.li.base.BaseController;
import com.li.entity.Comment;
import com.li.service.CommentService;
import com.li.utils.Consts;

/**
 * 评论
 */
@Controller
@RequestMapping("/user/comment")
public class CommentUserController extends BaseController {

    @Autowired
    private CommentService commentService;

    /**
     * 添加执行
     */
    @RequestMapping("/exAdd")
    public String exAdd(Comment comment, HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        Integer userId = Integer.valueOf(attribute.toString());
        comment.setAddTime(new Date());
        comment.setUserId(userId);
        commentService.insert(comment);
        return "redirect:/user/itemOrder/my.action";
    }

}
