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
import admin.model.User;
import admin.service.AdminService;
import admin.validator.UserValidator;

@Controller
public class StudentRegistrationController {

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private AdminService adminService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}
	
	@RequestMapping(value="/registration")
	public String registrationForm(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@RequestMapping(path="/registrationForm", method = RequestMethod.POST)
	public String registerForm(@ModelAttribute("user") @Validated User user, BindingResult result,
			Model model) {

		if(result.hasErrors())
		{
			return "registration";
		}
		this.adminService.createUser(user);
		return "redirect:studentLogin";
	}
}
