package admin.dao;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import admin.model.Answer;
import admin.model.Exam;
import admin.model.Question;
import admin.model.QuestionType;
import admin.model.Student;
import admin.model.User;

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
	
	@Transactional
	public void saveUser(User user) {
		this.hibernateTemplate.saveOrUpdate(user);
	}
	
	public boolean searchEmail(String email) {
        boolean isValidUser = false;
		
		User user = new User();
	    user.setEmail(email);

	    List<User> existUserObj = this.hibernateTemplate.findByExample(user);
	    if(existUserObj != null && existUserObj.size() > 0){
	    	isValidUser = true;
	    }
	    return isValidUser;
    }
	
	public boolean searchUser(String email, String password) {
		boolean isValidUser = false;

		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		List<User> existUserObj = this.hibernateTemplate.findByExample(user);

		if(existUserObj != null && existUserObj.size() > 0)
		{
			isValidUser = true;
		}
		return isValidUser;
	}
	
	@Transactional
	public void updateUser(String email) {
		int id = 0;
		User findUser = new User();
	    findUser.setEmail(email);
	    
	    List<User> existUserObj = this.hibernateTemplate.findByExample(findUser);
	    for (User u : existUserObj) {
	    	id = u.getId();
		}
	    User user = this.hibernateTemplate.load(User.class, id);
	    user.setExamAttempt("true");
	    this.saveUser(user);
	}
	
	public boolean examAttempt(String email, String password) {
		boolean isExamAttempt = false;
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		List<User> existUserObj = this.hibernateTemplate.findByExample(user);

		if(existUserObj != null && existUserObj.size() > 0)
		{
			for (User u : existUserObj) {
				if(u.getExamAttempt()!= null && u.getExamAttempt().equals("true")) {
					isExamAttempt = true;
				}
			}
		}
		return isExamAttempt;
	}
}
