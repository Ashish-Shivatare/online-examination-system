package admin.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@DynamicUpdate
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String mobileNo;
	private String higherEducation;
	private String gender;
	private String dob;
	private String address;
	private String city;
	private String country;
	private String panCard;
	private String higherEducationCertificate;
	private String registrationDate;
	private String password;
	private String confirmPassword;
	private Boolean agree;
	private String examAttempt;
	
	@ElementCollection
	@OneToMany(cascade = CascadeType.ALL)
	private List<Answer> answer;

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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getHigherEducation() {
		return higherEducation;
	}

	public void setHigherEducation(String higherEducation) {
		this.higherEducation = higherEducation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getHigherEducationCertificate() {
		return higherEducationCertificate;
	}

	public void setHigherEducationCertificate(String higherEducationCertificate) {
		this.higherEducationCertificate = higherEducationCertificate;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public Student(int id, String name, String email, String mobileNo, String higherEducation, String gender,
			String dob, String address, String city, String country, String panCard, String higherEducationCertificate,
			String registrationDate, String password, String confirmPassword, Boolean agree, String examAttempt,
			List<Answer> answer) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.higherEducation = higherEducation;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.city = city;
		this.country = country;
		this.panCard = panCard;
		this.higherEducationCertificate = higherEducationCertificate;
		this.registrationDate = registrationDate;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.agree = agree;
		this.examAttempt = examAttempt;
		this.answer = answer;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo
				+ ", higherEducation=" + higherEducation + ", gender=" + gender + ", dob=" + dob + ", address="
				+ address + ", city=" + city + ", country=" + country + ", panCard=" + panCard
				+ ", higherEducationCertificate=" + higherEducationCertificate + ", registrationDate="
				+ registrationDate + ", password=" + password + ", confirmPassword=" + confirmPassword + ", agree="
				+ agree + ", examAttempt=" + examAttempt + ", answer=" + answer + "]";
	}

	
}
