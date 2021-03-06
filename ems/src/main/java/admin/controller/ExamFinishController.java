package admin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import admin.model.Answer;
import admin.model.Question;
import admin.model.StudentAnswer;
import admin.service.DashboardService;
import admin.service.ExamService;
import admin.service.StudentService;

@Controller
@RequestMapping("finish")
public class ExamFinishController {

	@Autowired
	private ExamService examService;
	
	@Autowired
	private DashboardService dashboardService;
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value="/studentDashboard" ,method = RequestMethod.GET)
	public String finishExam(Model model) {
		this.examService.saveFinalSubmission();
		
		List<Answer> answer  = this.dashboardService.getAnswer();
		int solvedQuestions = 0;
		int correctAnswers  = 0;
		int incorrectAnswers = 0;
		String status;
		
		for (Answer ans : answer) {
			Question question = this.dashboardService.getQuestion(ans.getQuestionId());
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
		if(correctAnswers >= 10)
			status = "Pass";
		else
			status = "Failed";
		
		model.addAttribute("totalSolvedQuestion", solvedQuestions);
		model.addAttribute("totalCorrectAnswer", correctAnswers);
		model.addAttribute("totalIncorrectAnswer", incorrectAnswers);
		model.addAttribute("status", status);
		
		StudentAnswer studentAnswer = new StudentAnswer();
		studentAnswer.setTotalSolvedQuestion(solvedQuestions);
		studentAnswer.setCorrectAnswerCount(correctAnswers);
		studentAnswer.setIncorrectAnswerCount(incorrectAnswers);
		studentAnswer.setStatus(status);
		this.studentService.saveStudentAnswers(studentAnswer);
		return "student/dashboard";    
	}
}
