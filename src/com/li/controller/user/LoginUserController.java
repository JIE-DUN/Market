package com.li.controller.user;


import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.li.base.BaseController;
import com.li.entity.User;
import com.li.service.UserService;
import com.li.utils.Consts;
import com.li.utils.CryptographyUtil;

/**
 * 登录相关的控制器
 */
@Controller
@RequestMapping("/user/login")
public class LoginUserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 修改密码入口
     */
    @RequestMapping("/pass")
    public String pass(HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        Integer userId = Integer.valueOf(attribute.toString());
        User load = userService.getById(userId);
        request.setAttribute("obj",load);
        return "login/pass";
    }

    /**
     * 修改密码操作
     * 0 未登录
     * 1 修改成功
     * 2 旧密码和现密码不一致
     * 3 新密码和先密码一样
     * password : 旧密码
     * passwordnew ：新密码
     */
    @RequestMapping("/upass")
    @ResponseBody
    public String upass(String password,String passwordnew,HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        JSONObject js = new JSONObject();
        if(attribute==null){
            js.put(Consts.RES,0);
            return js.toString();
        }
        Integer userId = Integer.valueOf(attribute.toString());
        User load = userService.getById(userId);
        
        //旧密码和现密码作比较
        String o = load.getPassWord();
        String n = CryptographyUtil.md5User(password, load.getUserName());
        if(!o.equals(n)){
        	js.put(Consts.RES,2);
            return js.toString();
        }
        
        //新密码和现密码作比较
        n = CryptographyUtil.md5User(passwordnew, load.getUserName());
        if(o.equals(n)){
        	js.put(Consts.RES,3);
            return js.toString();
        }
        String pw = CryptographyUtil.md5User(passwordnew, load.getUserName());
        load.setPassWord(pw);
        userService.update(load);
        SecurityUtils.getSubject().logout();
        js.put(Consts.RES,1);
        return js.toString();
    }


}
