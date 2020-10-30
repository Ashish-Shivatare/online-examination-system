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
import admin.service.ExamService;
import admin.service.StudentService;

@Controller
@RequestMapping(path = "/student")
public class StudentLoginController {
	
	@Autowired
	private ExamService examService;
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String loginRequestHandler(ModelMap modelMap, HttpSession session, HttpServletRequest request) {

		StudentLogin log = checkCookie(request);
		if (log == null) {
			modelMap.put("loginForm", new StudentLogin());
			return "student/login";
		}   
		else {  
			if(this.studentService.studentLogin(log.getEmail(), log.getPassword())){
				session.setAttribute("email", log.getEmail());
				if(!this.examService.getExamAttempt(log.getEmail(), log.getPassword())) {
					return "redirect:/exam";
				}
				else {
					return "redirect:/finish/studentDashboard";
				}
			} else {
				modelMap.put("error", "Invalid email or password");
				return "student/login";
			}
		}       
	}

	@RequestMapping(path = "/loginForm", method = RequestMethod.POST)
	public String loginRequestHandler(@ModelAttribute StudentLogin studentLogin, ModelMap modelMap, HttpSession session, HttpServletRequest request, HttpServletResponse response){

		if(this.studentService.studentLogin(studentLogin.getEmail(), studentLogin.getPassword())){
			session.setAttribute("email", studentLogin.getEmail());

			if(request.getParameter("remember")!=null){
				Cookie ckName = new Cookie("email", studentLogin.getEmail());
				ckName.setMaxAge(3600);
				response.addCookie(ckName);
				Cookie ckPassword = new Cookie("password", studentLogin.getPassword());
				ckPassword.setMaxAge(3600);
				response.addCookie(ckPassword);
			}
			if(!this.examService.getExamAttempt(studentLogin.getEmail(), studentLogin.getPassword())) {
				this.studentService.updateUserDetails(studentLogin.getEmail());
				return "redirect:/exam";
			}
			else {
				return "redirect:/finish/studentDashboard";
			}
		}
		else
		{
			modelMap.put("error", "Invalid email or password");
			return "student/login";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
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
		return "student/login";
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
