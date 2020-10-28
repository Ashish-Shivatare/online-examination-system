package admin.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import admin.model.Question;

@Component
public class QuestionValidator implements Validator {
	
	public boolean supports(Class<?> clazz) {
		return Question.class.equals(clazz);
	}
	
	public void validate(Object obj, Errors err) {
		ValidationUtils.rejectIfEmpty(err, "question", "question.question.empty");
		
		Question question = (Question) obj;
		if(question.getQuestionOption().contains("") || question.getQuestionOption().contains(null)) {
			err.rejectValue("questionOption", "question.questionOption.empty");
		}
		if(question.getCorrectAnswer() == null) {
			err.rejectValue("correctAnswer", "question.correctAnswer.selected");
		}
	}
}
