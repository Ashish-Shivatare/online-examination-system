package admin.model;

import javax.persistence.Entity;

@Entity
public class StudentLogin {
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public StudentLogin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public StudentLogin() {
		super();
	}
	
	@Override
	public String toString() {
		return "StudentLogin [email=" + email + ", password=" + password + "]";
	}
	
}
