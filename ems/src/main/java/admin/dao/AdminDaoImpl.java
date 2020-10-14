package admin.dao;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import admin.model.Answer;
import admin.model.Exam;
import admin.model.Question;
import admin.model.QuestionType;
import admin.model.Student;

@Repository
public class AdminDaoImpl {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<Exam> getAll() {
		List<Exam> list=new ArrayList<Exam>();  
		list = this.hibernateTemplate.loadAll(Exam.class);
		return list;
	}
	
	@Transactional
	public int saveQuestion(Question question) {
		int id = (Integer) this.hibernateTemplate.save(question);
		return id;
	}
	
	@Transactional
	public int saveQuestionType(QuestionType questionType) {
		int id = (Integer) this.hibernateTemplate.save(questionType);
		return id;
	}
	
	public List<QuestionType> getQuestionTypes() {
		List<QuestionType> list = new ArrayList<QuestionType>();  
		list = this.hibernateTemplate.loadAll(QuestionType.class);
		return list;
	}
	
	public List<Student> getStudentInformation() {
		List<Student> studentList = new ArrayList<Student>();  
		studentList = this.hibernateTemplate.loadAll(Student.class);
		return studentList;
	}
	
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	public Student getStudent(int studentId) {
		return this.hibernateTemplate.get(Student.class, studentId);
	}
	
	public List<Question> getQuestions() {
		List<Question> allQuestionList = new ArrayList<Question>();
		allQuestionList = this.hibernateTemplate.loadAll(Question.class);
		return allQuestionList;
	}
	
	public Question getQuestion(int id) {
		Question que = this.hibernateTemplate.get(Question.class, id);
		return que;
	}
	
	@Transactional
	public void saveAnswer(Answer answer) {
		this.hibernateTemplate.saveOrUpdate(answer);
	}
	
	public List<Answer> getAllAnswer() {
		List<Answer> list=new ArrayList<Answer>();  
		list = this.hibernateTemplate.loadAll(Answer.class);
		return list;
	}
}
