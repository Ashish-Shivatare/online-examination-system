package admin.dao;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import admin.model.Exam;
import admin.model.Question;
import admin.model.QuestionType;

@Repository
public class AdminDaoImpl {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<Exam> getAll() {
		List<Exam> list=new ArrayList<Exam>();  
		list = hibernateTemplate.loadAll(Exam.class);
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
		List<QuestionType> list=new ArrayList<QuestionType>();  
		list = hibernateTemplate.loadAll(QuestionType.class);
		return list;
	}
}
