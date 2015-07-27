package cn.edu.cust.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;

public abstract class Page {
	
	protected int pageNum = 1;//页码，从1开始
	
	protected int recordNum = 20;//每页记录数
	
	protected int rowCount;//总记录数
	
	protected int lastPage;

	public abstract String getLimitString(String sql);
	
	public ArrayList<?> getOnePage(final String sql, final List<?> params, ResultSetExtractor<?> rse, JdbcTemplate jt){
		setRowCount(sql, params, jt);
		setLastPage();
		if(pageNum > lastPage){
			pageNum = lastPage;
		}
		ArrayList<?> result = new ArrayList<Object>();
		
		jt.query(new PreparedStatementCreator(){

			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement ps = con.prepareStatement(getLimitString(sql), ResultSet.TYPE_SCROLL_INSENSITIVE);
				int pi = 1;
				for (Iterator<?> i = params.iterator(); i.hasNext();) {
					ps.setObject(pi++, i.next());
				}
				return ps;
			}
			
		}, rse);
		return result;
	}
	
	public void setRowCount(String sql, List<?> params, JdbcTemplate jt){
		StringBuffer sqlbuf = new StringBuffer();
		sqlbuf.append("select count(*) ");
		int fi = sql.indexOf("from");
		int oi = sql.lastIndexOf("order by");
		sqlbuf.append(sql.substring(fi, oi == -1 ? sql.length() : oi));//不需要order by
		jt.query(sqlbuf.toString(), params.toArray(), new ResultSetExtractor<Object>(){

			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				if(rs.next()){
					rowCount = rs.getInt(1);
				}
				return null;
			}
			
		});
	}
	
	public int getPrePage(){
		return pageNum <= 1 ? 1 : pageNum - 1;
	}
	
	public int getNextPage(){
		return pageNum >= lastPage ? lastPage : pageNum + 1;
	}
	
	public int getFirstPage(){
		return 1;
	}
	
	public int getLastPage() {
		return lastPage;
	}

	private void setLastPage(){
		if(rowCount == 0){
			lastPage = 1;
			return;
		}
		lastPage = rowCount % recordNum == 0 ? rowCount / recordNum : rowCount / recordNum + 1;
	}
	
	public int getOffset(){
		return (pageNum - 1) * recordNum;
	}
	
	public int getLimit(){
		return pageNum * recordNum;
	}

	public int getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(int recordNum) {
		if(recordNum > 0){
			this.recordNum = recordNum;
		}
	}

	public void setPageNum(int pageNum) {
		if(pageNum > 0){
			this.pageNum = pageNum;
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getRowCount() {
		return rowCount;
	}
	
	public ArrayList<?> getPages(){
		ArrayList<Object> pages = new ArrayList<Object>();
		for (int i = 1; i <= lastPage; i++) {
			pages.add(i);
		}
		return pages;
	}
	
	/**
	 * range最好使用奇数
	 * @param range
	 * @return
	 */
	public ArrayList<?> getPages(int range){
		int end = pageNum + range / 2;
		if(end > lastPage){
			end = lastPage;
		}
		int start = end - range + 1;
		if(start < 1){
			start = 1;
			end = start + range - 1;
			if(end > lastPage){
				end = lastPage;
			}
		}
		ArrayList<Integer> pages = new ArrayList<Integer>();
		for (int i = start; i <= end; i++) {
			pages.add(i);
		}
		return pages;
	}
}
