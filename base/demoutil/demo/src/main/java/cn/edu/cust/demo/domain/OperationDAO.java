package cn.edu.cust.demo.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import cn.edu.cust.util.db.DAOTemplate2;
import cn.edu.cust.util.db.LongGenerator;

public class OperationDAO extends DAOTemplate2<Operation> {
	
	public OperationDAO(){
		insertSQL = "insert into c_operation (c_id, c_src_id, c_des_id, c_money, c_date, c_type) values (?,?,?,?,?,?)";
	}
	
	@Override
	protected Object[] getInsertParamValues(Operation opt) {
		// TODO Auto-generated method stub
		return new Object[]{
				opt.getId(),
				opt.getSrc().getId(),
				opt.getDes().getId(),
				opt.getMoney(),
				new Timestamp(System.currentTimeMillis()),
				opt.getType()
		};
	}

	@Override
	protected Object[] getUpdateParamValues(Operation arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setIdBeforeInsert(Operation opt) {
		// TODO Auto-generated method stub
		opt.setId(lg.next(jt));
	}

	@Override
	protected Operation wrapResult(ResultSet arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	private static LongGenerator lg = new LongGenerator("c_operation","c_id");
	
	
	
	/**
	 * 还没考虑分页。。
	 * @param where 查询条件
	 * @param setter 组装PreparedStatement
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<?> search(String where, Object[] params) {
		return jt.query("select * from c_operation where " + where, params, new RowMapper<Object>(){

			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Operation opt = new Operation();
				opt.setId(rs.getLong("c_id"));
				Account acc = new Account();
				acc.setId(rs.getString("c_src_id"));
				opt.setSrc(acc);
				acc = new Account();
				acc.setId(rs.getString("c_des_id"));
				opt.setDes(acc);
				opt.setMoney(rs.getFloat("c_money"));
				opt.setDate(rs.getTimestamp("c_date"));
				opt.setType(rs.getInt("c_type"));
				return opt;
			}
			
		});
	}

}
