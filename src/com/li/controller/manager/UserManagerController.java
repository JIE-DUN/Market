package com.li.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.li.base.BaseController;
import com.li.entity.User;
import com.li.service.UserService;
import com.li.utils.Pager;

/**
 * 用户c层
 */
@Controller
@RequestMapping("/manager/user")
public class UserManagerController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUser")
    public String findAllUser(Model model,User user){
        Pager<User> pagers = userService.listUserByFuzzy(user);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",user);
        return "user/user";
    }
}
