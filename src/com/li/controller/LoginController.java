package com.li.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.li.base.BaseController;
import com.li.entity.CategoryDto;
import com.li.entity.Item;
import com.li.entity.ItemCategoryOne;
import com.li.entity.ItemCategoryTwo;
import com.li.entity.Manage;
import com.li.entity.User;
import com.li.entity.shiro.UserRole;
import com.li.service.ItemCategoryOneService;
import com.li.service.ItemCategoryTwoService;
import com.li.service.ItemService;
import com.li.service.UserRoleService;
import com.li.service.UserService;
import com.li.utils.Consts;
import com.li.utils.CryptographyUtil;

/**
 * 登录相关的控制器
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private ItemCategoryOneService itemCategoryOneService;
    
    @Autowired
    private ItemCategoryTwoService itemCategoryTwoService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRoleService userRoleService;
    
    /**
     * 管理员登录前
     * @return
     */
    @RequestMapping("login")
    public String login(){
        return "/login/mLogin";
    }

    /**
     * 管理员登录验证
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(Manage manage, HttpServletRequest request){
        /**用户名*/
		String userName = manage.getUserName();
		/**密码*/
		String password = manage.getPassWord();
		/**加密后的密码*/
		String pw = CryptographyUtil.md5Manager(password, userName);
		//Subject,shiro权限验证
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName, pw);
		try {
			//传递token给shiro的realm
			//这里涉及到自定义的Myrealm --> com.blog.realm.MyRealm.java
			subject.login(token);
			 return "redirect:/manager/login/success";
		} catch (Exception e) {
			//如果登录失败，则在后台反应信息
			e.printStackTrace();
			//这个作用是：如果用户名或密码错了，就把用户名和密码传回前端的jsp页面
			//用户可以直接修改，不用每次都重新填写
			request.setAttribute("manage", manage);
		}
       return "/login/mLogin";
    }

    /**
     * 管理员退出
     */
    @RequestMapping("mtuichu")
    public String mtuichu(HttpServletRequest request){
    	SecurityUtils.getSubject().logout();
        return "/login/mLogin";
    }

    /**
     * 前端首页
     */
    @RequestMapping("/uIndex")
    public String uIndex(Model model, Item item,HttpServletRequest request){
        List<ItemCategoryOne> fatherList = itemCategoryOneService.listAll();
        List<CategoryDto> list = new ArrayList<>();
        if(!CollectionUtils.isEmpty(fatherList)){
            for(ItemCategoryOne ic:fatherList){
                CategoryDto dto = new CategoryDto();
                dto.setFather(ic);
                //查询二级类目
                ItemCategoryTwo itemCategoryTwo = new ItemCategoryTwo();
                itemCategoryTwo.setOid(ic.getId());
                List<ItemCategoryTwo> childrens = itemCategoryTwoService.listAllByEntity(itemCategoryTwo);
                dto.setChildrens(childrens);
                list.add(dto);
                model.addAttribute("lbs",list);
            }
        }
        //折扣商品,打折力度前十
        List<Item> zks = itemService.onSale();
        model.addAttribute("zks",zks);

        //热销商品，前十
        List<Item> rxs = itemService.hotProducts();
        model.addAttribute("rxs",rxs);

        return "login/uIndex";
    }

    /**普通用户注册*/
    @RequestMapping("/res")
    public String res(){
        return "login/res";
    }

    /**
     * 执行普通用户注册
     * userRole.setRoleId(2) : 2是普通用户
     * 
     * js.put(Consts.RES, 0);
     * 	0 : 用户名已被注册
     *  1 : 邮箱已被注册
     * 	2 : 注册成功
     */
    @RequestMapping("/toRes")
    @ResponseBody
    public String toRes(User u){
    	JSONObject js = new JSONObject();
    	
    	String username = u.getUserName();
    	String email = u.getEmail();
    	String password = u.getPassWord();
    	String passWordMd5 = CryptographyUtil.md5User(password, username);
    	//查询这个用户名是否存在
    	User userOldName = new User();
    	userOldName.setUserName(username);
    	if(userService.getByEntity(userOldName) != null){
    		js.put(Consts.RES, 0);
    		return js.toString();
    	}
    	//查询这个邮箱是否已被使用
    	User userOldEmail = new User();
    	userOldEmail.setEmail(email);
    	if(userService.getByEntity(userOldEmail) != null){
    		js.put(Consts.RES, 1);
    		return js.toString();
    	}
    	
    	//注册
    	u.setPassWord(passWordMd5);
    	userService.insert(u);
    	
    	//赋予角色
    	UserRole userRole = new UserRole();
    	userRole.setUserId(u.getId());
    	userRole.setRoleId(2);
    	userRoleService.insert(userRole);
    	js.put(Consts.RES, 2);
        return js.toString();
    }
    

    /**普通用户登录入口*/
    @RequestMapping("/uLogin")
    public String uLogin(){
        return "login/uLogin";
    }

    /**执行普通用户登录*/
    @RequestMapping("/utoLogin")
    public String utoLogin(User user,HttpServletRequest request){
    	/**用户名*/
		String userName = user.getUserName();
		/**密码*/
		String password = user.getPassWord();
		/**加密后的密码*/
		String pw = CryptographyUtil.md5User(password, userName);
		//Subject,shiro权限验证
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userName, pw);
		try {
			//传递token给shiro的realm
			//这里涉及到自定义的Myrealm --> com.blog.realm.MyRealm.java
			subject.login(token);
			return "redirect:/login/uIndex.action";
		} catch (Exception e) {
			//如果登录失败，则在后台反应信息
			e.printStackTrace();
			//这个作用是：如果用户名或密码错了，就把用户名和密码传回前端的jsp页面
			//用户可以直接修改，不用每次都重新填写
			request.setAttribute("user", user);
		}
		return "login/uLogin";
    }

    /**前端用户退出*/
    @RequestMapping("/uTui")
    public String uTui(HttpServletRequest request){
    	SecurityUtils.getSubject().logout();
        return "redirect:/login/uIndex.action";
    }

}
