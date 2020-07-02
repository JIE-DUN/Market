package com.li.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.li.entity.OrderDetail;
import com.li.service.OrderDetailService;
import com.li.utils.Pager;

/**
 * 订单详情c层
 */
@Controller
@RequestMapping("/manager/orderDetail")
public class OrderDetailManagerController {

    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping("/ulist")
    public String ulist(OrderDetail orderDetail, Model model){
        //分页查询
        OrderDetail od = new OrderDetail();
        od.setOrderId(orderDetail.getOrderId());
        Pager<OrderDetail> pagers = orderDetailService.findByEntityPaging(od);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",orderDetail);
        return "orderDetail/ulist";
    }
}
