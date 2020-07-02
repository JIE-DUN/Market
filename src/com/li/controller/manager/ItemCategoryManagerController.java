package com.li.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.li.base.BaseController;
import com.li.entity.ItemCategoryOne;
import com.li.entity.ItemCategoryTwo;
import com.li.service.ItemCategoryOneService;
import com.li.service.ItemCategoryTwoService;
import com.li.service.ItemService;
import com.li.utils.Consts;
import com.li.utils.Pager;

/**
 * 类目c层
 */
@Controller
@RequestMapping("/manager/itemCategory")
public class ItemCategoryManagerController extends BaseController {

    @Autowired
    private ItemCategoryOneService itemCategoryOneService;

    @Autowired
    private ItemCategoryTwoService itemCategoryTwoService;
    
    @Autowired
    private ItemService itemService;

    /**
     * 分页查询类目列表
     */
    @RequestMapping("/findAllItemCategory1")
    public String findAllItemCategory1(Model model,ItemCategoryOne itemCategoryOne){
        Pager<ItemCategoryOne> pagers = itemCategoryOneService.findByEntityPaging(new ItemCategoryOne());
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",itemCategoryOne);
        return "itemCategory/itemCategory";
    }

    /**
     * 转向到新增一级类目页面
     */
    @RequestMapping("/add")
    public String add(){
        return "itemCategory/add";
    }

    /**
     * 新增一级类目保存功能
     */
    @RequestMapping("/exAdd")
    public String exAdd(ItemCategoryOne itemCategoryOne){
        itemCategoryOneService.insert(itemCategoryOne);
        return "redirect:/manager/itemCategory/findAllItemCategory1.action";
    }

    /**
     * 转向到修改一级类目页面
     */
    @RequestMapping(value = "/update")
    public String update(Integer id,Model model){
        ItemCategoryOne obj = itemCategoryOneService.getById(id);
        model.addAttribute("obj",obj);
        return "itemCategory/update";
    }

    /**
     * 修改一级类目
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(ItemCategoryOne itemCategory){
        itemCategoryOneService.update(itemCategory);
        return "redirect:/manager/itemCategory/findAllItemCategory1.action";
    }

    /**
     * 删除类目
     * 0 该类目下还有二级类目，不能删除
     * 1 删除成功
     */
	@RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
    	JSONObject js = new JSONObject();
    	Long sum = itemCategoryTwoService.getItemCategoryTwoNum(id);
    	if(sum > 0){
    		js.put(Consts.RES, 0);
    		return js.toJSONString();
    	}
    	itemCategoryOneService.deleteById(id);
    	js.put(Consts.RES, 1);
    	return js.toJSONString();
    }

    /**
     * 查看二级类目
     */
    //findBySql2
    @RequestMapping("/findAllItemCategory2")
    public String findAllItemCategory2(ItemCategoryTwo itemCategoryTwo,Model model){
        Pager<ItemCategoryTwo> pagers = itemCategoryTwoService.findByEntityPaging(itemCategoryTwo);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",itemCategoryTwo);
        return "itemCategory/itemCategory2";
    }

    /**
     * 转向到新增二级类目页面
     */
    @RequestMapping(value = "/add2")
    public String add2(int oid,Model model){
        model.addAttribute("oid",oid);
        return "itemCategory/add2";
    }

    /**
     * 新增二级类目保存功能
     */
    @RequestMapping("/exAdd2")
    public String exAdd2(ItemCategoryTwo itemCategoryTwo){
    	itemCategoryTwoService.insert(itemCategoryTwo);
        return "redirect:/manager/itemCategory/findAllItemCategory2.action?oid="+itemCategoryTwo.getOid();
    }

    /**
     * 转向到修改二级类目页面
     */
    @RequestMapping(value = "/update2")
    public String update2(Integer id,Model model){
        ItemCategoryTwo obj = itemCategoryTwoService.getById(id);
        model.addAttribute("obj",obj);
        return "itemCategory/update2";
    }

    /**
     * 修改二级类目
     */
    @RequestMapping("/exUpdate2")
    public String exUpdate2(ItemCategoryTwo itemCategoryTwo){
    	itemCategoryTwoService.update(itemCategoryTwo);
        return "redirect:/manager/itemCategory/findAllItemCategory2.action?oid="+itemCategoryTwo.getOid();
    }

    /**
     * 删除二级类目
     */
    @RequestMapping("/delete2")
    @ResponseBody
    public String delete2(Integer id){
        JSONObject js = new JSONObject();
        Long sum =  itemService.getItemNum(id);
    	if(sum > 0){
    		js.put(Consts.RES, 0);
    		return js.toJSONString();
    	}
    	itemCategoryTwoService.deleteById(id);
    	js.put(Consts.RES, 1);
    	return js.toJSONString();
    }
}
