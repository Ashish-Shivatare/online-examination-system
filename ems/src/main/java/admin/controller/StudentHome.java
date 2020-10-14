package admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import admin.model.AccountModel;
import admin.model.Login;

@Controller
public class StudentHome {
	
	@RequestMapping(path = "/studentLogin")
	public String studentLogin() {
		System.out.println("studentLogin controller");
		return "studentLogin";    
	}
	
	@RequestMapping(path = "/studentLoginForm")
	public String studentLoginForm(@ModelAttribute Login login) {
		System.out.println("studentLoginForm controller");
		AccountModel accModel = new AccountModel();
		if(accModel.studentLogin(login.getEmail(), login.getPassword())){
			return "redirect:exam";
		} else {
			return "studentLogin";
		}    
	}
}
