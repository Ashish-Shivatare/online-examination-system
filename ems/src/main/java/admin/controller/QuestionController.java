package admin.controller;

import java.util.List;

import javax.naming.spi.ResolveResult;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import admin.model.Question;
import admin.model.QuestionType;
import admin.service.DashboardService;
import admin.validator.QuestionValidator;

@Controller
public class QuestionController {

	@Autowired
	private QuestionValidator questionValidator;

	@InitBinder("question")
	protected void initBinder1(WebDataBinder binder) {
		binder.addValidators(questionValidator);
	}

	@Autowired
	private DashboardService dashboardService;

	@RequestMapping(path = "/questionType")
	public String questionType(Model model) {
		List<QuestionType> questionType = this.dashboardService.getQuestionType();
		model.addAttribute("questionTypeList", questionType);
		return "admin/dashboard/questionType";
	}

	@RequestMapping(path = "/questionTypeForm", method = RequestMethod.POST)
	public String saveQuestionType(@ModelAttribute QuestionType questionType) {	
		if(questionType.getQuestionType().isEmpty()) {
			return "redirect:questionType";
		}
		this.dashboardService.createQuestionType(questionType);
		return "redirect:questionType/report";
	}

	@RequestMapping(path = "/questionType/report")
	public String questionTypeReport(Model model) {
		List<QuestionType> questionType = this.dashboardService.getQuestionType();
		model.addAttribute("questionTypeList", questionType);
		return "admin/dashboard/report/allQuestionTypes";
	}

	@RequestMapping(path = "/questionType/update/{questionType}/{questionId}")
	public String questionTypeReport(@PathVariable("questionType") String questionType, @PathVariable("questionId") int questionId, Model model) {
		model.addAttribute("questionId", questionId);
		model.addAttribute("questionType", questionType);
		return "admin/dashboard/report/updateQuestionType";
	}

	@RequestMapping(path = "/questionType/update")
	public String questionTypeUpdate(@ModelAttribute QuestionType questionType){
		if(questionType.getQuestionType().isEmpty()) {
			return "redirect:/questionType/report";
		}
		this.dashboardService.createQuestionType(questionType);
		return "redirect:/questionType/report";
	}

	@RequestMapping(path = "/questionType/delete/{questionId}")
	public String questionTypeDelete(@PathVariable("questionId") int questionId) {
		this.dashboardService.deleteQuestionType(questionId);
		return "redirect:/questionType/report";
	}
	
	@RequestMapping(path = "/addQuestion")
	public String addQuestion(Model model){
		List<QuestionType> questionType = this.dashboardService.getQuestionType();
		model.addAttribute("questionTypeList", questionType);
		return "admin/dashboard/addQuestion";
	}

	@RequestMapping(path = "/addQuestionForm", method = RequestMethod.POST)
	public ModelAndView saveAddQuestion(@ModelAttribute("question") @Validated Question question, BindingResult result){
		ModelAndView modelAndView;
		if(result.hasErrors()) {
			modelAndView = new ModelAndView("admin/dashboard/addQuestion");
			List<QuestionType> questionType = this.dashboardService.getQuestionType();
			modelAndView.addObject(questionType);
			modelAndView.addObject("question", question);
			return modelAndView;
		}
		if(question != null) {
			this.dashboardService.createQuestion(question);
			System.out.println(question);
		}
		modelAndView = new ModelAndView("redirect:addQuestion/report");
		
		return modelAndView;
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
	public ModelAndView addQuestionUpdateForm(@ModelAttribute("updateQuestion") @Validated Question question,  BindingResult result) {
		ModelAndView modelAndView;
		if(result.hasErrors()) {
			List<QuestionType> questionType = this.dashboardService.getQuestionType();
			modelAndView = new ModelAndView("admin/dashboard/report/updateQuestion");
			modelAndView.addObject("que", question);
			modelAndView.addObject("questionTypeList",questionType);
			return modelAndView;
		}
		this.dashboardService.createQuestion(question);
		modelAndView  = new ModelAndView("redirect:/addQuestion/report");
		return modelAndView;
	}

	@RequestMapping(path = "/addQuestion/delete/{questionId}")
	public String addQuestionDelete(@PathVariable("questionId") int id) {
		this.dashboardService.deleteQuestion(id);
		return "redirect:/addQuestion/report";
	}
}
