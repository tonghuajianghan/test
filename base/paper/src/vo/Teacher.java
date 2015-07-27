package vo;

public class Teacher {
	private int id;
	private String name;
	private String tpassword;
	private ROLE role_id;
	private ORG org_id;	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTpassword() {
		return tpassword;
	}

	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}

	public ROLE getRole_id() {
		return role_id;
	}

	public void setRole_id(ROLE role_id) {
		this.role_id = role_id;
	}

	public ORG getOrg_id() {
		return org_id;
	}

	public void setOrg_id(ORG org_id) {
		this.org_id = org_id;
	}
	

}
