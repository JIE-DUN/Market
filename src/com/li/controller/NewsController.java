package com.li.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.li.base.BaseController;
import com.li.entity.News;
import com.li.service.NewsService;
import com.li.utils.Pager;

/**
 * 公告管理
 */
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController {

    @Autowired
    private NewsService newsService;

    /**
     * 前端公告列表
     */
    @RequestMapping("/list")
    public String list(Model model){
        Pager<News> pagers = newsService.findByEntityPaging(new News());
        model.addAttribute("pagers",pagers);
        return "news/list";
    }

    /**
     * 公告详情页面
     */
    @RequestMapping("/view")
    public String view(Integer id,Model model){
        News obj = newsService.getById(id);
        model.addAttribute("obj",obj);
        return "news/view";
    }
}
