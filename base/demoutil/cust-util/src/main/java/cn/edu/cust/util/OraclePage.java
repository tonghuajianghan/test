package cn.edu.cust.util;

/**
 * 

    SELECT *
      FROM (SELECT ROW_.*, ROWNUM ROWNUM_
              FROM (SELECT *
                      FROM TABLE1
                     WHERE TABLE1_ID = XX
                     ORDER BY GMT_CREATE DESC) ROW_
             WHERE ROWNUM <= 20)
     WHERE ROWNUM_ >= 10;
 * @author wj
 *
 */
public class OraclePage extends Page {

	@Override
	public String getLimitString(String sql) {
		// TODO Auto-generated method stub
		StringBuffer sqlbuf = new StringBuffer();
		sqlbuf.append("select * from (select ROW_.*, ROWNUM ROWNUM_ from(");
		sqlbuf.append(sql);
		sqlbuf.append(") ROW_ where ROWNUM <= ");
		sqlbuf.append(getLimit());
		sqlbuf.append(") where ROWNUM_ >= ");
		sqlbuf.append(getOffset() + 1);
		return sqlbuf.toString();
	}

}
