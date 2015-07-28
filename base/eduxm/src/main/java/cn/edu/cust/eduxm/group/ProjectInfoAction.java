package cn.edu.cust.eduxm.group;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import cn.edu.cust.eduxm.group.domain.Group;
import cn.edu.cust.eduxm.project.ProjectSearch;
import cn.edu.cust.eduxm.project.dao.ProjectDAO;
import cn.edu.cust.eduxm.project.domain.Project;
import cn.edu.cust.eduxm.util.PageFactory;
import cn.edu.cust.util.Page;
import cn.edu.cust.util.action.CommonAction2;
import cn.edu.cust.util.db.JdbcTool;
import cn.edu.cust.util.db.Worker;

public class ProjectInfoAction extends CommonAction2{
	private Project obj;

	private List<Project> projects;
	
	private Page mspage = PageFactory.getPage();
	
	private ProjectInfoSearch search = new ProjectInfoSearch();// 复杂对象必须得有get、set方法，否则struts2在存取属性时会有问题
	
	private ProjectDAO dao = new ProjectDAO();
	
	private int page;
	/** easyUI表格传回来的rows;表示当前的分页单位 */
	private String toJsp;//跳转前台jsp的路径
	//获取专家组id
	private String groupId;
	
	public String getToJsp() {
		return toJsp;
	}

	public void setToJsp(String toJsp) {
		this.toJsp = toJsp;
	}

	public List<Project> getRows(){
		return projects;
	}
	
	public int getTotal() {
		return mspage.getRowCount();
	}
	
	public void setRows(int rows) {
		mspage.setRecordNum(rows);
	}
	
	public void setPage(int page){
		mspage.setPageNum(page);
	}

	public Project getObj() {
		return obj;
	}

	public void setObj(Project obj) {
		this.obj = obj;
	}

	public Page getMspage() {
		return mspage;
	}

	public void setMspage(Page mspage) {
		this.mspage = mspage;
	}

	public int getPage() {
		return page;
	}
	
	int[] ids;
	
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public ProjectInfoSearch getSearch() {
		return search;
	}

	public void setSearch(ProjectInfoSearch search) {
		this.search = search;
	}

	public ProjectDAO getDao() {
		return dao;
	}

	public void setDao(ProjectDAO dao) {
		this.dao = dao;
	}

	public int[] getIds() {
		return ids;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * 评审打分通过专家组id获得项目
	 * @return
	 */
	public String list(){
		log.info("专家组id"+groupId);
		success = JSON_SUCCESS;
		error = JSON_ERROR;
		return work(new Worker() {
			
			@Override
			public void doWork() {

				final ArrayList<Project> result = new ArrayList<Project>();
				mspage.setPageNum(page);
				log.info(groupId+"===============");
				String sql = search.buildSQL("c_zjz_id="+groupId);
				log.info("listSql:{}---------------------",sql);
				mspage.getOnePage(sql, search.getParams(), new ResultSetExtractor<Object>() {
		
					public Object extractData(ResultSet rs)
							throws SQLException, DataAccessException {
		
						while (rs.next()) {
							Project pj = new Project();
							pj.setFields(rs);
							result.add(pj);
						}
						return null;
					}
				}, JdbcTool.getJdbcTemplate());
				 projects = result;
				 log.info("这里是projects:{}",projects.toString());
			}
		});
	}
}
