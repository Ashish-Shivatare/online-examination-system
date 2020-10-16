package admin.controller;
import java.util.Arrays;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import admin.model.Answer;
import admin.model.Question;
import admin.service.AdminService;

@Controller
@RequestMapping("exam")
public class ExamController {

	@Autowired
	private AdminService adminService;
	private int queCount = 0;
	Integer[] randomArray = new Integer[30];
	private int totalQuestion = randomArray.length;

	@RequestMapping(method = RequestMethod.GET)
	public String getExamWindow(Model model) {
		this.getRandomNumber();
		this.getNextQuestion(model);
		System.out.println(Arrays.toString(randomArray));
		return "exam";    
	}

	public void getRandomNumber() {
		System.out.println("getRandom");
		int serialCount = 1;
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = serialCount;
			serialCount++;
		}
		Collections.shuffle(Arrays.asList(randomArray));
	}

	public Question getNextQuestion(Model model) {
		System.out.println("getNextQuestion");
		Question question = this.adminService.getQuestion(randomArray[queCount]);
		model.addAttribute("que", question);
		model.addAttribute("questionNumber", 1);
		model.addAttribute("totalQuestions", this.totalQuestion);
		System.out.println(queCount);
		if(queCount != 29) {
			queCount++;
		}
		return question;
	}

	@RequestMapping(value = "question", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Question getAnswers(@RequestBody Answer answer, Model model) {
		Question question = this.getNextQuestion(model);
		//this.adminService.addAnswer(answer);
		System.out.println(answer);
		return question;    
	}

	@RequestMapping(value="submitExam" ,method = RequestMethod.GET)
	public String submitExam() {
		System.out.println("submit exam controller");
		return "examSubmit";    
	}
}