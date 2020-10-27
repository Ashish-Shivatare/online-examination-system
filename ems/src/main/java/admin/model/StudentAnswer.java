package admin.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int studentId;
	private String studentName;
	private String studentEmail;
	private String studentMobileNo;
	private int totalSolvedQuestion;
	private int correctAnswerCount;
	private int incorrectAnswerCount;
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentMobileNo() {
		return studentMobileNo;
	}
	public void setStudentMobileNo(String studentMobileNo) {
		this.studentMobileNo = studentMobileNo;
	}
	public int getTotalSolvedQuestion() {
		return totalSolvedQuestion;
	}
	public void setTotalSolvedQuestion(int totalSolvedQuestion) {
		this.totalSolvedQuestion = totalSolvedQuestion;
	}
	public int getCorrectAnswerCount() {
		return correctAnswerCount;
	}
	public void setCorrectAnswerCount(int correctAnswerCount) {
		this.correctAnswerCount = correctAnswerCount;
	}
	public int getIncorrectAnswerCount() {
		return incorrectAnswerCount;
	}
	public void setIncorrectAnswerCount(int incorrectAnswerCount) {
		this.incorrectAnswerCount = incorrectAnswerCount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public StudentAnswer(int id, int studentId, String studentName, String studentEmail, String studentMobileNo,
			int totalSolvedQuestion, int correctAnswerCount, int incorrectAnswerCount, String status) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentMobileNo = studentMobileNo;
		this.totalSolvedQuestion = totalSolvedQuestion;
		this.correctAnswerCount = correctAnswerCount;
		this.incorrectAnswerCount = incorrectAnswerCount;
		this.status = status;
	}
	
	public StudentAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "StudentAnswer [id=" + id + ", studentId=" + studentId + ", studentName=" + studentName
				+ ", studentEmail=" + studentEmail + ", studentMobileNo=" + studentMobileNo + ", totalSolvedQuestion="
				+ totalSolvedQuestion + ", correctAnswerCount=" + correctAnswerCount + ", incorrectAnswerCount="
				+ incorrectAnswerCount + ", status=" + status + "]";
	}
}
