package com.baizhi.dao;

import com.baizhi.entity.Article;
import com.baizhi.entity.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * dao
 * Created by gjp06 on 17.6.15.
 */
public interface ArticleDao {

    public List<Article> selectArticle(@Param("article") Article article, @Param("page") Page page);

    public int insertArticle(Article article);

    public int updateArticle(Article article);

    public int deleteArticle(Article article);

    public int selectTotalRows();
}
