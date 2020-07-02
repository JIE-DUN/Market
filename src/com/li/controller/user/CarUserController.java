package com.li.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.li.entity.Car;
import com.li.entity.Item;
import com.li.service.CarService;
import com.li.service.ItemService;
import com.li.utils.Consts;
import com.li.utils.Pager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * 购物车
 */
@Controller
@RequestMapping("/user/car")
public class CarUserController {

	@Autowired
	private CarService carService;

	@Autowired
	private ItemService itemService;

	@RequestMapping("/exAdd")
	@ResponseBody
	public String exAdd(Car car, HttpServletRequest request) {
		JSONObject js = new JSONObject();
		Object attribute = request.getSession().getAttribute(Consts.USERID);
		if (attribute == null) {
			js.put(Consts.RES, 0);
			return js.toJSONString();
		}
		// 保存到购物车
		Integer userId = Integer.valueOf(attribute.toString());
		car.setUserId(userId);
		Item item = itemService.getById(car.getItemId());
		String price = item.getPrice();
		Double valueOf = Double.valueOf(price);
		car.setPrice(valueOf);
		if (item.getZk() != null) {
			valueOf = valueOf * item.getZk() / 10;
			BigDecimal bg = new BigDecimal(valueOf).setScale(2, RoundingMode.UP);
			car.setPrice(bg.doubleValue());
			valueOf = bg.doubleValue();
		}
		Integer num = car.getNum();
		Double t = valueOf * num;

		BigDecimal bg = new BigDecimal(t).setScale(2, RoundingMode.UP);
		double doubleValue = bg.doubleValue();
		car.setTotal(doubleValue + "");
		carService.insert(car);
		js.put(Consts.RES, 1);
		return js.toJSONString();
	}

	/**
	 * 转向我的购物车页面
	 */
	@RequestMapping("/findUserCar")
	public String findUserCar(Model model, HttpServletRequest request) {
		//TODO 将购物车改造为能翻页的
		Object attribute = request.getSession().getAttribute(Consts.USERID);
		Integer userId = Integer.valueOf(attribute.toString());
		List<Car> list = carService.listCarByUserId(userId);
		Car car = new Car();
		car.setUserId(userId);
		Pager<Car> pagers = carService.findByEntityPaging(car);
		model.addAttribute("list", list);
		model.addAttribute("pagers", pagers);
		return "car/car";
	}

	/**
	 * 删除购物车
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Integer id) {
		carService.deleteById(id);
		JSONObject js = new JSONObject();
		js.put(Consts.RES, 1);
		return js.toJSONString();
	}
}
