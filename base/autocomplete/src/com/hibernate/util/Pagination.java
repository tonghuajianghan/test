package com.hibernate.util;

/**
 * ������ҳ��Ϣ
 * @author shatter
 *
 */
public class Pagination {

	private int size;			// ÿҳ��ʾ�ļ�¼��
    private int page;			// ��ǰҳ��
	private int resultCount;	//�ܼ�¼��
	private int pageCount;// ��ҳ��
	
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
