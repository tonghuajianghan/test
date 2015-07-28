package cn.edu.cust.eduxm.group;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import cn.edu.cust.eduxm.group.dao.ScoreDAO;
import cn.edu.cust.eduxm.group.domain.Group;
import cn.edu.cust.eduxm.group.domain.Score;
import cn.edu.cust.eduxm.project.dao.ProjectDAO;
import cn.edu.cust.eduxm.util.PageFactory;
import cn.edu.cust.util.Page;
import cn.edu.cust.util.action.CommonAction2;
/**
 * 评审打分Action
 * @author Administrator
 *
 */
public class ScoreAction extends CommonAction2{

	private static ScoreDAO dao = new ScoreDAO();
	
	private ProjectDAO pdao = new ProjectDAO();
	
	private ScoreInfoSearch search = new ScoreInfoSearch();
	
	private Score obj; 
	
	private Page mlpage = PageFactory.getPage();
	
	private int page;
	
	int[] ids;
	
	private List<Score> rows;


	public static ScoreDAO getDao() {
		return dao;
	}


	public static void setDao(ScoreDAO dao) {
		ScoreAction.dao = dao;
	}


	public ScoreInfoSearch getSearch() {
		return search;
	}


	public void setSearch(ScoreInfoSearch search) {
		this.search = search;
	}


	public Score getObj() {
		return obj;
	}


	public void setObj(Score obj) {
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


	public int[] getIds() {
		return ids;
	}


	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public List<Score> getRows() {
		return rows;
	}

	public void setRows(List<Score> rows) {
		this.rows = rows;
	}


	/**
	 * 添加分数到数据库
	 * id为自增长
	 * @return
	 */
	public String add() {
		successmsg = "打分成功";
		return work(new TransactionCallback<Object>() {

			public Object doInTransaction(TransactionStatus arg0) {
//				log.info("此处可进行。。。");
				log.info("score总分为"+(obj.getFs1()+obj.getFs2()+obj.getFs3()+obj.getFs4())/4);
				obj.setZf((obj.getFs1()+obj.getFs2()+obj.getFs3()+obj.getFs4())/4);
				
				//判断是要更新打分还是插入打分
				if(dao.judge(obj.getXm_id(),obj.getZjid())){
					dao.update(obj);
				}else{
					dao.insert(obj);
				}
				
				float score = dao.getAvgScore(obj.getXm_id());
				log.info(score+"评卷分。。。。。。");
				pdao.updateScore(score, obj.getXm_id());
//				log.info("输出平均分--------------"+score);
				return null;
			}
		});
	}
	
	
}
