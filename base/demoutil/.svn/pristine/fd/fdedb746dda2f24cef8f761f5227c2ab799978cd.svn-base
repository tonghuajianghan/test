package cn.edu.cust.demo.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Operation {
	
	private long id;
	
	private Account src;
	
	private Account des;
	
	private float money;
	
	private Date date;
	
	private int type;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Account getSrc() {
		return src;
	}

	public void setSrc(Account src) {
		this.src = src;
	}
	
	public Account getDes() {
		return des;
	}

	public void setDes(Account des) {
		this.des = des;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}
	public String getDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
		
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public void setFields(ResultSet rs) throws SQLException {
		id=rs.getLong("c_id");
		//src=rs.get;
		//des=r;
		money=rs.getFloat("c_money");
		date=rs.getTimestamp("c_date");
		type=rs.getInt("c_type");
		//opt.setId();
		//Account acc = new Account();
		src=new Account();
		src.setId(rs.getString("c_src_id"));
		//opt.setSrc(acc);
		//acc = new Account();
		des=new Account();
		des.setId(rs.getString("c_des_id"));
	}

}
