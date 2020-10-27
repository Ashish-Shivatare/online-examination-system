package admin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import admin.dao.AdminDaoImpl;
import admin.model.Exam;

@Service
public class ExamService {

	@Autowired
	private AdminDaoImpl adminDaoImpl;
	
	public List<Exam> getExam() {
		return this.adminDaoImpl.getAll();
	}
	
	public boolean getExamAttempt(String email, String password){
		return this.adminDaoImpl.examAttempt(email, password);
	}
	
	public void saveFinalSubmission() {
		this.adminDaoImpl.saveFinalStudent();
	}
}
