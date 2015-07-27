package cn.edu.cust.eduxm.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import cn.edu.cust.eduxm.project.domain.Member;
import cn.edu.cust.util.db.DAOTemplate2;
/**
 * 项目成员情况DAO类
 * @author 王鹏程 2014-5-2
 *
 */
public class MemberDAO extends DAOTemplate2<Member>{

	public MemberDAO() {
		insertSQL = "insert into c_member values (?,?,?,?,?,?,?,?,?)";
		loadSQL = "select * from c_member where c_cy_id = ?";
		updateSQL = "update c_member set c_xm_id=?, c_xm=?,c_xb=?, c_csny=? ,c_zyzw=? ,c_yjzc=? ,c_xlxw=? ,c_dw=? where c_cy_id=?";
		getAllSQL = "select * from c_member";
		deleteSQL = "delete from c_member where c_cy_id = ? ";
	}

	@Override
	protected Member wrapResult(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Member member = new Member();
		member.setFields(rs);
		return member;
	}

	@Override
	protected void setIdBeforeInsert(Member t) {
		String getIdSQL = "select member_sque.nextval from dual";
		t.setId(jt.queryForInt(getIdSQL));
	}

	@Override
	protected Object[] getInsertParamValues(Member t) {
		return new Object[]{
				t.getId(),//自增长序列、、、、、、、、、、、、、
				t.getXm_id(),
				t.getXm(),
				t.getXb(),
				t.getCsny(),
				t.getZyzw(),
				t.getYjzc(),
				t.getXlxw(),
				t.getDw()
		};
	}

	@Override
	protected Object[] getUpdateParamValues(Member t) {
		return new Object[]{
				t.getXm_id(),
				t.getXm(),
				t.getXb(),
				t.getCsny(),
				t.getZyzw(),
				t.getYjzc(),
				t.getXlxw(),
				t.getDw()
		};
	}
	
	/**
	 * 
	 * @param xm_id 对应项目的id
	 * @return
	 */
	public ArrayList<Member> getAll(int xm_id) {
		System.out.println(xm_id+"----项目的id");
		String sql = "select *from c_Member where c_xm_id = ?";
		return jt.query(sql,new Object[]{xm_id}, new ResultSetExtractor<ArrayList<Member>>(){

			public ArrayList<Member> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				ArrayList<Member> result = new ArrayList<Member>();
				while(rs.next())
					result.add(wrapResult(rs));
				return result;
			}

		});
	}
}
