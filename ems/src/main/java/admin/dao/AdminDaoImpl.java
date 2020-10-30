package admin.dao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import admin.model.Answer;
import admin.model.Question;
import admin.model.QuestionType;
import admin.model.Student;
import admin.model.StudentAnswer;

@Repository
@Transactional
public class AdminDaoImpl {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	Student st = new Student();
	ArrayList<Answer> list1 = new ArrayList<Answer>();
	private int checkId = 0;

	public void saveQuestion(Question question) {
		this.hibernateTemplate.saveOrUpdate(question);
	}

	public void deleteQuestion(int id) {
		Question question = this.hibernateTemplate.load(Question.class, id);
		this.hibernateTemplate.delete(question);
	}

	public void saveQuestionType(QuestionType questionType) {
		this.hibernateTemplate.saveOrUpdate(questionType);
	}

	public List<QuestionType> getQuestionTypes() {
		List<QuestionType> list = new ArrayList<QuestionType>();  
		list = this.hibernateTemplate.loadAll(QuestionType.class);
		return list;
	}

	public void deleteQuestionType(int id) {
		QuestionType questionType = this.hibernateTemplate.load(QuestionType.class, id);
		this.hibernateTemplate.delete(questionType);
	}

	public List<Student> getStudentInformation() {
		List<Student> studentList = new ArrayList<Student>();  
		studentList = this.hibernateTemplate.loadAll(Student.class);
		return studentList;
	}

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

	public void saveAnswer(Answer answer) {
		list1.add(answer);
	}

	public void saveFinalStudent() {
		if(st.getEmail() != null) {
			st.setAnswer(list1);
			this.saveStudent(st);
		}
	}

	public List<Answer> getAllAnswer() {
		Student st1 = this.hibernateTemplate.load(Student.class, checkId);
		List<Answer> list=new ArrayList<Answer>();  
		list.addAll(st1.getAnswer());
		return list;
	}

	public void saveStudent(Student student) {
		this.hibernateTemplate.saveOrUpdate(student);
	}

	public boolean searchEmail(String email) {
		boolean isValidUser = false;

		Student student = new Student();
		student.setEmail(email);

		List<Student> existUserObj = this.hibernateTemplate.findByExample(student);
		if(existUserObj != null && existUserObj.size() > 0){
			isValidUser = true;
		}
		return isValidUser;
	}

	public boolean searchUser(String email, String password) {
		boolean isValidUser = false;

		Student student = new Student();
		student.setEmail(email);
		student.setPassword(password);

		List<Student> existUserObj = this.hibernateTemplate.findByExample(student);
		for (Student s : existUserObj) {
			checkId = s.getId();
		}
		list1.clear();
		if(existUserObj != null && existUserObj.size() > 0)
		{
			isValidUser = true;
		}
		return isValidUser;
	}

	public void updateUser(String email) {
		Student student = this.hibernateTemplate.load(Student.class, checkId);
		LocalDate date = LocalDate.now();
		student.setExamDate(date.toString());
		student.setExamAttempt("true");
		st = student;
		this.saveStudent(student);
	}

	public boolean examAttempt(String email, String password) {
		boolean isExamAttempt = false;
		Student student = new Student();
		student.setEmail(email);
		student.setPassword(password);

		List<Student> existUserObj = this.hibernateTemplate.findByExample(student);

		if(existUserObj != null && existUserObj.size() > 0)
		{
			for (Student u : existUserObj) {
				if(u.getExamAttempt()!= null && u.getExamAttempt().equals("true")) {
					isExamAttempt = true;
				}
			}
		}
		return isExamAttempt;
	}
	
	public void studentAnswers(StudentAnswer studentAnswer) {
		studentAnswer.setStudentId(checkId);
		studentAnswer.setStudentName(st.getName());
		studentAnswer.setStudentEmail(st.getEmail());
		studentAnswer.setStudentMobileNo(st.getMobileNo());
		studentAnswer.setDate(st.getExamDate());
		this.hibernateTemplate.save(studentAnswer);
	}
	
	public List<StudentAnswer> getAllStudentAnswer(){
		List<StudentAnswer> answerList = new ArrayList<StudentAnswer>(); 
		answerList = this.hibernateTemplate.loadAll(StudentAnswer.class);
		return answerList;
	}
}
