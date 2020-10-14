package admin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String questionType() {
		return "questionType";
	}
	
	@RequestMapping(path = "/addQuestion")
	public String addQuestion(Model model){
		List<QuestionType> list = this.adminService.getQuestionType();
		model.addAttribute("allQuestionType", list);	
		return "addQuestion";
	}
	
	
	@RequestMapping(path = "/questionTypeForm", method = RequestMethod.GET)
	public String saveQuestionType(@ModelAttribute QuestionType questionType) {
		System.out.println("QuestionTypeForm Controller");
		if(questionType != null) {
			this.adminService.createQuestionType(questionType);
		}
		return "questionType";
	}

	@RequestMapping(path = "/addQuestionForm", method = RequestMethod.GET)
	public String saveAddQuestion(@ModelAttribute Question question){
		System.out.println("AddQuestionForm Controller");
		if(question != null) {
			this.adminService.createQuestion(question);
		}
		return "addQuestion";
	}
}
