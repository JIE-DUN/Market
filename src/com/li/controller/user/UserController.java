package com.li.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.li.base.BaseController;
import com.li.entity.User;
import com.li.service.UserService;
import com.li.utils.Consts;

/**
 * 用户c层
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 查看用户信息
     */
    @RequestMapping("/view")
    public String view(Model model, HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        Integer userId = Integer.valueOf(attribute.toString());
        User obj = userService.getById(userId);
        model.addAttribute("obj",obj);
        return "user/view";
    }

    /**
     * 执行修改用户信息的操作
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(User user,HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        user.setId(Integer.valueOf(attribute.toString()));
        userService.update(user);
        return "redirect:/user/view.action";
    }
}
