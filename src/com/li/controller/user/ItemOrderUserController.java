package com.li.controller.user;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.li.base.BaseController;
import com.li.entity.Car;
import com.li.entity.CarDto;
import com.li.entity.Item;
import com.li.entity.ItemOrder;
import com.li.entity.OrderDetail;
import com.li.entity.User;
import com.li.service.CarService;
import com.li.service.ItemOrderService;
import com.li.service.ItemService;
import com.li.service.OrderDetailService;
import com.li.service.UserService;
import com.li.utils.Consts;

/**
 * 订单管理
 */
@Controller
@RequestMapping("/user/itemOrder")
public class ItemOrderUserController extends BaseController {
    @Autowired
    private ItemOrderService itemOrderService;
    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;
    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private ItemService itemService;

    /**
     * 我的订单
     */
    @RequestMapping("/my")
    public String my(Model model, HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        Integer userId = Integer.valueOf(attribute.toString());
        
        ItemOrder itemOrder = new ItemOrder();
        itemOrder.setUserId(userId);
        //全部订单
        List<ItemOrder> all = itemOrderService.listAllByEntityDesc(itemOrder);
        
        //待发货
        itemOrder.setStatus(0);
        List<ItemOrder> dfh = itemOrderService.listAllByEntityDesc(itemOrder);

        //已取消
        itemOrder.setStatus(1);
        List<ItemOrder> yqx = itemOrderService.listAllByEntityDesc(itemOrder);
        
        //待收货(已发货)
        itemOrder.setStatus(2);
        List<ItemOrder> dsh = itemOrderService.listAllByEntityDesc(itemOrder);
        
        //已收货
        itemOrder.setStatus(3);
        List<ItemOrder> ysh = itemOrderService.listAllByEntityDesc(itemOrder);

        model.addAttribute("all",all);
        model.addAttribute("dfh",dfh);
        model.addAttribute("yqx",yqx);
        model.addAttribute("dsh",dsh);
        model.addAttribute("ysh",ysh);
        return "itemOrder/my";
    }

    /**
     * 购物车结算提交
     */
    @RequestMapping("/exAdd")
    @ResponseBody
    public String exAdd(@RequestBody List<CarDto> list,HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        JSONObject js = new JSONObject();
        if(attribute==null){
            js.put(Consts.RES,0);
            return js.toJSONString();
        }
        Integer userId = Integer.valueOf(attribute.toString());
        User byId = userService.getById(userId);
        if(StringUtils.isEmpty(byId.getAddress())){
            js.put(Consts.RES,2);
            return js.toJSONString();
        }
        List<Integer> ids = new ArrayList<>();
        BigDecimal to = new BigDecimal(0);
        for(CarDto c:list){
            ids.add(c.getId());
            Car load = carService.getById(c.getId());
            to = to.add(new BigDecimal(load.getPrice()).multiply(new BigDecimal(c.getNum())));
        }
        ItemOrder order = new ItemOrder();
        order.setStatus(0);
        order.setCode(getOrderNo());
        order.setTotal(to.setScale(2,BigDecimal.ROUND_HALF_UP).toString());
        order.setUserId(userId);
        order.setAddTime(new Date());
        itemOrderService.insert(order);

        //订单详情放入orderDetail，删除购物车
        if(!CollectionUtils.isEmpty(ids)){
            for(CarDto c:list){
                Car load = carService.getById(c.getId());
                OrderDetail de = new OrderDetail();
                de.setItemId(load.getItemId());
                de.setOrderId(order.getId());
                de.setStatus(0);
                de.setNum(c.getNum());
                de.setTotal(String.valueOf(c.getNum()*load.getPrice()));
                orderDetailService.insert(de);
                //修改成交数
                Item load2 = itemService.getById(load.getItemId());
                load2.setGmNum(load2.getGmNum()+c.getNum());
                itemService.update(load2);
                //删除购物车
                carService.deleteById(c.getId());
            }
        }
        js.put(Consts.RES,1);
        return js.toJSONString();
    }

    private static String date;
    private static long orderNum = 0L;
    public static synchronized String getOrderNo(){
        String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        if(date==null||!date.equals(str)){
            date = str;
            orderNum = 0L;
        }
        orderNum++;
        long orderNO = Long.parseLong(date)*10000;
        orderNO += orderNum;
        return orderNO+"";
    }

    /**
     * 取消订单
     */
    @RequestMapping("/qx")
    public String qx(Integer id,Model model){
        ItemOrder obj =itemOrderService.getById(id);
        obj.setStatus(1);
        itemOrderService.update(obj);
        model.addAttribute("obj",obj);
        return "redirect:/user/itemOrder/my";
    }

    /**
     * 用户收货
     */
    @RequestMapping("/sh")
    public String sh(Integer id,Model model){
        ItemOrder obj =itemOrderService.getById(id);
        obj.setStatus(3);
        itemOrderService.update(obj);
        model.addAttribute("obj",obj);
        return "redirect:/user/itemOrder/my";
    }

    /**
     * 用户评价入口
     */
    @RequestMapping("/pj")
    public String pj(Integer id,Model model){
        model.addAttribute("id",id);
        return "itemOrder/pj";
    }
}




