package admin.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import admin.service.AdminService;

@Controller
public class QuestionController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(path = "/addQuestionForm", method= RequestMethod.POST)
	public String dashBoardHome() {
	
		return "addQuestion";
	}
}
