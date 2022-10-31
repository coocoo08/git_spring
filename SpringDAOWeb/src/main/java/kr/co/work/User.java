package kr.co.work;

import java.util.Date;
import java.util.Objects;

public class User {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date birth;
	private String sns;
	private Date Reg_date;
	
	
	public User() {
	}

	public User(String id, String pwd, String name, String email, Date birth, String sns, Date reg_date) {
		//super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.sns = sns;
		Reg_date = reg_date;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Reg_date, birth, email, id, name, pwd, sns, Reg_date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(Reg_date, other.Reg_date) && Objects.equals(birth, other.birth)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(pwd, other.pwd) && Objects.equals(sns, other.sns);
	}


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
