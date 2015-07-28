package cn.edu.cust.eduxm.project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import cn.edu.cust.eduxm.project.dao.ProjectDAO;
import cn.edu.cust.eduxm.project.domain.Project;
import cn.edu.cust.eduxm.util.PageFactory;
import cn.edu.cust.util.MySqlPage;
import cn.edu.cust.util.Page;
import cn.edu.cust.util.action.CommonAction2;
import cn.edu.cust.util.db.JdbcTool;
import cn.edu.cust.util.db.Worker;
import cn.edu.cust.util.search.Search;

public class ProjectAction extends CommonAction2{
	private Project obj;

	private List<Project> projects;
	
	private Page mspage = PageFactory.getPage();
	
	private ProjectSearch search = new ProjectSearch();// 复杂对象必须得有get、set方法，否则struts2在存取属性时会有问题
	
	private ProjectDAO dao = new ProjectDAO();
	
	private int page;
	/** easyUI表格传回来的rows;表示当前的分页单位 */
	private String toJsp;//跳转前台jsp的路径
	
	
	
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
	
	public ProjectSearch getSearch() {
		return search;
	}

	public void setSearch(ProjectSearch search) {
		this.search = search;
	}

	public String list(){
		success = JSON_SUCCESS;
		error = JSON_ERROR;
		return work(new Worker() {
			
			@Override
			public void doWork() {

				final ArrayList<Project> result = new ArrayList<Project>();
				mspage.setPageNum(page);
				String sql = search.buildSQL();
				log.info("listSql:{}",sql);
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
				 log.info("这里是projects:{}",projects.size());
			}
		});
	}

	/**
	 * 邓俊文   2014-5-5  20:01
	 * 项目信息内容太多。要点击查看才能看到更多细节
	 * @return
	 */
	public String details(){
		success = SUCCESS;
		error = ERROR;
		this.toJsp = "details";
		return work(new Worker() {
			
			@Override
			public void doWork() {
				log.info("点击查看详情的项目的id为:{}------",obj.getXm_id());
				obj = dao.load(obj.getXm_id());
				obj.setSqcn("");
				log.info("obj中的详细信息{}",obj.toString());
			}
		});
	}
	public String add() {
		successmsg = "添加成功";
		return work(new TransactionCallback<Object>() {

			public Object doInTransaction(TransactionStatus arg0) {
			
				dao.insert(obj);
				return null;
			}
		});
	}
	
	public String load(){
		
		return work(new Worker() {
			
			@Override
			public void doWork() {
				// TODO Auto-generated method stub
				obj=dao.load(ids[0]);
				log.info("加载分组为：{}",obj.getXmmc());
			}
		});
		
	}
	
	public String delete(){
		successmsg = "删除成功";
		return work(new Worker() {
			
			@Override
			public void doWork() {
				// TODO Auto-generated method stub
				dao.delete(obj);
			}
		});
		
	}
}
