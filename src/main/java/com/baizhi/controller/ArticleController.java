package com.baizhi.controller;

import com.baizhi.entity.Article;
import com.baizhi.entity.DataDTO;
import com.baizhi.entity.Page;
import com.baizhi.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by gjp06 on 17.6.15.
 */
@Controller("articleController")
@RequestMapping("/article")
public class ArticleController {

    @Resource(name = "articleService")
    private ArticleService service;

    @RequestMapping("/queryOne")
    @ResponseBody
    public Article queryOne(String id) {
        Article article = new Article();
        article.setId(id);
        return service.queryOneArticle(article);
    }

    @RequestMapping(value = "/getDetail", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String getDetail(String id, HttpServletResponse response) throws IOException {
        Article article = new Article();
        article.setId(id);
        return service.queryOneArticle(article).getContent();
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public DataDTO<Article> queryAll(Integer page, Integer rows) {
        Page p = new Page(page, rows);
        List<Article> articleList = service.queryAllArticle(p);
        DataDTO<Article> articleDataDTO = new DataDTO<Article>();
        articleDataDTO.setTotal(p.getTotalRows());
        articleDataDTO.setRows(articleList);
        return articleDataDTO;
    }

    @RequestMapping("/add")
    @ResponseBody
    public void add(Article article) {
        if (!"on".equalsIgnoreCase(article.getStatus()))
            article.setStatus("off");
        service.addArticle(article);
    }

    @RequestMapping("/modify")
    @ResponseBody
    public void modify(Article article) {
        service.modifyArticle(article);
    }
}
