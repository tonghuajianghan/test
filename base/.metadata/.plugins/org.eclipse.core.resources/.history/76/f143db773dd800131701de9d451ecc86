package cn.edu.cust.eduxm.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.cust.eduxm.project.domain.Principal;
import cn.edu.cust.util.db.DAOTemplate2;
/**
 * 项目负责人DAO类
 * @author 王鹏程 2014-5-2
 *
 */
public class PrincipalDAO extends DAOTemplate2<Principal> {
	public PrincipalDAO(){
		insertSQL = "insert into c_principal values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		loadSQL = "select * from c_principal where c_fzr_id = ?";
		updateSQL = "update c_principal set c_fzrxm=?, c_xb=?,c_mz=?, c_csny=? ,c_xzzw=? ,c_ywzw=? ,c_yjzc=? ,c_zhxl=?,c_zhxw=?,c_drds=?,c_gzdw=?,c_lxdh=?,c_txdz=?,c_yb=?,c_sfdrqtxm=? where c_fzr_id=?";
		getAllSQL = "select * from c_principal";
		deleteSQL = "delete from c_principal where c_fzr_id = ? ";
	}

	@Override
	protected Principal wrapResult(ResultSet rs) throws SQLException {
		Principal principal = new Principal();
		principal.setFields(rs);
		return principal;
	}

	@Override
	protected void setIdBeforeInsert(Principal t) {
		//改为用项目表的id值作为负责人表的id，，，即两者id相同来达到一对一的关联
	}
	
	@Override
	protected Object[] getInsertParamValues(Principal t) {
		return new Object[]{
/*				t,//自增长序列
*/				t.getId(),
				t.getFzrxm(),
				t.getXb(),
				t.getMz(),
				t.getCsny(),
				t.getXzzw(),
				t.getYwzw(),
				t.getYjzc(),
				t.getZhxl(),
				t.getZhxw(),
				t.getDrds(),
				t.getGzdw(),
				t.getLxdh(),
				t.getTxdz(),
				t.getYb(),
				t.getSfdrqtxm()
		};
	}

	@Override
	protected Object[] getUpdateParamValues(Principal t) {
		return new Object[]{
				t.getFzrxm(),
				t.getXb(),
				t.getMz(),
				t.getCsny(),
				t.getXzzw(),
				t.getYwzw(),
				t.getYjzc(),
				t.getZhxl(),
				t.getZhxw(),
				t.getDrds(),
				t.getGzdw(),
				t.getLxdh(),
				t.getTxdz(),
				t.getYb(),
				t.getSfdrqtxm()
		};
	}

}
