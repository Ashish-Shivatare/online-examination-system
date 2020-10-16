package admin.controller;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import admin.model.StudentLogin;
import admin.service.AdminService;

@Controller
public class StudentLoginController {

	@Autowired
	private AdminService adminService;

	//	@RequestMapping(path = "/studentLogin")
	//	public String studentLogin() {
	//		System.out.println("studentLogin controller");
	//		return "studentLogin";    
	//	}
	//	
	//	@RequestMapping(path = "/studentLoginForm")
	//	public String studentLoginForm(@ModelAttribute StudentLogin studentLogin) {
	//		System.out.println("studentLoginForm controller");
	//		Boolean registeredStudent = this.adminService.studentLogin(studentLogin.getEmail(), studentLogin.getPassword());  
	//		if(registeredStudent == true){
	//			if(!this.adminService.getExamAttempt(studentLogin.getEmail(), studentLogin.getPassword())) {
	//				this.adminService.updateUserDetails(studentLogin.getEmail());
	//				return "redirect:exam";
	//			}
	//			else {
	//				System.out.println(this.adminService.getExamAttempt(studentLogin.getEmail(), studentLogin.getPassword()));
	//				return "redirect:finish/studentDashboard";
	//			}
	//		}
	//		else {
	//			return "studentLogin";
	//		}
	//	}

	@RequestMapping(path = "/studentLogin", method = RequestMethod.GET)
	public String loginRequestHandler(ModelMap modelMap, HttpSession session, HttpServletRequest request) {

		StudentLogin log = checkCookie(request);
		if (log == null) {
			modelMap.put("studentLoginForm", new StudentLogin());
			return "studentLogin";
		}   
		else {  
			if(this.adminService.studentLogin(log.getEmail(), log.getPassword())){
				session.setAttribute("email", log.getEmail());
				if(!this.adminService.getExamAttempt(log.getEmail(), log.getPassword())) {
					return "redirect:exam";
				}
				else {
					return "redirect:finish/studentDashboard";
				}
			} else {
				modelMap.put("error", "invalid login from cookie");
				System.out.println("Invalid login from cookie");
				return "studentLogin";
			}
		}       
	}

	@RequestMapping(path = "/studentLoginForm", method = RequestMethod.POST)
	public String loginRequestHandler(@ModelAttribute StudentLogin studentLogin, ModelMap modelMap, HttpSession session, HttpServletRequest request, HttpServletResponse response){

		if(this.adminService.studentLogin(studentLogin.getEmail(), studentLogin.getPassword())){
			session.setAttribute("email", studentLogin.getEmail());

			if(request.getParameter("remember")!=null){
				Cookie ckName = new Cookie("email", studentLogin.getEmail());
				ckName.setMaxAge(3600);
				response.addCookie(ckName);
				Cookie ckPassword = new Cookie("password", studentLogin.getPassword());
				ckPassword.setMaxAge(3600);
				response.addCookie(ckPassword);
			}
			if(!this.adminService.getExamAttempt(studentLogin.getEmail(), studentLogin.getPassword())) {
				this.adminService.updateUserDetails(studentLogin.getEmail());
				return "redirect:exam";
			}
			else {
				return "redirect:finish/studentDashboard";
			}
		}
		else
		{
			System.out.println("Invalid login not from cookie");
			modelMap.put("error", "Invalid login not from cookie");
			return "studentLogin";
		}
	}

	@RequestMapping(value = "studentLogout", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		session.removeAttribute("email");
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equalsIgnoreCase("email")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			if (cookie.getName().equalsIgnoreCase("password")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		return "studentLogin";
	}

	public StudentLogin checkCookie(HttpServletRequest request)  {
		Cookie[] cookies = request.getCookies();
		StudentLogin studentLogin = null;
		String email = "";
		String password = "";

		if(cookies != null) {
			for(Cookie ck : cookies) {
				if(ck.getName().equalsIgnoreCase("email"))
					email = ck.getValue();
				if(ck.getName().equalsIgnoreCase("password"))
					password = ck.getValue();
			}
		}
		if(!email.isEmpty() && !password.isEmpty())
		studentLogin = new StudentLogin(email, password);
		return studentLogin;
	}
}
