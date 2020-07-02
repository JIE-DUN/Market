package com.li.controller.manager;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.li.base.BaseController;

/**
 * 登录相关的控制器
 */
@Controller
@RequestMapping("/manager/login")
public class LoginManagerController extends BaseController {

    /**
     * 管理员登陆成功
     */
    @RequestMapping("success")
    public String success(HttpServletRequest request){
        return "/login/mIndex";
    }
}
