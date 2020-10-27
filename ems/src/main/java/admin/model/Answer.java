package admin.model;
import java.util.Collection;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Embeddable
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int questionId;
	private String question;
	private String answerButton;
	private String questionType;
	
	@ElementCollection
	private Collection<String> allOptions;
	
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

	public String getAnswerButton() {
		return answerButton;
	}

	public void setAnswerButton(String answerButton) {
		this.answerButton = answerButton;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public Collection<String> getAllOptions() {
		return allOptions;
	}

	public void setAllOptions(Collection<String> allOptions) {
		this.allOptions = allOptions;
	}

	public Collection<String> getSelectedAnswer() {
		return selectedAnswer;
	}

	public void setSelectedAnswer(Collection<String> selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}

	
	public Answer() {
		super();
	}

	public Answer(int id, int questionId, String question, String answerButton, String questionType,
			Collection<String> allOptions, Collection<String> selectedAnswer) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.question = question;
		this.answerButton = answerButton;
		this.questionType = questionType;
		this.allOptions = allOptions;
		this.selectedAnswer = selectedAnswer;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", questionId=" + questionId + ", question=" + question + ", answerButton="
				+ answerButton + ", questionType=" + questionType + ", allOptions=" + allOptions + ", selectedAnswer="
				+ selectedAnswer + "]";
	}

	
}
