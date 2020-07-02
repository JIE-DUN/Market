package com.li.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.li.base.BaseController;
import com.li.entity.ItemOrder;
import com.li.service.ItemOrderService;
import com.li.utils.Pager;

/**
 * 订单管理
 */
@Controller
@RequestMapping("/manager/itemOrder")
public class ItemOrderManagerController extends BaseController {
    @Autowired
    private ItemOrderService itemOrderService;

    /**
     * 订单管理列表
     */
    //findBySql
    @RequestMapping("/findAllItemOrder")
    public String findAllItemOrder(ItemOrder itemOrder, Model model){
        //分页查询
        ItemOrder io = new ItemOrder();
        io.setCode(itemOrder.getCode());
        Pager<ItemOrder> pagers = itemOrderService.findByEntityPaging(itemOrder);
        model.addAttribute("pagers",pagers);
        //存储查询条件
        model.addAttribute("obj",itemOrder);
        return "itemOrder/itemOrder";
    }

    /**
     * 后台发货
     */
    @RequestMapping("/fh")
    public String fh(Integer id,Model model){
        ItemOrder obj =itemOrderService.getById(id);
        obj.setStatus(2);
        itemOrderService.update(obj);
        model.addAttribute("obj",obj);
        return "redirect:/manager/itemOrder/findAllItemOrder";
    }

}



