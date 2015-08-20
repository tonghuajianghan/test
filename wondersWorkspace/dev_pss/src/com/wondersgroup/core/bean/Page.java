package com.wondersgroup.core.bean;

import java.util.ArrayList;
import java.util.List;

public class Page {
    public static final Page EMPTY_PAGE = new Page();

    public static final int DEFAULT_PAGE_SIZE = 10;

    private List<?> result;

    private int count;

    private int pageNo;

    private int pageCount;

    private int pageSize;

    public Page() {
        this(new ArrayList<Object>(), 0, 0, DEFAULT_PAGE_SIZE);
    }

    public Page(List<?> result, int count, int pageNo, int pageSize) {
        this.result = result == null ? new ArrayList<Object>() : result;
        this.count = count;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageCount = (count + pageSize - 1) / pageSize;
    }

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}