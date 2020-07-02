package com.li.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.li.entity.Item;
import com.li.entity.Sc;
import com.li.service.ItemService;
import com.li.service.ScService;
import com.li.utils.Consts;
import com.li.utils.Pager;

import javax.servlet.http.HttpServletRequest;

/**
 * 收藏
 */
@Controller
@RequestMapping("/user/sc")
public class ScUserController {

    @Autowired
    private ScService scService;

    @Autowired
    private ItemService itemService;

    @RequestMapping("/exAdd")
    public String exAdd(Sc sc, HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        //保存到收藏表
        Integer userId = Integer.valueOf(attribute.toString());
        sc.setUserId(userId);
        scService.insert(sc);
        //商品表收藏数+1
        Item item = itemService.getById(sc.getItemId());
        item.setScNum(item.getScNum()+1);
        itemService.update(item);
        return "redirect:/user/sc/findAllSc.action";
    }

    /**
     * 收藏列表
     */
    //findBySql
    @RequestMapping("/findAllSc")
    public String findAllSc(Model model,HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        Integer userId = Integer.valueOf(attribute.toString());
        Sc sc = new Sc();
        sc.setUserId(userId);
        Pager<Sc> pagers = scService.findByEntityPaging(sc);
        model.addAttribute("pagers",pagers);
        return "sc/my";
    }

    /**
     * 取消收藏
     */
    @RequestMapping("/delete")
    public String delete(Integer id,HttpServletRequest request){
        scService.deleteById(id);
        return "redirect:/user/sc/findAllSc.action";
    }
}
