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
import cn.edu.cust.eduxm.group.dao.AssignExpertDAO;
import cn.edu.cust.eduxm.group.domain.AssignExpert;
import cn.edu.cust.eduxm.group.domain.Group;
import cn.edu.cust.eduxm.util.PageFactory;
import cn.edu.cust.util.MySqlPage;
import cn.edu.cust.util.Page;
import cn.edu.cust.util.action.CommonAction2;
import cn.edu.cust.util.db.JdbcTool;
import cn.edu.cust.util.db.Worker;

public class AssignExpertAction extends CommonAction2{
	
	private static AssignExpertDAO dao = new AssignExpertDAO();
	
	//private GroupInfoSearch search = new GroupInfoSearch();
	
	private ExpertInfoSearch expertSearch = new ExpertInfoSearch();
	
	private Expert obj;
	
	private int groupId;
	
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


	private String type;
	
	public ExpertInfoSearch getExpertSearch() {
		return expertSearch;
	}


	public void setExpertSearch(ExpertInfoSearch expertSearch) {
		this.expertSearch = expertSearch;
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


	public void setRows(List<Expert> rows) {
		this.rows = rows;
	}


	private Page mlpage = PageFactory.getPage();
	
	private int page;
	
	String[] ids;
	
	//专家分组_专业领域
	private String groupField;
	
	private List<Expert> rows;

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

	public List<Expert> getRows() {
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
				
				if (mlpage == null) {
					mlpage = new MySqlPage();
				}
				mlpage.setPageNum(page);
				log.info("专家们ids的长度：{}",ids.length);
				if (ids != null) {
					for (int i = ids.length - 1; i >= 0; i--) {
						AssignExpert assignExpert = new AssignExpert();
						assignExpert.setExpertId(ids[i]);
						assignExpert.setTeamId(groupId);
						log.info("专家ids:{},专家组id:{}",ids[i],groupId);
						dao.insert(assignExpert);
						//修改分组表中专家人数
						dao.addGroupManCount(groupId);
					}
				}
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
						dao.delete(new Object[] { ids[i],groupId });
						dao.delGroupProjectCount(groupId);
					}
				}
				return null;
			}
		},"psfz");
	}
	
	
	public String list(){
		success = JSON_SUCCESS;
		error = JSON_ERROR;

		return work(new Worker() {
			public void doWork() {
				List<Object> params = null;
				String sql = null;
				String inOrNotIn="";
				log.info("type:{}",type);
				if(type.equals("1")){
					inOrNotIn="not in";
				}else{
					inOrNotIn="in";
				}
				//sql:select * from C_EXPERT where C_USERNAME in(select c_zj_id from c_group_expert where c_zjz_id='32');
				sql = expertSearch.buildSQL(" C_ZYLY='"+groupField+"' and "+"C_USERNAME "+inOrNotIn+"(select c_zj_id from c_group_expert where c_zjz_id='"+groupId+"')");//bubuildSQLToGroup(groupField,groupId,type);
					
				log.info("sql: ----------{},groupField:--{}", sql,groupField);
				params = expertSearch.getParams();
				
				log.info("params:-------------{}",
						Arrays.toString(params.toArray()));

				final ArrayList<Expert> result = new ArrayList<Expert>();

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
									Expert expert = new Expert();
									expert.setFields(rs);
									result.add(expert);
									log.info("专家组名称:{}",expert.getUsername());
								}
								return null;
							}
						}, JdbcTool.getJdbcTemplate());

				 rows = result;
			}
		});
	}
	

}
