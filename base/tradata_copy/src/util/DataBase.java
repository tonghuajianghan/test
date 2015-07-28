package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import vo.*;
public class DataBase {
	private Statement st;
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pst;
	private List<projectBean> dataList;
	private List<UserBean> userList;
	/**
	 * 
	 * @param tablename  所要查询的表名 achievement（结题等信息）
	 * @throws SQLException
	 */
	public DataBase() throws SQLException{
			try {
				Class.forName("net.sourceforge.jtds.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/kyc2","sa","123");
	            st = con.createStatement();  
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("出错");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
public List<projectBean> getDataList() {
	return dataList;
}

public void setDataList(List<projectBean> dataList) {
	this.dataList = dataList;
}
/**
 * 结题、鉴定、验收成员
 * @throws SQLException
 */
public void changeMCtoID() throws SQLException{
    String sql1="select id,cgmc from achievement";
	rs=this.st.executeQuery(sql1);
	dataList=new ArrayList<projectBean>();
	
	while(rs.next()){
		projectBean pb=new projectBean();
		pb.setXh((new Integer(rs.getInt(1))).intValue());
		pb.setProjectName(rs.getString(2));
		dataList.add(pb);
		}
	
	int n=this.dataList.size();
	for(int i=0;i<n;i++){
		String sql2="update critics set achieveId='"+this.dataList.get(i).getXh()+"' where temp='"+this.dataList.get(i).getProjectName()+"'";
		//this.pst=this.con.prepareStatement(sql);
		this.st.executeQuery(sql2);
	}
}
/**
 * 首先利用SQL语句将kyc中的数据转移到kyc2所对应的数据表中，表对应关系如下：
 *      kyc2           kyc
 *   jiangli
 *   zhuanli
 *   zhuzuo
 *   Paper
 *   learning
 * 
 * 奖励、专利等信息的转换，主要是成员中原来的项目名称改写为项目代号
 * @throws SQLException 
 * 
 */
public void changeZHtoID() throws SQLException{
    String sql1="select xh,lwtm from Paper";
	rs=this.st.executeQuery(sql1);
	dataList=new ArrayList<projectBean>();
	while(rs.next()){
		projectBean pb=new projectBean();
		pb.setXh((new Integer(rs.getInt(1))).intValue());
		pb.setProjectName(rs.getString(2));
		
		System.out.println("序号 ："+pb.getXh()+"  项目名称 :"+pb.getProjectName());
		dataList.add(pb);
		}
	
	int n=this.dataList.size();
	for(int i=0;i<n;i++){
		if(this.dataList.get(i).getProjectName().contains("\'"))
			{
			System.out.println(this.dataList.get(i).getProjectName());
			continue;
			}
		String sql2="update author set outId='"+this.dataList.get(i).getXh()+"' where tempstr='"+this.dataList.get(i).getProjectName()+"'";
		//this.pst=this.con.prepareStatement(sql);
		System.out.println(sql2);
		this.st.executeUpdate(sql2);
		//System.out.println(this.st.executeUpdate(sql2));
	}
}
/*
 * 将jiangli中的xh，cgmc导入author中
 * cgcm用作比较tempstr
 * xh代替outid
*/


public void changeJLtoID() throws SQLException{
    String sql1="select xh,cgmc from jiangli";
	rs=this.st.executeQuery(sql1);
	dataList=new ArrayList<projectBean>();
	while(rs.next()){
		projectBean pb=new projectBean();
		pb.setXh((new Integer(rs.getInt(1))).intValue());//将特殊值转换为普通值  , Xh 序号
		pb.setProjectName(rs.getString(2));
		
		System.out.println("序号 ："+pb.getXh()+"  项目名称 :"+pb.getProjectName());
		dataList.add(pb);
		}
	
	int n=this.dataList.size();
	for(int i=0;i<n;i++){
		if(this.dataList.get(i).getProjectName().contains("\'"))
			{
			System.out.println(this.dataList.get(i).getProjectName());
			continue;
			}
		String sql2="update author set outId='"+this.dataList.get(i).getXh()+"' where tempstr='"+this.dataList.get(i).getProjectName()+"'";
		//this.pst=this.con.prepareStatement(sql);
		System.out.println(sql2);
		this.st.executeUpdate(sql2);
		//System.out.println(this.st.executeUpdate(sql2));
	}
}

/**
 * 修改tablename表中的经手人和修改人，具体做法为先将数据将数据表中插入两个字段，分别为jsrm和xgrm，
 * 分别用来暂时保存经手人和修改人的姓名，等完成后直接执行下面的程序将jsr和xgr置为编号状态。
 * 不需要处理的数据表有:author \critics \Code \CodeType \Dir \dmindex \Employee \
 * OPERATOR \OperRec \ORG \PERMISSION \ROLE
 * 
 * @param tablename
 * @throws SQLException
 */
public void changeJsrAndXgr(String tablename) throws SQLException{
    String sql1="select id,name from Teacher";
	rs=this.st.executeQuery(sql1);
	userList=new ArrayList<UserBean>();
	
	while(rs.next()){
		UserBean pb=new UserBean();
		pb.setId((new Integer(rs.getInt(1))).intValue());
		pb.setName(rs.getString(2));
		
		System.out.println("序号 ："+pb.getId()+"  用户姓名 :"+pb.getName());
		userList.add(pb);
		}
	
	int n=this.userList.size();
	for(int i=0;i<n;i++){
		String sql2="update "+tablename+" set jsr='"+this.userList.get(i).getId()+"' where jsrm='"+this.userList.get(i).getName()+"'";
		//this.pst=this.con.prepareStatement(sql);
		//this.st.executeQuery(sql2);
		this.st.executeUpdate(sql2);
		String sql3="update "+tablename+" set xgr='"+this.userList.get(i).getId()+"' where xgrm='"+this.userList.get(i).getName()+"'";
		this.st.executeUpdate(sql3);
	}
}


/**
 * 关闭数据库相关连接
 */
public void close(){
	try {
		this.rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		this.st.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		this.con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	

}
