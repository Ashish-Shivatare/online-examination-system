package admin.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import admin.dao.AdminDaoImpl;
import admin.model.Exam;
import admin.model.Question;
import admin.model.QuestionType;

@Service
public class AdminService {
	
		@Autowired
		private AdminDaoImpl adminDaoImpl;
		
		public List<Exam> getExam() {
			return this.adminDaoImpl.getAll();
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
	
}
