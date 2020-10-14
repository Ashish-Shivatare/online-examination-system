package admin.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import admin.model.Answer;
import admin.model.Question;
import admin.service.AdminService;

@Controller
@RequestMapping("finish")
public class ExamFinishController {
	@Autowired
	private AdminService adminService;

	@RequestMapping(value="/studentDashboard" ,method = RequestMethod.GET)
	public String finishExam(Model model) {
		List<Answer> answer  = this.adminService.getAnswer();
		int solvedQuestions = 0;
		int correctAnswers  = 0;
		int incorrectAnswers = 0;
		String status;
		
		for (Answer ans : answer) {
			Question question = this.adminService.getQuestion(ans.getQuestionId());
			if(ans.getQuestionId() == question.getId()){
				if(ans.getSelectedAnswer().size() == question.getCorrectAnswer().size()) {
					if (ans.getSelectedAnswer().containsAll(question.getCorrectAnswer())) {
						correctAnswers++;
					}
				}
			}
			solvedQuestions++;
		}
		
		incorrectAnswers = solvedQuestions - correctAnswers;
		if(correctAnswers > 10)
			status = "Pass";
		else
			status = "Failed";
		
		model.addAttribute("totalSolvedQuestion", solvedQuestions);
		model.addAttribute("totalCorrectAnswer", correctAnswers);
		model.addAttribute("totalIncorrectAnswer", incorrectAnswers);
		model.addAttribute("status", status);
	
		return "studentDashboard";    
	}
}
