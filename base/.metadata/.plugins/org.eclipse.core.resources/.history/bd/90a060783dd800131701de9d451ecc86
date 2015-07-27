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

import cn.edu.cust.eduxm.project.dao.MemberDAO;
import cn.edu.cust.eduxm.project.domain.Member;
import cn.edu.cust.eduxm.util.PageFactory;
import cn.edu.cust.util.Page;
import cn.edu.cust.util.action.CommonAction2;
import cn.edu.cust.util.db.JdbcTool;
import cn.edu.cust.util.db.Worker;

public class MemberAction extends CommonAction2 {
	private static MemberDAO dao = new MemberDAO();
	
    private Member obj;
	
	private Page mlpage = PageFactory.getPage();
	
	private int page;
	
	private List<Member> members;
	
	private int projectid;//获得项目id。
	
	
	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public List<Member> getExperts() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public void setRows(int rows) {
		mlpage.setRecordNum(rows);
	}
	
	public List<Member> getRows() {
		return members;
	}
	
	public int getTotal(){
		return mlpage.getRowCount();
	}



	public static MemberDAO getDao() {
		return dao;
	}

	public static void setDao(MemberDAO dao) {
		MemberAction.dao = dao;
	}

	public Member getObj() {
		return obj;
	}

	public void setObj(Member obj) {
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
					
			@Override
			public void doWork() {
				members = dao.getAll(projectid);
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
		
		return work(new Worker() {
			
			@Override
			public void doWork() {
				// TODO Auto-generated method stub
				obj=dao.load(obj.getXm());
				//System.out.println(obj.getXm());
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
				dao.delete(obj.getXm());
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
