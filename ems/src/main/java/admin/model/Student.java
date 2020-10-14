package admin.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
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
	
	public Student() {
		super();
	}
	
	public Student(int id, String name, String email, String mobileNo, String higherEducation, String gender, String dob,
			String address, String city, String country, String panCard, String higherEducationCertificate,
			String registrationDate) {
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
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo
				+ ", higherEducation=" + higherEducation + ", gender=" + gender + ", dob=" + dob + ", address="
				+ address + ", city=" + city + ", country=" + country + ", panCard=" + panCard
				+ ", higherEducationCertificate=" + higherEducationCertificate + ", registrationDate=" + registrationDate
				+ "]";
	}
}
