package com.example.demo.entity;

import java.util.List;

public class Page {
    private Long total;
    private List<LedLight> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<LedLight> getRows() {
        return rows;
    }

    public void setRows(List<LedLight> rows) {
        this.rows = rows;
    }
}
