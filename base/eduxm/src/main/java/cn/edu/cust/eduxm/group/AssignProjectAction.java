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

import cn.edu.cust.eduxm.expert.domain.Expert;
import cn.edu.cust.eduxm.group.domain.AssignExpert;
import cn.edu.cust.eduxm.group.domain.Group;
import cn.edu.cust.eduxm.project.ProjectSearch;
import cn.edu.cust.eduxm.project.dao.ProjectDAO;
import cn.edu.cust.eduxm.project.domain.Project;
import cn.edu.cust.eduxm.util.PageFactory;
import cn.edu.cust.util.MySqlPage;
import cn.edu.cust.util.Page;
import cn.edu.cust.util.action.CommonAction2;
import cn.edu.cust.util.db.JdbcTool;
import cn.edu.cust.util.db.Worker;

public class AssignProjectAction extends CommonAction2 {

	private static ProjectDAO dao = new ProjectDAO();

	// private GroupInfoSearch search = new GroupInfoSearch();

	private ProjectSearch search = new ProjectSearch();

	private String type;

	private Expert obj;

	private int groupId;
	
	private Page mlpage = PageFactory.getPage();

	private int page;

	String[] ids;

	// 专家分组_专业领域
	private String groupField;

	private List<Project> rows;

	public ProjectSearch getSearch() {
		return search;
	}

	public void setSearch(ProjectSearch search) {
		this.search = search;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Expert getObj() {
		return obj;
	}

	public void setObj(Expert obj) { 
		this.obj = obj;
	}

	public String[] getIds() {
		return ids;
	}

	public void setRows(List<Project> rows) {
		this.rows = rows;
	}

	public String getGroupField() {
		return groupField;
	}

	public void setGroupField(String groupField) {
		this.groupField = groupField;
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

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public List<Project> getRows() {
		return rows;
	}

	public void setRows(int rows) {
		mlpage.setRecordNum(rows);
	}

	public int getTotal() {
		return mlpage.getRowCount();
	}

	public void setPage(int page) {
		mlpage.setPageNum(page);
	}

	/**
	 * 添加专家组 id为自增长
	 * 
	 * @return
	 */
	public String add() {
		successmsg = "添加成功";
		return work(new TransactionCallback<Object>() {

			public Object doInTransaction(TransactionStatus arg0) {
				// String user =
				// ServletActionContext.getRequest().getRemoteUser();
				// obj.setAuthor(user);//自动给作者字段赋值（登录名）

				if (mlpage == null) {
					mlpage = new MySqlPage();
				}
				mlpage.setPageNum(page);
				log.info("项目ids的长度：{}", ids.length);
				if (ids != null) {
					for (int i = ids.length - 1; i >= 0; i--) {
						String updateSQL = "update c_project set c_zjz_id = ? where c_xm_id = ?";
						log.info("专家ids:{},专家组id:{}", ids[i], groupId);
						JdbcTool.getJdbcTemplate().update(updateSQL, new Object[]{groupId,ids[i]});
						String updateProjectNumSQL = "update c_group set c_xms = c_xms + 1 where c_zjz_id = ?";
						JdbcTool.getJdbcTemplate().update(updateProjectNumSQL, new Object[]{groupId});
					}
				}
				return null;
			}
		}, "psfz");
	}

	/**
	 * 根据id删除分组中的项目
	 * 
	 * @return
	 */
	public String del() {
		successmsg = "删除成功";
		return work(new TransactionCallback<Object>() {
			public Object doInTransaction(TransactionStatus arg0) {
				if (mlpage == null) {
					mlpage = new MySqlPage();
				}
				mlpage.setPageNum(page);
				if (ids != null) {
					for (int i = ids.length - 1; i >= 0; i--) {
						String updateSQL = "update c_project set c_zjz_id = null where c_xm_id = ?";
						log.info("项目ID：{}",ids[i]);
						JdbcTool.getJdbcTemplate().update(updateSQL, new Object[]{ids[i]});
						String updateProjectNumSQL = "update c_group set c_xms = c_xms - 1 where c_zjz_id = ?";
						JdbcTool.getJdbcTemplate().update(updateProjectNumSQL, new Object[]{groupId});
					}
				}
				return null;
			}
		}, "psfz");
	}

	public String list() {
		success = JSON_SUCCESS;
		error = JSON_ERROR;

		return work(new Worker() {
			public void doWork() {
				List<Object> params = null;
				String sql = null;
				if(type.equals("1")){
					sql = search.buildSQL(" c_zjz_id is null ");
				}else{
					sql = search.buildSQL(" c_zjz_id = '" + groupId +"'");
				}

				log.info("sql: ----------{},groupField:--{}", sql, groupField);
				params = search.getParams();

				log.info("params:-------------{}",
						Arrays.toString(params.toArray()));

				final ArrayList<Project> result = new ArrayList<Project>();

				if (mlpage == null) {
					mlpage = PageFactory.getPage();
				}

				mlpage.setPageNum(page);
				log.info("page:-------{}", page);
				mlpage.getOnePage(sql, params,
						new ResultSetExtractor<Object>() {

							public Object extractData(ResultSet rs)
									throws SQLException, DataAccessException {

								while (rs.next()) {
									Project project = new Project();
									project.setFields(rs);
									result.add(project);
									log.info("专家组名称:{}", project.getZjz_id());
								}
								return null;
							}
						}, JdbcTool.getJdbcTemplate());

				rows = result;
			}
		});
	}

}
