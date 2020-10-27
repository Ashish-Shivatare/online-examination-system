package admin.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin.dao.AdminDaoImpl;
import admin.model.Answer;
import admin.model.Question;
import admin.model.QuestionType;
import admin.model.Student;

@Service
public class DashboardService {

	@Autowired
	private AdminDaoImpl adminDaoImpl;
	
	public void createQuestionType(QuestionType questionType) {
		this.adminDaoImpl.saveQuestionType(questionType);
	}

	public List<QuestionType> getQuestionType() {
		return this.adminDaoImpl.getQuestionTypes();
	}
	
	public void deleteQuestionType(int questionId) {
		this.adminDaoImpl.deleteQuestionType(questionId);
	}
	
	public void createQuestion(Question question) {
		this.adminDaoImpl.saveQuestion(question);
	}
	
	public Question getQuestion(int id) {
		return this.adminDaoImpl.getQuestion(id);
	}
	
	public List<Question> getAllQuestion() {
		return this.adminDaoImpl.getQuestions();
	}
	
	public void deleteQuestion(int questionId) {
		this.adminDaoImpl.deleteQuestion(questionId);
	}

	public void addAnswer(Answer answer) {
		this.adminDaoImpl.saveAnswer(answer);
	}
	
	public void updateStudentDetails(Student student) {
		this.adminDaoImpl.updateStudent(student);
	}
	
	public Student getStudentDetails(int studentId) {
		return this.adminDaoImpl.getStudent(studentId);
	}
	
	public List<Answer> getAnswer() {
		return this.adminDaoImpl.getAllAnswer();
	}
}
