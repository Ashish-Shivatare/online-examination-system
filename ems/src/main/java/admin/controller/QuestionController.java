package admin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import admin.model.Question;
import admin.model.QuestionType;
import admin.service.DashboardService;

@Controller
public class QuestionController {
	
	@Autowired
	private DashboardService dashboardService;

	@RequestMapping(path = "/questionType")
	public String questionType(Model model) {
		List<QuestionType> questionType = this.dashboardService.getQuestionType();
		model.addAttribute("questionTypeList", questionType);
		return "admin/dashboard/questionType";
	}

	@RequestMapping(path = "/addQuestion")
	public String addQuestion(Model model){
		List<QuestionType> questionType = this.dashboardService.getQuestionType();
		model.addAttribute("questionTypeList", questionType);
		return "admin/dashboard/addQuestion";
	}

	@RequestMapping(path = "/questionTypeForm", method = RequestMethod.GET)
	public String saveQuestionType(@ModelAttribute QuestionType questionType) {
		if(questionType != null) {
			this.dashboardService.createQuestionType(questionType);
		}
		return "redirect:questionType";
	}

	@RequestMapping(path = "/addQuestionForm", method = RequestMethod.GET)
	public String saveAddQuestion(@ModelAttribute Question question){
		if(question != null) {
			this.dashboardService.createQuestion(question);
		}
		return "redirect:addQuestion";
	}
	
	@RequestMapping(path = "/questionType/report")
	public String questionTypeReport(Model model) {
		List<QuestionType> questionType = this.dashboardService.getQuestionType();
		model.addAttribute("questionTypeList", questionType);
		return "admin/dashboard/report/allQuestionTypes";
	}

	@RequestMapping(path = "/questionType/update/{questionType}/{questionId}")
	public String questionTypeReport(@PathVariable("questionType") String questionType,@PathVariable("questionId") int questionId, Model model) {
		model.addAttribute("questionId", questionId);
		model.addAttribute("questionType", questionType);
		return "admin/dashboard/report/updateQuestionType";
	}

	@RequestMapping(path = "/questionType/update")
	public String questionTypeUpdate(@ModelAttribute QuestionType questionType) {
		this.dashboardService.createQuestionType(questionType);
		return "redirect:/questionType/report";
	}
	
	@RequestMapping(path = "/questionType/delete/{questionId}")
	public String questionTypeDelete(@PathVariable("questionId") int questionId) {
		this.dashboardService.deleteQuestionType(questionId);
		return "redirect:/questionType/report";
	}
	
	@RequestMapping(path = "/addQuestion/report")
	public String addQuestionReport(Model model) {
		List<Question> allQuestion = this.dashboardService.getAllQuestion();
		model.addAttribute("allQuestionList", allQuestion);
		return "admin/dashboard/report/allQuestions";
	}
	
	@RequestMapping(path = "/addQuestion/report/update/{questionId}")
	public String addQuestionUpdate(@PathVariable("questionId") int questionId, Model model) {
		List<QuestionType> questionType = this.dashboardService.getQuestionType();
		Question question = this.dashboardService.getQuestion(questionId);
		model.addAttribute("que", question); 
		model.addAttribute("questionTypeList", questionType); 
		return "admin/dashboard/report/updateQuestion";
	}
	
	@RequestMapping(path = "/addQuestion/report/update/updateForm", method = RequestMethod.POST)
	public String addQuestionUpdateForm(@ModelAttribute Question question, Model model) {
		this.dashboardService.createQuestion(question);
		System.out.println(question);
		return "redirect:/addQuestion/report";
	}
	
	@RequestMapping(path = "/addQuestion/delete/{questionId}")
	public String addQuestionDelete(@PathVariable("questionId") int id) {
		this.dashboardService.deleteQuestion(id);
		return "redirect:/addQuestion/report";
	}
}
