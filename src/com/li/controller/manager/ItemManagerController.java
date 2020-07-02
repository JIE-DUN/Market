package com.li.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.li.base.BaseController;
import com.li.entity.Item;
import com.li.entity.ItemCategoryTwo;
import com.li.service.ItemCategoryTwoService;
import com.li.service.ItemService;
import com.li.utils.FileUploadUtil;
import com.li.utils.Pager;

@Controller
@RequestMapping("/manager/item")
public class ItemManagerController extends BaseController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemCategoryTwoService itemCategoryTwoService;

    /**
     * 分页查询商品列表
     */
    @RequestMapping("/findAll")
    public String findAll(Model model, Item item){
        Pager<Item> pagers = itemService.listItemByFuzzyDesc(item);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",item);
        return "item/item";
    }

    /**
     * 添加商品入口
     */
    @RequestMapping("/add")
    public String add(Model model){
        List<ItemCategoryTwo> allItemCategoryTwo = itemCategoryTwoService.listAll();
        model.addAttribute("types",allItemCategoryTwo);
        return "item/add";
    }

    /**
     * 执行添加商品
     * 优化：这个可以在修改界面引入一级类目，并根据一级类目选择二级类目
     */
    @RequestMapping("/exAdd")
    public String exAdd(Item item, @RequestParam("file")CommonsMultipartFile[] files, HttpServletRequest request) throws IOException {
        FileUploadUtil.itemCommon(item, files, request);
        ItemCategoryTwo itemCategoryTwo = itemCategoryTwoService.getById(item.getCategoryIdTwo());
        item.setCategoryIdOne(itemCategoryTwo.getOid());
        item.setGmNum(0);
        item.setScNum(0);
        itemService.insert(item);
        return "redirect:/manager/item/findAll.action";
    }

    /**
     * 修改商品入口
     */
    @RequestMapping("/update")
    public String update(Integer id,Model model){
        Item obj = itemService.getById(id);
        List<ItemCategoryTwo> allItemCategoryTwo = itemCategoryTwoService.listAll();
        model.addAttribute("types",allItemCategoryTwo);
        model.addAttribute("obj",obj);
        return "item/update";
    }

    /**
     * 执行修改商品
     * 优化：这个可以在修改界面引入一级类目，并根据一级类目选择二级类目
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(Item item, @RequestParam("file")CommonsMultipartFile[] files, HttpServletRequest request) throws IOException {
    	FileUploadUtil.itemCommon(item, files, request);
        ItemCategoryTwo itemCategoryTwo = itemCategoryTwoService.getById(item.getCategoryIdTwo());
        item.setCategoryIdOne(itemCategoryTwo.getOid());
        itemService.update(item);
        return "redirect:/manager/item/findAll.action";
    }


    /**
     * 商品下架
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        itemService.deleteById(id);
        return "redirect:/manager/item/findAll.action";
    }
}
