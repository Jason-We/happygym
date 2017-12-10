package entities;

public class P_group_role {
	
	private String groupno;
	
	private String name;
		
	private String idcard ;
	
	//private String phone;

	//leader,doctor,couch,judge
	private String role;
	
	//队名
	public String groupname;
	
	
	
	
	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setGroupno(String groupno) {
		this.groupno = groupno;
	}

	
	public String getGroupno() {
		return groupno;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

/*	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
*/
	
}
