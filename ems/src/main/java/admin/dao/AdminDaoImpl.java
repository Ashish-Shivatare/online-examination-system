package admin.dao;
import java.util.ArrayList;
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
	
	Student st = new Student();
	ArrayList<Answer> list1 = new ArrayList<Answer>();
	int checkId;

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

	//	@Transactional
	//	public void saveAnswer(Answer answer) {
	//		this.hibernateTemplate.saveOrUpdate(answer);
	//	}

	@Transactional
	public void saveAnswer(Answer answer) {
		list1.add(answer);
	}

	@Transactional
	public void saveFinalStudent() {
		System.out.println(list1+ " This is list "+ checkId);
		if(st.getEmail() != null) {
			st.setAnswer(list1);
			this.saveStudent(st);
		}
	}

	public List<Answer> getAllAnswer() {
		Student st1 = this.hibernateTemplate.load(Student.class, checkId);
		//System.out.println(st1 + "  Get all answers");
		List<Answer> list=new ArrayList<Answer>();  
		list.addAll(st1.getAnswer());
		return list;
	}

	//	public List<Answer> getAllAnswer() {
	//		List<Answer> list=new ArrayList<Answer>();  
	//		list = this.hibernateTemplate.loadAll(Answer.class);
	//		return list;
	//	}

	//	@Transactional
	//	public void saveUser(User user) {
	//		this.hibernateTemplate.saveOrUpdate(user);
	//	}

	//	public boolean searchEmail(String email) {
	//        boolean isValidUser = false;
	//		
	//		User user = new User();
	//	    user.setEmail(email);
	//
	//	    List<User> existUserObj = this.hibernateTemplate.findByExample(user);
	//	    if(existUserObj != null && existUserObj.size() > 0){
	//	    	isValidUser = true;
	//	    }
	//	    return isValidUser;
	//    }
	//	
	//	public boolean searchUser(String email, String password) {
	//		boolean isValidUser = false;
	//
	//		User user = new User();
	//		user.setEmail(email);
	//		user.setPassword(password);
	//
	//		List<User> existUserObj = this.hibernateTemplate.findByExample(user);
	//
	//		if(existUserObj != null && existUserObj.size() > 0)
	//		{
	//			isValidUser = true;
	//		}
	//		return isValidUser;
	//	}
	//	
	//	@Transactional
	//	public void updateUser(String email) {
	//		int id = 0;
	//		User findUser = new User();
	//	    findUser.setEmail(email);
	//	    
	//	    List<User> existUserObj = this.hibernateTemplate.findByExample(findUser);
	//	    for (User u : existUserObj) {
	//	    	id = u.getId();
	//		}
	//	    User user = this.hibernateTemplate.load(User.class, id);
	//	    user.setExamAttempt("true");
	//	    this.saveUser(user);
	//	}
	//	
	//	public boolean examAttempt(String email, String password) {
	//		boolean isExamAttempt = false;
	//		
	//		User user = new User();
	//		user.setEmail(email);
	//		user.setPassword(password);
	//
	//		List<User> existUserObj = this.hibernateTemplate.findByExample(user);
	//
	//		if(existUserObj != null && existUserObj.size() > 0)
	//		{
	//			for (User u : existUserObj) {
	//				if(u.getExamAttempt()!= null && u.getExamAttempt().equals("true")) {
	//					isExamAttempt = true;
	//				}
	//			}
	//		}
	//		return isExamAttempt;
	//	}

	@Transactional
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
		System.out.println(checkId);
		list1.clear();
		if(existUserObj != null && existUserObj.size() > 0)
		{
			isValidUser = true;
		}
		return isValidUser;
	}

	@Transactional
	public void updateUser(String email) {
		int id = 0;
		Student findStudent = new Student();
		findStudent.setEmail(email);

		List<Student> existUserObj = this.hibernateTemplate.findByExample(findStudent);
//		for (Student u : existUserObj) {
//			id = u.getId();
//		}
		Student student = this.hibernateTemplate.load(Student.class, checkId);
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
}
