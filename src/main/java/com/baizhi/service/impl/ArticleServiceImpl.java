package com.baizhi.service.impl;

import com.baizhi.dao.ArticleDao;
import com.baizhi.entity.Article;
import com.baizhi.entity.Page;
import com.baizhi.service.ArticleService;
import com.baizhi.utils.MyUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gjp06 on 17.6.15.
 */
@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Resource(name = "articleDao")
    private ArticleDao dao;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Article queryOneArticle(Article article) {
        if (article == null) throw new RuntimeException("article is null");
        if (article.getId() == null) throw new RuntimeException("article's id is null");
        List<Article> articles = dao.selectArticle(article, new Page());
        if (articles == null || articles.size() == 0) throw new RuntimeException("article to get is not exist");
        return articles.get(0);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Article> queryAllArticle(Page page) {
        int i = dao.selectTotalRows();
        page.setTotalRows(i);
        return dao.selectArticle(new Article(), page);
    }

    public void addArticle(Article article) {
        String uuid = MyUtils.getUUID();
        article.setId(uuid);
        int i = dao.insertArticle(article);
        if (i == 0) throw new RuntimeException("add article fail");
    }

    public void modifyArticle(Article article) {
        int i = dao.updateArticle(article);
        if (i == 0) throw new RuntimeException("modify article fail");
    }

    public void removeArticle(Article article) {
        int i = dao.deleteArticle(article);
        if (i == 0) throw new RuntimeException("remove article fail");
    }
}
