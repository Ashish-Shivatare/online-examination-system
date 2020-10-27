package admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import admin.model.Answer;
import admin.model.Question;
import admin.service.DashboardService;

@Controller
@RequestMapping("exam")
public class ExamController {

	@Autowired
	private DashboardService dashboardService;

	@RequestMapping(method = RequestMethod.GET)
	public String getExamWindow(Model model) {
		this.getNextQuestion(model);
		return "examination/examWindow";    
	}
	
	public static int getRandomInteger(int maximum, int minimum){ 
		return ((int) (Math.random()*(maximum - minimum))) + minimum; 
	}

	public Question getNextQuestion(Model model) {
		int r = getRandomInteger(1, 30);
		Question question = this.dashboardService.getQuestion(r);
		model.addAttribute("que", question);
		model.addAttribute("questionNumber", 1);
		model.addAttribute("totalQuestions", 30);
		return question;
	}

	@RequestMapping(value = "question", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Question getAnswers(@RequestBody Answer answer, Model model) {
		if(answer.getSelectedAnswer() != null && answer.getSelectedAnswer().size() > 0 ) {
			this.dashboardService.addAnswer(answer);
			System.out.println(answer);
		}
		Question question = this.getNextQuestion(model);
		return question;    
	}
}