package com.li.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.li.base.BaseController;
import com.li.entity.Item;
import com.li.service.ItemService;
import com.li.utils.Pager;

@Controller
@RequestMapping("/item")
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;

    /**
     * 按关键字或者二级分类查询
     */
    @RequestMapping("/shoplist")
    public String shoplist(Item item,@RequestParam(value="condition",required=false)String condition,Model model){
    	Item i = new Item();
    	i.setCategoryIdTwo(item.getCategoryIdTwo());
    	i.setPrice(item.getPrice());
    	i.setGmNum(item.getGmNum());
		i.setName(condition);
        Pager<Item> pagers = itemService.listItemByFuzzyDesc(i);
        model.addAttribute("condition",condition);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",item);
        return "item/shoplist";
    }

    @RequestMapping("/view")
    public String view(Integer id,Model model){
        Item obj = itemService.getById(id);
        model.addAttribute("obj",obj);
        return "item/view";
    }
}
