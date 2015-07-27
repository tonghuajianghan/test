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

import cn.edu.cust.eduxm.project.dao.AchievementBeforeDAO;
import cn.edu.cust.eduxm.project.domain.AchievementBefore;
import cn.edu.cust.eduxm.util.PageFactory;
import cn.edu.cust.util.Page;
import cn.edu.cust.util.action.CommonAction2;
import cn.edu.cust.util.db.JdbcTool;
import cn.edu.cust.util.db.Worker;

public class AchievementBeforeAction extends CommonAction2 {
	
	private AchievementBeforeDAO dao = new AchievementBeforeDAO();
	
    private AchievementBefore obj;
	
	private Page mlpage = PageFactory.getPage();
	
	private int page;
	
	private List<AchievementBefore> achiBefores;
	
	private int projectid;//项目的id
	
	
	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public void setRows(int rows) {
		mlpage.setRecordNum(rows);
	}
	
	public List<AchievementBefore> getRows() {
		return achiBefores;
	}
	
	public int getTotal(){
		return mlpage.getRowCount();
	}

	public AchievementBefore getObj() {
		return obj;
	}

	public void setObj(AchievementBefore obj) {
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
				achiBefores = dao.getAll(projectid);
				
			}
		});
	}
	
	public String add() {
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
		
		return work(new Worker() {
			
			@Override
			public void doWork() {
				// TODO Auto-generated method stub
				obj=dao.load(obj.getCgzz());
				//log.info("{}",obj.getUsername());
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
				dao.delete(obj.getCgzz());
			}
		});
		
	}
}
