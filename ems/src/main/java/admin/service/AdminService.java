package admin.service;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import admin.dao.AdminDaoImpl;
import admin.model.Answer;
import admin.model.Exam;
import admin.model.Question;
import admin.model.QuestionType;
import admin.model.Student;

@Service
public class AdminService {
	
		@Autowired
		private AdminDaoImpl adminDaoImpl;
		
		public List<Exam> getExam() {
			return this.adminDaoImpl.getAll();
		}
		
		public List<Student> getStudent() {
			return this.adminDaoImpl.getStudentInformation();
		}
		
		public List<QuestionType> getQuestionType() {
			return this.adminDaoImpl.getQuestionTypes();
		}
		
		public int createQuestionType(QuestionType questionType) {
			return this.adminDaoImpl.saveQuestionType(questionType);
		}
		
		public int createQuestion(Question question) {
			return this.adminDaoImpl.saveQuestion(question);
		}
		
		public void updateStudentDetails(Student student) {
			this.adminDaoImpl.updateStudent(student);
		}
		
		public Student getStudentDetails(int studentId) {
			return this.adminDaoImpl.getStudent(studentId);
		}
		
		public List<Question> getAllQuestion() {
			return this.adminDaoImpl.getQuestions();
		}
		
		public Question getQuestion(int id) {
			return this.adminDaoImpl.getQuestion(id);
		}
		
		public void addAnswer(Answer answer) {
			this.adminDaoImpl.saveAnswer(answer);
		}
		
		public List<Answer> getAnswer() {
			return this.adminDaoImpl.getAllAnswer();
		}
}
