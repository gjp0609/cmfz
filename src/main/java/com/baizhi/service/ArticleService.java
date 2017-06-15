package com.baizhi.service;

import com.baizhi.entity.Article;
import com.baizhi.entity.Page;

import java.util.List;

/**
 * article
 * Created by gjp06 on 17.6.13.
 */
public interface ArticleService {
    public Article queryOneArticle(Article article);

    public List<Article> queryAllArticle(Page page);

    public void addArticle(Article article);

    public void modifyArticle(Article article);

    public void removeArticle(Article article);
}
