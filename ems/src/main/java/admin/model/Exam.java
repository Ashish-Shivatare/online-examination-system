package admin.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exam{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int totalStudents;
	private int totalQuestions;
	private int totalPass;
	private int totalFailed;
	private int examYear;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalStudents() {
		return totalStudents;
	}
	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}
	public int getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	public int getTotalPass() {
		return totalPass;
	}
	public void setTotalPass(int totalPass) {
		this.totalPass = totalPass;
	}
	public int getTotalFailed() {
		return totalFailed;
	}
	public void setTotalFailed(int totalFailed) {
		this.totalFailed = totalFailed;
	}
	public int getExamYear() {
		return examYear;
	}
	public void setExamYear(int examYear) {
		this.examYear = examYear;
	}

	
	public Exam(int id, int totalStudents, int totalQuestions, int totalPass, int totalFailed, int examYear) {
		super();
		this.id = id;
		this.totalStudents = totalStudents;
		this.totalQuestions = totalQuestions;
		this.totalPass = totalPass;
		this.totalFailed = totalFailed;
		this.examYear = examYear;
	}

	public Exam() {
		super();
	}
	
	@Override
	public String toString() {
		return "Exam [id=" + id + ", totalStudents=" + totalStudents + ", totalQuestions=" + totalQuestions
				+ ", totalPass=" + totalPass + ", totalFailed=" + totalFailed + ", examYear=" + examYear + "]";
	}
}
