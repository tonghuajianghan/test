package cn.edu.cust.eduxm.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import cn.edu.cust.eduxm.project.domain.Member;
import cn.edu.cust.eduxm.project.domain.PrincipalProject;
import cn.edu.cust.util.db.DAOTemplate2;
/**
 * 项目负责人承担项目情况DAO类
 * @author 王鹏程 2014-5-2
 *
 */
public class PrincipalProjectDAO extends DAOTemplate2<PrincipalProject> {

	public PrincipalProjectDAO(){
		insertSQL = "insert into c_principalproject values (?,?,?,?,?,?,?,?,?)";
		loadSQL = "select * from c_principalproject where c_cdxm_id = ?";
		updateSQL = "update c_principalproject set c_xm_id=?, c_xmmc=?,c_xmlb=?, c_qzsj=? ,c_pzdw=? ,c_zzje=? ,c_ssxm=? where c_cdxm_id=?";
		getAllSQL = "select * from c_principalproject";
		deleteSQL = "delete from c_principalproject where c_cdxm_id = ? ";
	}

	@Override
	protected PrincipalProject wrapResult(ResultSet rs) throws SQLException {
		PrincipalProject principalproject = new PrincipalProject();
		principalproject.setFields(rs);
		return principalproject;
	}

	@Override
	protected void setIdBeforeInsert(PrincipalProject t) {
		String getIdSQL = "select principalproject_sque.nextval from dual";
		t.setId(jt.queryForInt(getIdSQL));
		
	}
	
	@Override
	protected Object[] getInsertParamValues(PrincipalProject t) {
		return new Object[]{
				t.getId(),
				t.getXmid(),
				t.getXmmc(),
				t.getXmlb(),
				t.getKssj(),
				t.getJssj(),
				t.getPzdw(),
				t.getZzje(),
				t.getSsxm()
		};
	}

	@Override
	protected Object[] getUpdateParamValues(PrincipalProject t) {
		return new Object[]{
				t.getXmid(),
				t.getXmmc(),
				t.getXmlb(),
				t.getKssj(),
				t.getJssj(),
				t.getPzdw(),
				t.getZzje(),
				t.getSsxm()
		};
	}
	/**
	 * 
	 * @param xm_id 对应项目的id
	 * @return
	 */
	public ArrayList<PrincipalProject> getAll(int xm_id) {
		String sql = "select *from c_PrincipalProject where c_xm_id = ?";
		return jt.query(sql,new Object[]{xm_id},new ResultSetExtractor<ArrayList<PrincipalProject>>(){

			public ArrayList<PrincipalProject> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				ArrayList<PrincipalProject> result = new ArrayList<PrincipalProject>();
				while(rs.next())
					result.add(wrapResult(rs));
				return result;
			}

		});
	}
}
