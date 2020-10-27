package admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import admin.model.Student;
import admin.service.AdminService;
//import admin.validator.UserValidator;
import admin.validator.StudentValidator;

@Controller
public class StudentRegistrationController {

	@Autowired
	private StudentValidator studentValidator;
	
	@Autowired
	private AdminService adminService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(studentValidator);
	}
	
	@RequestMapping(value="/registration")
	public String registrationForm(Model model) {
		model.addAttribute("student", new Student());
		return "student/registration";
	}

	@RequestMapping(path="/registrationForm", method = RequestMethod.POST)
	public String registerForm(@ModelAttribute("student") @Validated Student student, BindingResult result,
			Model model) {

		if(result.hasErrors())
		{
			return "student/registration";
		}
		student.setExamAttempt("false");
		this.adminService.createStudent(student);
		return "redirect:studentLogin";
	}
}
