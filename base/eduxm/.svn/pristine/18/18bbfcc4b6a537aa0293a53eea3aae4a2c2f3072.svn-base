package cn.edu.cust.eduxm.group;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import cn.edu.cust.eduxm.group.dao.DecisionDAO;
import cn.edu.cust.eduxm.group.domain.Decision;
import cn.edu.cust.eduxm.util.PageFactory;
import cn.edu.cust.util.Page;
import cn.edu.cust.util.action.CommonAction2;
import cn.edu.cust.util.db.JdbcTool;
import cn.edu.cust.util.db.Worker;

public class DecisionAction extends CommonAction2 {
	
	private static DecisionDAO dao = new DecisionDAO();
	
	private DecisionSearch search = new DecisionSearch(); 
	
	private Decision obj;
	
	private Page mlpage = PageFactory.getPage();
	
	private int page;
	
	int[] ids;
	
	private float passRate;
	
	private List<Decision> rows;
	
	public static DecisionDAO getDao() {
		return dao;
	}


	public static void setDao(DecisionDAO dao) {
		DecisionAction.dao = dao;
	}


	public float getPassRate() {
		return passRate;
	}


	public void setPassRate(float passRate) {
		this.passRate = passRate;
	}


	public DecisionSearch getSearch() {
		return search;
	}


	public void setSearch(DecisionSearch search) {
		this.search = search;
	}


	public Decision getObj() {
		return obj;
	}


	public void setObj(Decision obj) {
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

	public List<Decision> getRows() {
		return rows;
	}

	public void setRows(List<Decision> rows) {
		this.rows = rows;
	}
	
	public String list() {
		success = JSON_SUCCESS;
		error = JSON_ERROR;
		
		return work(new Worker() {
			public void doWork() {
				List<Object> params = null;
				String sql = search.buildSQL();
				params = search.getParams();
				
				log.info("sql: ----------{}", sql);
				
				log.info("params:-------------{}", params);
				/*float pRate = dao.passrate(params, 60);
			
				log.info("pRate---------------{}",pRate);*/
				

				final ArrayList<Decision> result = new ArrayList<Decision>();

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
									Decision decision = new Decision();
									decision.setFields(rs);
									result.add(decision);
									log.info("专家组名称:{}",decision.getXmlb());
								}
								return null;
							}
						}, JdbcTool.getJdbcTemplate());

				rows = result;
			}
		});
	
	}
}

