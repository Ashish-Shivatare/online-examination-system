package admin.dao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import admin.model.Exam;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<Exam> getAll() {
		List<Exam> list=new ArrayList<Exam>();  
		list = hibernateTemplate.loadAll(Exam.class);
		return list;
	}
}
