package cn.edu.cust.eduxm.project;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import cn.edu.cust.eduxm.DataSourceFactory4Test;
import cn.edu.cust.eduxm.project.dao.AchievementBeforeDAO;
import cn.edu.cust.eduxm.project.dao.MemberDAO;
import cn.edu.cust.eduxm.project.dao.PrincipalDAO;
import cn.edu.cust.eduxm.project.dao.PrincipalProjectDAO;
import cn.edu.cust.eduxm.project.dao.ProjectDAO;
import cn.edu.cust.eduxm.project.domain.AchievementBefore;
import cn.edu.cust.eduxm.project.domain.Member;
import cn.edu.cust.eduxm.project.domain.Principal;
import cn.edu.cust.eduxm.project.domain.PrincipalProject;
import cn.edu.cust.eduxm.project.domain.Project;
import cn.edu.cust.util.db.JdbcTool;

public class Main {

	public static void main(String[] args) {
		DataSource ds = DataSourceFactory4Test.getDataSource();
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(ds);
		JdbcTool.setJdbcTemplate(jt);
		
		TransactionTemplate tt = new TransactionTemplate();
		tt.setTransactionManager(new DataSourceTransactionManager(ds));
		JdbcTool.setTransactionTemplate(tt);
		
		tt.execute(new TransactionCallback<Object>(){

			@Override
			public Object doInTransaction(TransactionStatus arg0) {
				 PrincipalDAO principalDao = new PrincipalDAO();
				 ProjectDAO projectDao = new ProjectDAO();
				 MemberDAO meberdao = new MemberDAO();
				 PrincipalProjectDAO ppdao = new PrincipalProjectDAO();
				 AchievementBeforeDAO abdao = new AchievementBeforeDAO();
//				 String path = "D:/ceshi/FileOne.doc";
				 String path = "D:/ceshi/FileThree.docx";
				GetInfo g = new GetInfo();
				
				//保存项目申请表的内容
				Project p = g.getProjectInfo(path);
				p.setZt("a19");
				projectDao.insert(p);
				
				//保存项目负责人表的内容
				Principal pr = g.getPrincipalInfo(path);
				pr.setId(p.getXm_id());//改为用项目表的id值作为负责人表的id，，，即两者id相同来达到一对一的关联
				principalDao.insert(pr);//他没有外键
			

				//保存项目成员表的内容
				List<Member> m = g.getMemberInfo(path);
				for(Member mem :m){
					mem.setXm_id(p.getXm_id());
					System.out.println(p.getXm_id());
					meberdao.insert(mem);
				}
				//保存负责人承担的项目表的内容
				List<PrincipalProject> pp = g.getPrincipalProjectInfo(path);
				for(PrincipalProject prip:pp){
					prip.setXmid(p.getXm_id());
					ppdao.insert(prip);
				}
				//保存负责人和组员近期研究成果表的内容
				List<AchievementBefore> ab = g.getAchievementBeforeInfo(path);
				for(AchievementBefore myab:ab){
					myab.setXmid(p.getXm_id());
					abdao.insert(myab);
				}
				return null;
			}
			
		});

	}

}
