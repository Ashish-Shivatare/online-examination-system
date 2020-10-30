package admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import admin.dao.AdminDaoImpl;

@Service
public class ExamService {

	@Autowired
	private AdminDaoImpl adminDaoImpl;

	public boolean getExamAttempt(String email, String password){
		return this.adminDaoImpl.examAttempt(email, password);
	}
	
	public void saveFinalSubmission() {
		this.adminDaoImpl.saveFinalStudent();
	}
}
