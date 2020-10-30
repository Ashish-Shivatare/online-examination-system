package admin.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import admin.model.AdminLogin;
import admin.model.AdminLoginCredentials;

@Controller
public class AdminLoginController {
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String loginRequestHandler(ModelMap modelMap, HttpSession session, HttpServletRequest request) {
		AdminLogin log = checkCookie(request);
		if (log == null) {
			modelMap.put("loginForm", new AdminLogin());
			return "admin/login";
		}   
		else {  
			AdminLoginCredentials adminLogin = new AdminLoginCredentials();
			if(adminLogin.login(log.getUsername(), log.getPassword())){
				session.setAttribute("username", log.getUsername());
				return "redirect:admin/dashboard";
			} else {
				modelMap.put("error", "invalid login from cookie");
				return "admin/login";
			}
		}       
	}

	@RequestMapping(path = "/loginForm", method = RequestMethod.POST)
	public String loginRequestHandler(@ModelAttribute("loginForm") AdminLogin adminLogin, ModelMap modelMap, HttpSession session, HttpServletRequest request, HttpServletResponse response){
				
		AdminLoginCredentials loginCredentials = new AdminLoginCredentials();
		if(loginCredentials.login(adminLogin.getUsername(), adminLogin.getPassword())){
			session.setAttribute("username", adminLogin.getUsername());

			if(request.getParameter("remember")!=null){
				Cookie ckName = new Cookie("username", adminLogin.getUsername());
				ckName.setMaxAge(3600);
				response.addCookie(ckName);
				Cookie ckPassword = new Cookie("password", adminLogin.getPassword() );
				ckPassword.setMaxAge(3600);
				response.addCookie(ckPassword);
			}
			return "redirect:/admin/dashboard";
		}
		else
		{
			modelMap.put("error", "Invalid login not from cookie");
			return "admin/login";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		session.removeAttribute("username");
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equalsIgnoreCase("username")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			if (cookie.getName().equalsIgnoreCase("password")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		return "admin/login";
	}

	public AdminLogin checkCookie(HttpServletRequest request)  {
		Cookie[] cookies = request.getCookies();
		AdminLogin adminLogin = null;
		String username = "";
		String password = "";
		
		if(cookies != null) {
			for(Cookie ck : cookies) {
				if(ck.getName().equalsIgnoreCase("username"))
					username = ck.getValue();
				if(ck.getName().equalsIgnoreCase("password"))
					password = ck.getValue();
			}
		}
		if(!username.isEmpty() && !password.isEmpty())
			adminLogin = new AdminLogin(username, password);
		return adminLogin;
	}
}
