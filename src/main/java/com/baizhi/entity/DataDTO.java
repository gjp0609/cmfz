package com.baizhi.entity;

import java.util.List;

/**
 * Created by gjp06 on 17.6.16.
 */
public class DataDTO<T> {
    private int total;
    private List<T> rows;

    @Override
    public String toString() {
        return "DataDTO{" +
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

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
