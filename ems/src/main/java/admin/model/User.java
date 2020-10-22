package admin.model;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; 
import javax.persistence.Id;

@Entity 
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;
	private String name; 
	private String email; 
	private String password; 
	private String confirmPassword; 
	private Boolean agree; 
	private String examAttempt;

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
		this.password =	password; 
	}
	public String getConfirmPassword() { 
		return confirmPassword; 
	}
	public void setConfirmPassword(String confirmPassword) { 
		this.confirmPassword = confirmPassword; 
	} 
	public Boolean getAgree() { 
		return agree; 
	} 
	public void setAgree(Boolean agree) { 
		this.agree = agree; 
	} 
	public String getExamAttempt() { 
		return examAttempt; 
	} 
	public void setExamAttempt(String examAttempt) { 
		this.examAttempt = examAttempt; 
	} 
	
	public User(int id, String name, String email, String password, String confirmPassword, Boolean agree, String examAttempt) { 
		super(); 
		this.id = id;
		this.name = name; 
		this.email = email; 
		this.password = password; 
		this.confirmPassword = confirmPassword;
		this.agree = agree; 
		this.examAttempt = examAttempt; 
	} 
	
	public User() {						
		super(); 
	}

	@Override public String toString() { 
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword + ", agree=" + agree + ", examAttempt=" + examAttempt + "]";
	}
}
