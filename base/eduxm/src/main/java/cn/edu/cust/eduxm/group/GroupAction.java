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

import cn.edu.cust.eduxm.expert.ExpertInfoSearch;
import cn.edu.cust.eduxm.expert.domain.Expert;
import cn.edu.cust.eduxm.group.dao.GroupDAO;
import cn.edu.cust.eduxm.group.domain.Group;
import cn.edu.cust.eduxm.util.PageFactory;
import cn.edu.cust.util.MySqlPage;
import cn.edu.cust.util.Page;
import cn.edu.cust.util.action.CommonAction2;
import cn.edu.cust.util.db.JdbcTool;
import cn.edu.cust.util.db.Worker;
/**
 * 评审分组action
 * @author 陈华榕 *
 */
public class GroupAction extends CommonAction2{

	private static GroupDAO dao = new GroupDAO();
	
	private GroupInfoSearch search = new GroupInfoSearch();
	
	private ExpertInfoSearch expertSearch = new ExpertInfoSearch();
	
	private Group obj;
	
	private Page mlpage = PageFactory.getPage();
	
	private int page;
	
	int[] ids;
	//评审打分中的专家id
	private String user;
	
	//专家分组_专业领域
	private String groupField;
	
	private List<Group> rows;

	public String getGroupField() {
		return groupField;
	}


	public void setGroupField(String groupField) {
		this.groupField = groupField;
	}


	public Group getObj() {
		return obj;
	}


	public GroupInfoSearch getSearch() {
		return search;
	}


	public void setSearch(GroupInfoSearch search) {
		this.search = search;
	}


	public Page getMlpage() {
		return mlpage;
	}


	public void setMlpage(Page mlpage) {
		this.mlpage = mlpage;
	}


	public void setObj(Group obj) {
		this.obj = obj;
	}


	public int getPage() {
		return page;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public Group getGroup() {
		return obj;
	}


	public void setGroup(Group group) {
		this.obj = group;
	}

	public List<Group> getRows() {
		return rows;
	}


	public void setRows(int rows) {
		mlpage.setRecordNum(rows);
	}
	
	public int getTotal(){
		return mlpage.getRowCount();
	}
	
	public void setPage(int page) {
		mlpage.setPageNum(page);
	}
	
	
	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String list(){
		success = JSON_SUCCESS;
		error = JSON_ERROR;

		return work(new Worker() {
			public void doWork() {
				List<Object> params = null;
				String sql = null;

				sql = search.buildSQL();
				if(!(sql.indexOf(" order by ")>-1)){
					sql+=" order by c_zjz_id desc ";
				}
				log.info("sql: ----------{}", sql);
				params = search.getParams();

				log.info("params:-------------{}",
						Arrays.toString(params.toArray()));

				final ArrayList<Group> result = new ArrayList<Group>();

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
									Group group = new Group();
									group.setFields(rs);
									result.add(group);
									log.info("专家组名称:{}",group.getGroupName());
								}
								return null;
							}
						}, JdbcTool.getJdbcTemplate());

				rows = result;
			}
		});
	}
	
	
	/**
	 * 添加专家组
	 * id为自增长
	 * @return
	 */
	public String add() {
		successmsg = "添加成功";
		return work(new TransactionCallback<Object>() {

			public Object doInTransaction(TransactionStatus arg0) {
				//String user = ServletActionContext.getRequest().getRemoteUser();
				//obj.setAuthor(user);//自动给作者字段赋值（登录名）
			
				dao.insert(obj);
				// 创建每次会议资料文件夹
				//File file = getFilePath(obj);
				//file.mkdir();
				return null;
			}
		},"psfz");
	}
	
	public String load(){
		
		return work(new Worker() {
			
			@Override
			public void doWork() {
				// TODO Auto-generated method stub
				obj=dao.load(ids[0]);
				log.info("加载分组为：{}",obj.getGroupName());
			}
		},"psfz");
		
	}
	
	public String update(){
		successmsg = "修改成功";
		
		return work(new TransactionCallback<Group>() {

			@Override
			public Group doInTransaction(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				
				dao.update(obj);
				
				return null;
				
			}
			
		},"psfz");
		
	}
	/**
	 * 根据id删除专家分组
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
						dao.delete(new Object[] { ids[i] });
					}
				}
				return null;
			}
		},"psfz");
	}
	/**
	 * 评审打分中获得专家所在专家组的list方法
	 * @return
	 */
	public String pingshenList(){
		log.info(user+"-----------------");
		success = JSON_SUCCESS;
		error = JSON_ERROR;

		return work(new Worker() {
			public void doWork() {
				List<Object> params = null;
				String sql = null;

				sql = search.buildSQLToGroupList(user);
				log.info("sql: ----------{}", sql);
				params = search.getParams();

				log.info("params:-------------{}",
						Arrays.toString(params.toArray()));

				final ArrayList<Group> result = new ArrayList<Group>();

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
									Group group = new Group();
									group.setFields(rs);
									result.add(group);
									log.info("专家组名称:{}",group.getGroupName());
								}
								return null;
							}
						}, JdbcTool.getJdbcTemplate());

				rows = result;
			}
		});
	}
	
	
}
