package cn.edu.cust.eduxm.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.cust.eduxm.project.domain.Project;
import cn.edu.cust.util.db.DAOTemplate2;

public class ProjectDAO extends DAOTemplate2<Project> {
	
	public ProjectDAO(){
		insertSQL = "insert into c_project values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		loadSQL = "select * from c_project where c_xm_id = ?";
		updateSQL = "update c_project set c_zt=? ,c_xmnbbh_id=? ,c_xmmc=? " +
				",c_sqnd=?,c_cgxs=?, c_kssj=?,c_jssj=?, c_jhwcsj=? ,c_xmlb=? ,c_yjlx=? ,c_xkmc=?,c_xkdm=?" +
				",c_tbsj=?,c_ysze=?, c_zjz_id = ? , c_xyh_id" + 
				",c_sqze=?,c_sqmx=?, c_zcze=?,c_zcmx=?, c_sqcn=? ,c_xswyhyj=? ,c_fzrdwyj=? ,c_sjzt1=?,c_psfs=?" +
				",c_psjg=?,c_jgsm=?, c_sjzt2=?,c_tbr=?, c_bz1=? ,c_bz2=? ,c_bz3=? ,c_bz4=? where c_xm_id=?";
		getAllSQL = "select * from c_project";
		deleteSQL = "delete from c_project where c_xm_id = ? ";
	}

	@Override
	protected Project wrapResult(ResultSet rs) throws SQLException {
		Project project = new Project();
		project.setFields(rs);
		return project;
	}

	@Override
	protected void setIdBeforeInsert(Project t) {
		String getIdSQL = "select project_sque.nextval from dual";
		t.setXm_id(jt.queryForInt(getIdSQL));
	}
	
	@Override
	protected Object[] getInsertParamValues(Project t) {
		return new Object[]{
				t.getXm_id(),//自增长序列
				t.getZjz_id(),
				t.getYjbh_id(),
				t.getZt(),
				t.getXmnbbh_id(),
				t.getXmmc(),
				t.getSqnd(),
				t.getCgxs(),
				t.getKssj(),
				t.getJssj(),
				t.getJhwcsj(),
				t.getXmlb(),
				t.getYjlx(),
				t.getXkmc(),
				t.getXkdm(),
				t.getTbsj(),
				//t.getYyxzqs(),
				//t.getYjnr(),
				//t.getYjff(),
				//t.getJctj(),
				//t.getJdcg(),
				//t.getKttj(),
				//t.getCgyyyc(),
				t.getYsze(),
				t.getSqze(),
				t.getSqmx(),
				t.getZcze(),
				t.getZcmx(),
				t.getSqcn(),
				t.getXswyhyj(),
				t.getFzrdwyj(),
				t.getSjzt1(),
				t.getPsfs(),
				t.getPsjg(),
				t.getJgsm(),
				t.getSjzt2(),
				t.getTbr(),
				t.getBz1(),
				t.getBz2(),
				t.getBz3(),
				t.getBz4(),
				t.getFs(),
				t.getOrgcode()
		};
	}

	@Override
	protected Object[] getUpdateParamValues(Project t) {
		return new Object[]{
				t.getZt(),
				t.getXmnbbh_id(),
				t.getXmmc(),
				t.getSqnd(),
				t.getCgxs(),
				t.getKssj(),
				t.getJssj(),
				t.getJhwcsj(),
				t.getXmlb(),
				t.getYjlx(),
				t.getXkmc(),
				t.getXkdm(),
				t.getTbsj(),
				//t.getYyxzqs(),
				//t.getYjnr(),
				//t.getYjff(),
				//t.getJctj(),
				//t.getJdcg(),
				//t.getKttj(),
				//t.getCgyyyc(),
				t.getYsze(),
				t.getSqze(),
				t.getSqmx(),
				t.getZcze(),
				t.getZcmx(),
				t.getSqcn(),
				t.getXswyhyj(),
				t.getFzrdwyj(),
				t.getSjzt1(),
				t.getPsfs(),
				t.getPsjg(),
				t.getJgsm(),
				t.getSjzt2(),
				t.getTbr(),
				t.getBz1(),
				t.getBz2(),
				t.getBz3(),
				t.getBz4(),
				t.getFs(),
				t.getOrgcode()
				
		};
	}
	/**
	 * 更新project的状态
	 * @param projectid project的id
	 * @param zt   project要更改的状态
	 */
	public void updateZt(int projectid,String zt){
		String sql = "update c_project set c_zt = ? where c_xm_id = ?";
		jt.update(sql,zt,projectid);
	}
	//更新最终的状态。。把b0或则c0改为b1或则c1    更具项目的id来更改
	public void updateFinally(int projectid){
		String sql = "update c_project set c_zt = REPLACE(c_zt, substr(c_zt,1,1), '1') where c_xm_id = ?";
		jt.update(sql,projectid);
	}
	public void updateFinally(String zt){
		zt += "%";//变成 c0%或则 b0%
		String sql = "update c_project set c_zt = REPLACE(c_zt, substr(c_zt,1,1), '1') where c_zt like ?";
		jt.update(sql,zt);
	}
	//打完分后更新项目中的分数
	public void updateScore(float score,int id){
		String sql = "update c_project set c_psfs = ? where c_xm_id = ?";
		jt.update(sql,new Object[]{score,id});
		
	}
}
