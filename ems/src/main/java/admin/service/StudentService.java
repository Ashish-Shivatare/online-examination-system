package admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin.dao.AdminDaoImpl;
import admin.model.Student;
import admin.model.StudentAnswer;

@Service
public class StudentService {

	@Autowired
	private AdminDaoImpl adminDaoImpl;
	
	public void createStudent(Student student) {
		System.out.println(student);
		this.adminDaoImpl.saveStudent(student);
	}
	
	public List<Student> getStudent() {
		return this.adminDaoImpl.getStudentInformation();
	}
	
	public void saveStudentAnswers(StudentAnswer studentAnswer) {
		this.adminDaoImpl.studentAnswers(studentAnswer);
	}
	
	public List<StudentAnswer> getStudentAnswers(){
		return this.adminDaoImpl.getAllStudentAnswer();
	}
	
	public boolean findEmail(String email){
		return this.adminDaoImpl.searchEmail(email);
	}
	
	public boolean studentLogin(String email, String password){
		return this.adminDaoImpl.searchUser(email, password);
	}

	public void updateUserDetails(String email) {
		this.adminDaoImpl.updateUser(email);
	}
	
}
