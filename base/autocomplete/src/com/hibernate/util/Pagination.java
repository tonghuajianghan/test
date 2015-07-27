package com.hibernate.util;

/**
 * 包含分页信息
 * @author shatter
 *
 */
public class Pagination {

	private int size;			// 每页显示的记录数
    private int page;			// 当前页号
	private int resultCount;	//总记录数
	private int pageCount;// 总页数
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getResultCount() {
		return resultCount;
	}
	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	
}
