package com.baizhi.entity;

/**
 * Created by gjp06 on 17.6.8.
 */
public class Page {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer totalRows;

    public int getFirstRow() {
        return (pageIndex - 1) * pageSize;
    }

    public Page() {
        this(1, 5);
    }

    public Page(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    @Override
    public String toString() {
        return "Page{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", totalRows=" + totalRows +
                '}';
    }
}
