package cn.edu.cust.demo.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import cn.edu.cust.demo.domain.Account;
import cn.edu.cust.demo.domain.AccountDAO;
import cn.edu.cust.demo.domain.Operation;
import cn.edu.cust.demo.util.MySqlPage;
import cn.edu.cust.util.action.CommonAction2;
import cn.edu.cust.util.db.JdbcTool;
import cn.edu.cust.util.db.Worker;

public class UsrOperJson extends CommonAction2 {

	private static AccountDAO accountDao = new AccountDAO();
	// private static OperationDAO operationDao = new OperationDAO();

	/** 返回的json数据 20131023 liujiangyi */
	private List<Operation> objs;
	private MySqlPage mlpage;
	/** easyUI表格里面传回来的page;表示当前显示的是第几页 */
	private int page;
	/** easyUI表格传回来的rows;表示当前的分页单位 */
	private int rows;
	private int total;

	// private List<?> logs;

	/**
	 * 显示用户的操作记录
	 * 
	 * @return
	 */
	public String logs() {
		success = JSON_SUCCESS;
		error = JSON_ERROR;
		HttpServletRequest req = ServletActionContext.getRequest();
		final String accId = req.getRemoteUser();
		return work(new Worker() {

			public void doWork() {
				// TODO Auto-generated method stub
				Account acc = accountDao.load(accId);
				// 这里使用了匿名内部类
				// 主要是为了提供一个通用的查询方法，当然这里还没有考虑到分页。
				// 分页功能我还得继续完善
				log.info("page:" + page);
				log.info("rows:" + rows);
				String sql = "select * from c_operation where  c_src_id = ?  ";
				if (mlpage == null) {
					mlpage = new MySqlPage();
				}
				log.info("{}", mlpage.getRecordNum());
				final ArrayList<Operation> result = new ArrayList<Operation>();
				List<Object> params = new ArrayList<Object>();
				params.add(acc.getId());
				// new Object[]{acc.getId()}
				mlpage.setPageNum(page);
				mlpage.setRecordNum(rows);
				mlpage.getOnePage(sql, params,
						new ResultSetExtractor<Object>() {

							public Object extractData(ResultSet rs)
									throws SQLException, DataAccessException {
								// TODO Auto-generated method stub
								while (rs.next()) {
									Operation opt = new Operation();
									opt.setFields(rs);
									result.add(opt);
									// op.s
								}
								return null;
							}

						}, JdbcTool.getJdbcTemplate());
				objs = result;
				total = mlpage.getRowCount();
			}

		});
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Operation> getRows() {
		return objs;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
