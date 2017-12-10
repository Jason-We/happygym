package entities;

public class P_group {
	
	//队编号
	public String groupno;
	
	public String getGroupno() {
		return groupno;
	}

	public void setGroupno(String groupno) {
		this.groupno = groupno;
	}

	//队名
	public String groupname;
	
	//账号
	private String account;
	
	//密码
	private String psw;

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}
	
}
