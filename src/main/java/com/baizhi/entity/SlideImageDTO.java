package com.baizhi.entity;

import java.util.List;

/**
 * Created by gjp06 on 17.6.13.
 */
public class SlideImageDTO {
    private int total;
    private List<SlideImage> rows;

    @Override
    public String toString() {
        return "SlideImageDTO{" +
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

    public List<SlideImage> getRows() {
        return rows;
    }

    public void setRows(List<SlideImage> rows) {
        this.rows = rows;
    }
}
