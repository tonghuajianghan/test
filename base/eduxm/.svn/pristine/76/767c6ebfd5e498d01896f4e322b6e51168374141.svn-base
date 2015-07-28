package cn.edu.cust.eduxm.project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import cn.edu.cust.eduxm.project.dao.PrincipalDAO;
import cn.edu.cust.eduxm.project.domain.Principal;
import cn.edu.cust.eduxm.util.PageFactory;
import cn.edu.cust.util.Page;
import cn.edu.cust.util.action.CommonAction2;
import cn.edu.cust.util.db.JdbcTool;
import cn.edu.cust.util.db.Worker;


public class PrincipalAction extends CommonAction2{
	private PrincipalDAO dao = new PrincipalDAO();
	private PrincipalSearch search = new PrincipalSearch();

    private Principal obj;
	
	private Page mlpage = PageFactory.getPage();
	
	private int page;
	
	private List<Principal> principals;
	
	private String toJsp;//action返回的页面
	
	private int projectid;//项目的id
	
	
	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public String getToJsp() {
		return toJsp;
	}

	public void setToJsp(String toJsp) {
		this.toJsp = toJsp;
	}

	public List<Principal> getPrincipals() {
		return principals;
	}

	public void setPrincipals(List<Principal> principals) {
		this.principals = principals;
	}

	public void setRows(int rows) {
		mlpage.setRecordNum(rows);
	}
	
	public List<Principal> getRows() {
		return principals;
	}
	
	public int getTotal(){
		return mlpage.getRowCount();
	}

	public PrincipalSearch getSearch() {
		return search;
	}

	public void setSearch(PrincipalSearch search) {
		this.search = search;
	}

	public Principal getObj() {
		return obj;
	}

	public void setObj(Principal obj) {
		this.obj = obj;
	}

	public Page getMlpage() {
		return mlpage;
	}

	public void setMlpage(Page mlpage) {
		this.mlpage = mlpage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public String list(){
		success = JSON_SUCCESS;
		error = JSON_ERROR;

		return work(new Worker() {
			public void doWork() {
				List<Object> params = null;
				String sql = null;

				sql = search.buildSQL();
				log.info("sql: ----------{}", sql);
				params = search.getParams();

				log.info("params:-------------{}",
						Arrays.toString(params.toArray()));

				final ArrayList<Principal> result = new ArrayList<Principal>();

				if (mlpage == null) {
					mlpage = PageFactory.getPage();
				}

				mlpage.setPageNum(page);
				log.info("page:-------{}",page);
				mlpage.getOnePage(sql, params,
						new ResultSetExtractor<Object>() {

							public Object extractData(ResultSet rs)
									throws SQLException, DataAccessException {

								while (rs.next()) {
									Principal principals = new Principal();
									principals.setFields(rs);
									result.add(principals);
								    log.info("x", principals.getFzrxm());
							        log.info("成员:{}",principals.getFzrxm());
								}
								return null;
							}
						}, JdbcTool.getJdbcTemplate());

				principals = result;
			}
		});
	}
	
	public String add() {
		//System.out.println("hello");
		successmsg = "添加成功";
		return work(new TransactionCallback<Object>() {

			public Object doInTransaction(TransactionStatus arg0) {
				//String user = ServletActionContext.getRequest().getRemoteUser();
				//obj.setAuthor(user);//自动给作者字段赋值（登录名）
			
				dao.insert(obj);

				return null;
			}
		});
	}
	
	public String update() {
		//System.out.println("hello");
		successmsg = "添加成功";
		return work(new TransactionCallback<Object>() {

			public Object doInTransaction(TransactionStatus arg0) {
				//String user = ServletActionContext.getRequest().getRemoteUser();
				//obj.setAuthor(user);//自动给作者字段赋值（登录名）
			
				dao.update(obj);

				return null;
			}
		});
	}
	
	public String load(){
		success = SUCCESS;
		error = ERROR;
		setToJsp("principal");//要跳转到  界面
		return work(new Worker() {

			@Override
			public void doWork() {
				log.info("id-----:{}",projectid);
				obj = dao.load(projectid);
				log.info("负责人信息--{}",obj);
			}
			
		});
	}
	
	public String delete(){
		successmsg = "删除成功";
		return work(new Worker() {
			
			@Override
			public void doWork() {
				log.info("{}",obj);
				// TODO Auto-generated method stub
				dao.delete(obj.getFzrxm());
			}
		});
		
	}
	
	public String getall(){
		successmsg = "删除成功";
		return work(new Worker() {
			
			@Override
			public void doWork() {
				// TODO Auto-generated method stub
				dao.getAll();
			}
		});
		
	}
}
