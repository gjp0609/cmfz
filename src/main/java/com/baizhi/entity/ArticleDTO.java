package com.baizhi.entity;

import java.util.List;

/**
 * Created by gjp06 on 17.6.15.
 */
public class ArticleDTO {
    private int total;
    private List<Article> rows;

    @Override
    public String toString() {
        return "ArticleDTO{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Article> getRows() {
        return rows;
    }

    public void setRows(List<Article> rows) {
        this.rows = rows;
    }
}
