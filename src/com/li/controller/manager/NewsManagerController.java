package com.li.controller.manager;

import java.util.Date;

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
@RequestMapping("/manager/news")
public class NewsManagerController extends BaseController {

    @Autowired
    private NewsService newsService;

    /**
     * 管理员后端公告列表
     */
    @RequestMapping("/findAllNews")
    public String findAllNews(News news, Model model){
        News n = new News();
        n.setName(news.getName());
        Pager<News> pagers = newsService.findByEntityPaging(n);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",news);
        return "news/news";
    }

    /**
     * 跳转到添加页面
     */
    @RequestMapping("/add")
    public String add(){
        return "news/add";
    }

    /**
     * 添加执行
     */
    @RequestMapping("/exAdd")
    public String exAdd(News news){
        news.setAddTime(new Date());
        newsService.insert(news);
        return "redirect:/manager/news/findAllNews";
    }

    /**
     * 跳转到修改页面
     */
    @RequestMapping("/update")
    public String update(Integer id,Model model){
        News obj = newsService.getById(id);
        model.addAttribute("obj",obj);
        return "news/update";
    }

    /**
     * 修改执行
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(News news){
        newsService.update(news);
        return "redirect:/manager/news/findAllNews";
    }

    /**
     * 删除公告
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        newsService.deleteById(id);
        return "redirect:/manager/news/findAllNews";
    }

}
