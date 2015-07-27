package cn.edu.cust.util.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public abstract class DAOTemplate2<T> {
	
	//protected abstract T newObj();
	protected JdbcTemplate jt = JdbcTool.getJdbcTemplate();
	
	protected abstract T wrapResult(ResultSet rs) throws SQLException;
	
	protected abstract void setIdBeforeInsert(T t);
	
	protected abstract Object[] getInsertParamValues(T t);
	
	protected abstract Object[] getUpdateParamValues(T t);
	
	//protected abstract void setParams4Load(PreparedStatement ps, T t) throws SQLException;
	//protected abstract void setParams4Delete(PreparedStatement ps, I t) throws SQLException;
	
	protected String insertSQL;
	protected String updateSQL;
	protected String loadSQL;
	protected String deleteSQL;
	protected String getAllSQL;
	
	public void insert(T t) {
		setIdBeforeInsert(t);
		jt.update(insertSQL, getInsertParamValues(t));
	}
	
	public void update(T t) {
		jt.update(updateSQL, getUpdateParamValues(t));
	}
	
	
	public ArrayList<T> getAll() {
		return jt.query(getAllSQL, new ResultSetExtractor<ArrayList<T>>(){

			public ArrayList<T> extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				ArrayList<T> result = new ArrayList<T>();
				while(rs.next())
					result.add(wrapResult(rs));
				return result;
			}

		});
	}
	
	public T load(Object i) {
		return load(new Object[]{i});
	}
	
	
	public T load(Object[] i) {
		return jt.query(loadSQL, i, new ResultSetExtractor<T>(){

			public T extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				// TODO Auto-generated method stub
				if(rs.next())
					return wrapResult(rs);
				return null;
			}

		});
	}
	
	public void delete(Object i){
		delete(new Object[]{i});
	}
	
	public void delete(Object[] i) {
		jt.update(deleteSQL, i);
	}

}
