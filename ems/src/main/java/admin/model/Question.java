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
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String question;
	private String answerButton;
	private String questionType;

	@ElementCollection 
	private Collection<String> correctAnswer;
	
	@ElementCollection 
	private Collection<String> questionOption;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Collection<String> getCorrectAnswer() {
		return correctAnswer;
	}


	public void setCorrectAnswer(Collection<String> correctAnswer) {
		this.correctAnswer = correctAnswer;
	}


	public Collection<String> getQuestionOption() {
		return questionOption;
	}


	public void setQuestionOption(Collection<String> questionOption) {
		this.questionOption = questionOption;
	}

	public Question() {
		super();
	}

	public Question(int id, String question, String answerButton, String questionType, Collection<String> correctAnswer,
			Collection<String> questionOption) {
		super();
		this.id = id;
		this.question = question;
		this.answerButton = answerButton;
		this.questionType = questionType;
		this.correctAnswer = correctAnswer;
		this.questionOption = questionOption;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answerButton=" + answerButton + ", questionType="
				+ questionType + ", correctAnswer=" + correctAnswer + ", questionOption=" + questionOption + "]";
	}	
}
