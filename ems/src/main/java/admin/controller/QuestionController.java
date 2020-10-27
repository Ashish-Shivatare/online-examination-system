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
import admin.service.AdminService;

@Controller
public class QuestionController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(path = "/questionType")
	public String questionType(Model model) {
		List<QuestionType> questionType = this.adminService.getQuestionType();
		model.addAttribute("questionTypeList", questionType);
		return "admin/dashboard/questionType";
	}

	@RequestMapping(path = "/addQuestion")
	public String addQuestion(Model model){
		List<QuestionType> questionType = this.adminService.getQuestionType();
		List<Question> allQuestion = this.adminService.getAllQuestion();
		model.addAttribute("questionTypeList", questionType);
		model.addAttribute("allQuestionList", allQuestion);
		return "admin/dashboard/addQuestion";
	}

	@RequestMapping(path = "/questionTypeForm", method = RequestMethod.GET)
	public String saveQuestionType(@ModelAttribute QuestionType questionType) {
		if(questionType != null) {
			this.adminService.createQuestionType(questionType);
		}
		return "redirect:questionType";
	}

	@RequestMapping(path = "/addQuestionForm", method = RequestMethod.GET)
	public String saveAddQuestion(@ModelAttribute Question question){
		if(question != null) {
			this.adminService.createQuestion(question);
		}
		return "admin/dashboard/addQuestion";
	}

	@RequestMapping(path = "/questionTypeReport/{questionType}/{questionId}")
	public String questionTypeReport(@PathVariable("questionType") String questionType,@PathVariable("questionId") int questionId, Model model) {
		model.addAttribute("questionId", questionId);
		model.addAttribute("questionType", questionType);
		return "admin/dashboard/report/reportQuestionType";
	}

	@RequestMapping(path = "/questionTypeUpdate")
	public String questionTypeUpdate(@ModelAttribute QuestionType questionType) {
		this.adminService.createQuestionType(questionType);
		return "redirect:questionType";
	}
	
	@RequestMapping(path = "/questionTypeDelete/{questionId}")
	public String questionTypeDelete(@PathVariable("questionId") int questionId) {
		this.adminService.deleteQuestionType(questionId);
		return "redirect:/questionType";
	}
	
	@RequestMapping(path = "/addQuestion/report/{questionId}")
	public String addQuestionReport(@PathVariable("questionId") int questionId, Model model) {
		List<QuestionType> questionType = this.adminService.getQuestionType();
		Question question = this.adminService.getQuestion(questionId);
		model.addAttribute("que", question); 
		model.addAttribute("questionTypeList", questionType); 
		return "admin/dashboard/report/reportAddQuestion";
	}
	
	@RequestMapping(path = "/addQuestion/report/updateForm", method = RequestMethod.POST)
	public String addQuestionUpdateForm(@ModelAttribute Question question, Model model) {
		this.adminService.createQuestion(question);
		return "redirect:/addQuestion";
	}
	
	@RequestMapping(path = "/addQuestion/delete")
	public String addQuestionDelete() {
		return "redirect:addQuestion";
	}
}
