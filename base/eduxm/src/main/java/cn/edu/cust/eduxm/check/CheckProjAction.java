package cn.edu.cust.eduxm.check;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import cn.edu.cust.eduxm.project.ProjectSearch;
import cn.edu.cust.eduxm.project.dao.ProjectDAO;
import cn.edu.cust.eduxm.project.domain.Project;
import cn.edu.cust.eduxm.util.PageFactory;
import cn.edu.cust.rbac.domain.Org;
import cn.edu.cust.util.Page;
import cn.edu.cust.util.action.CommonAction2;
import cn.edu.cust.util.db.JdbcTool;
import cn.edu.cust.util.db.Worker;

public class CheckProjAction extends CommonAction2{
	
	private Project obj;

	private List<Project> projects;
	
	private Page mspage = PageFactory.getPage();
	
	private ProjectSearch search = new ProjectSearch();// 复杂对象必须得有get、set方法，否则struts2在存取属性时会有问题
	
	private ProjectDAO dao = new ProjectDAO();
	
	private int page;
	
	private int projectid;
	
	private int[] ids;
	
	
	
	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
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
	
	public ProjectSearch getSearch() {
		return search;
	}

	public void setSearch(ProjectSearch search) {
		this.search = search;
	}
	/**
	 * 教育厅审核项目的list   要求返回状态为b19的和c0开头的
	 * @return
	 */
	public String eduList(){
		//用search的对象生成sql语句       b19待审核 c00零时状态的未通过 c09零时状态的通过 c19永久状态的通过 c10永久状态的未通过
		String sql = search.buildSQL("(c_zt = 'b19' or c_zt like 'c0%')");
		return list(sql,"edush");
	}
	
	/**
	 * 学校审核，需要获得用户的所属学校，然后查找所属单位为此学校的项目信息
	 * @return
	 */
	public String schoolList(){
		//用search的对象生成sql语句     a19项目刚刚申报的时候，b0开头的 b0表示暂时状态，当0变成1时就不能被搜索到了
		String orgcode = Org.getOrgCodeFromSession();
		search.getParams().add(orgcode);//添加参数   对应的是下面的c_orgcode
		String sql = search.buildSQL("(c_zt = 'a19' or c_zt like 'b0%') and c_orgcode = ?");
		return list(sql,"bdwsh");
	}
	/**
	 * 学校审核的时候
	 * @return
	 * 
	 */
	public String schoolPass(){
		return changeZt(projectid, "b09","bdwsh");
	}
	/**
	 * 学校不通过
	 * @return
	 */
	public String schoolNoPass(){
		return changeZt(projectid, "b00","bdwsh");
	}
	
	/**
	 * 教育厅审核的时候
	 */
	public String eduPass(){
		return changeZt(projectid, "c09","edush");
	}
	/**
	 * 教育厅不通过
	 * @return
	 */
	public String eduNoPass(){
		return changeZt(projectid, "c00","edush");
	}
	/**
	 * 将临时状态改为永久状态  教育厅结束审核
	 * @return
	 */
	public String eduConfirm(){
		return changeZtFinal("c0","edush");
	}
	/**
	 * 将临时状态改为永久状态 学校审核
	 * @return
	 */
	public String schoolConfirm(){
		return changeZtFinal("b0","bdwsh");
		
	}
	/**
	 * 改变最终的状态  即将中间的状态由0变1  
	 * @param zt 为条件,传b0或则c0,c0或则b0。。where c_zt like ?  参数zt就是代替？号
	 * @return
	 */
	private String changeZtFinal(final String zt,String permission){
		success = JSON_SUCCESS;
		error = JSON_ERROR;
		errormsg = "操作失败";
		return work(new TransactionCallback<Project>() {

			@Override
			public Project doInTransaction(TransactionStatus arg0) {
				log.info("zt--------------{}",zt);
				dao.updateFinally(zt);
				return null;
			}
		}, permission);
	}
	/**
	 * 更改状态
	 * @param id  工程的id
	 * @param zt  工程的状态，将要改成的状态
	 * @return
	 */
	private String changeZt(final int id,final String zt,String permission){
		success = JSON_SUCCESS;
		error = JSON_ERROR;
		errormsg = "操作失败";
		return work(new TransactionCallback<Project>() {
			@Override
			public Project doInTransaction(TransactionStatus arg0) {
				dao.updateZt(id, zt);
				return null;
			}
		},permission);
	}
	/**
	 * 
	 * @param sql sql语句  查询一个list
	 */
	private String list(final String sql,String permission){
		success = JSON_SUCCESS;
		error = JSON_ERROR;
		return work(new Worker() {
			@Override
			public void doWork() {
				final ArrayList<Project> result = new ArrayList<Project>();
				mspage.setPageNum(page);
				log.info("-----------------listSql:{}",sql);
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
		},permission);
	}
}
