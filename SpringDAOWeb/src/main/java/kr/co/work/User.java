package kr.co.work;

import java.util.Date;

public class User {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date birth;
	private String sns;
	private Date Reg_date;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date date) {
		this.birth = date;
	}
	public String getSns() {
		return sns;
	}
	public void setSns(String sns) {
		this.sns = sns;
	}
	
	public Date getReg_date() {
		return Reg_date;
	}
	public void setReg_date(Date reg_date) {
		Reg_date = reg_date;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", birth=" + birth + ", sns="
				+ sns + ", Reg_date=" + Reg_date + "]";
	}

	
	
	
}
