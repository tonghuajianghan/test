package cn.edu.cust.eduxm.expert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.cust.eduxm.expert.dao.ExpertDAO;
import cn.edu.cust.eduxm.expert.domain.Expert;
import cn.edu.cust.eduxm.project.domain.Project;
import cn.edu.cust.eduxm.util.PageFactory;
import cn.edu.cust.rbac.dao.UserDAO;
import cn.edu.cust.rbac.domain.User;
import cn.edu.cust.util.Page;
import cn.edu.cust.util.action.CommonAction2;
import cn.edu.cust.util.db.JdbcTool;
import cn.edu.cust.util.db.Worker;

public class ExpertAction extends CommonAction2 {

	private static ExpertDAO dao = new ExpertDAO();

	private static UserDAO udao = new UserDAO();

	private ExpertInfoSearch search = new ExpertInfoSearch();

	private Expert obj;

	private User u;

	private Page mlpage = PageFactory.getPage();

	private int page;

	private List<Expert> experts;

	private String[] usernames;

	private String zt;

	public String getZt() {
		return zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	private File file;

	private String fileContentType;

	private String fileFileName;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	/*
	 * private String username;
	 * 
	 * 
	 * public String getUsername() { return username; }
	 * 
	 * public void setUsername(String username) { this.username = username; }
	 */

	public String[] getUsername() {
		return usernames;
	}

	public void setUsernames(String[] usernames) {
		this.usernames = usernames;
	}

	public List<Expert> getExperts() {
		return experts;
	}

	public void setExperts(List<Expert> experts) {
		this.experts = experts;
	}

	public void setRows(int rows) {
		mlpage.setRecordNum(rows);
	}

	public List<Expert> getRows() {
		return experts;
	}

	public int getTotal() {
		return mlpage.getRowCount();
	}

	public static ExpertDAO getDao() {
		return dao;
	}

	public static void setDao(ExpertDAO dao) {
		ExpertAction.dao = dao;
	}

	public ExpertInfoSearch getSearch() {
		return search;
	}

	public void setSearch(ExpertInfoSearch search) {
		this.search = search;
	}

	public Expert getObj() {
		return obj;
	}

	public void setObj(Expert obj) {
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

	public String list() {
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

				final ArrayList<Expert> result = new ArrayList<Expert>();

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
									Expert expert = new Expert();
									expert.setFields(rs);
									result.add(expert);
									// log.info("x", expert.getXm());
									// log.info("专家用户名:{}",expert.getUsername());
								}
								return null;
							}
						}, JdbcTool.getJdbcTemplate());

				experts = result;
			}
		});
	}

	public String add() {
		// System.out.println("hello");
	
		u = new User();
		u.setUsername(obj.getUsername());
		u.setPassword(obj.getUsername().substring(12));
		u.setRoles("zhuanjia");
		successmsg = "添加成功";
		log.info("file{}", fileFileName);
		return work(new TransactionCallback<Object>() {

			public Object doInTransaction(TransactionStatus arg0) {
				// String user =
				// ServletActionContext.getRequest().getRemoteUser();
				// obj.setAuthor(user);//自动给作者字段赋值（登录名）
				if(dao.load(obj.getUsername())!=null){
					successmsg = "用户名已存在";
				}else{
					dao.insert(obj);
					udao.insert(u);
				}
				if(file!=null){
				// log.info("file{}",fileFileName);
					JdbcTool.getJdbcTemplate()
						.update("update c_expert  set c_photo = ?,c_photo_content_type = ? where C_USERNAME =?",
								new PreparedStatementSetter() {

									public void setValues(PreparedStatement ps)
											throws SQLException {
										try {
											ps.setBinaryStream(1,
													new FileInputStream(file),
													(int) file.length());
											ps.setString(2, fileContentType);
											ps.setString(3, obj.getUsername());
											// 设置设置点此调回到上传照片页面

											// successurl =
											// "../../expert/self/add.jsp";
										} catch (FileNotFoundException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								});
			
				// upload();
				}
				return null;
			}

		});
 
	}

	public String update() {
		
		successmsg = "修改成功";
		
		return work(new TransactionCallback<Object>() {

			public Object doInTransaction(TransactionStatus arg0) {
			    obj.setZt("0");
				dao.update(obj);
				if(file!=null && fileContentType!=null){
				JdbcTool.getJdbcTemplate()
				.update("update c_expert  set c_photo = ?,c_photo_content_type = ? where C_USERNAME =?",
						new PreparedStatementSetter() {

							public void setValues(PreparedStatement ps)
									throws SQLException {
								try {
									ps.setBinaryStream(1,
											new FileInputStream(file),
											(int) file.length());
									ps.setString(2, fileContentType);
									ps.setString(3, obj.getUsername());
									// 设置设置点此调回到上传照片页面

									// successurl =
									// "../../expert/self/add.jsp";
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});
				}
				return null;
			}
		});
		
	}

	public String load() {

		return work(new Worker() {

			@Override
			public void doWork() {
				// TODO Auto-generated method stub
				log.info("加载专家详细信息{}", usernames[0]);
				obj = dao.load(usernames[0]);

				// obj=dao.load(obj);
				// log.info("加载分组为：{}",obj.getUsername());

				 log.info("{}",obj.toString());
			}
		});

	}

	public String download() {

		work(new Worker() {

			public void doWork() {

				ActionContext context = ActionContext.getContext();
				final HttpServletResponse response = (HttpServletResponse) context
						.get(ServletActionContext.HTTP_RESPONSE);
				
                 
				JdbcTool.getJdbcTemplate().query(
						"select c_photo , c_photo_content_type from c_expert where C_USERNAME = ?"
								,new Object[]{usernames[0]},
						new ResultSetExtractor<Object>() {
							public Object extractData(ResultSet res)
									throws SQLException, DataAccessException {
								while (res.next()) {
									response.reset();
									Blob img = res.getBlob("c_photo");
									String pct = res
											.getString("c_photo_content_type");
									response.setContentType(pct);
									try {
										InputStream is = null;
										if (pct == null || pct.equals("")) {
											File photo = new File(
													ServletActionContext
															.getServletContext()
															.getRealPath(
																	"/images/stuphoto.png"));
											is = new FileInputStream(photo);
										} else {
											is = img.getBinaryStream();
										}

										OutputStream os = response
												.getOutputStream();
										byte[] tm = new byte[1024];
										int n = -1;
										while ((n = is.read(tm)) != -1) {
											os.write(tm, 0, n);
										}
										is.close();
										os.flush();
										// res.close();
										os.close();
									} catch (IOException e) {

										e.printStackTrace();
									}
								}
								// res.close();
								return null;
							}
						});

			}
		});
		return null;

	}

	public String delete() {
		successmsg = "删除成功";

		return work(new Worker() {
			@Override
			public void doWork() {

				// log.info("{}",obj);
				// log.info("{}",username);
				// TODO Auto-generated method stub
				// dao.delete(ids[0]);
				// if (ids != null) {
				for (int i = usernames.length - 1; i >= 0; i--) {
					// log.info("{}",ids[i]);
					dao.delete(usernames[i]);
					udao.delete(usernames[i]);
				}
				// }
			}
		});

	}

	public String changeZt() {
		success = JSON_SUCCESS;
		error = JSON_ERROR;
		errormsg = "操作失败";
		return work(new TransactionCallback<Project>() {
			@Override
			public Project doInTransaction(TransactionStatus arg0) {
				log.info("评审专家信息:{}", usernames[0] + zt);
				dao.changeZt(usernames[0], zt);
				return null;
			}
		});
	}

}