package com.baizhi.entity;

import java.util.List;

/**
 * Created by gjp06 on 17.6.13.
 */
public class LamaDTO {
    private int total;
    private List<Lama> rows;

    @Override
    public String toString() {
        return "LamaDTO{" +
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

    public List<Lama> getRows() {
        return rows;
    }

    public void setRows(List<Lama> rows) {
        this.rows = rows;
    }
}
