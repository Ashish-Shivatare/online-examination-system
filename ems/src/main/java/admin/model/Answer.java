package admin.model;
import java.util.Collection;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int questionId;
	
	private String question;
	
	@ElementCollection
	private Collection<String> selectedAnswer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Collection<String> getSelectedAnswer() {
		return selectedAnswer;
	}
	public void setSelectedAnswer(Collection<String> selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}
	
	public Answer(int id, int questionId, String question, Collection<String> selectedAnswer) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.question = question;
		this.selectedAnswer = selectedAnswer;
	}
	public Answer() {
		super();
	}
	
	@Override
	public String toString() {
		return "Answer [id=" + id + ", questionId=" + questionId + ", question=" + question + ", selectedAnswer="
				+ selectedAnswer + "]";
	}	
}
