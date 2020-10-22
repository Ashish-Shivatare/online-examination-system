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

import admin.model.Account;
import admin.model.AccountModel;

@Controller
public class AdminLoginController {
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String loginRequestHandler(ModelMap modelMap, HttpSession session, HttpServletRequest request) {

		Account log = checkCookie(request);
		if (log == null) {
			modelMap.put("loginForm", new Account());
			return "admin/login";
		}   
		else {  
			AccountModel accountModel = new AccountModel();
			if(accountModel.login(log.getUsername(), log.getPassword())){
				session.setAttribute("username", log.getUsername());
				return "redirect:dashboard";
			} else {
				modelMap.put("error", "invalid login from cookie");
				System.out.println("Invalid login from cookie");
				return "admin/login";
			}
		}       
	}


	@RequestMapping(path = "/loginForm", method = RequestMethod.POST)
	public String loginRequestHandler(@ModelAttribute("loginForm") Account account, ModelMap modelMap, HttpSession session, HttpServletRequest request, HttpServletResponse response){
		
		AccountModel accountModel = new AccountModel();
		if(accountModel.login(account.getUsername(), account.getPassword())){
			session.setAttribute("username", account.getUsername());
			
			if(request.getParameter("remember")!=null){
				Cookie ckName = new Cookie("username", account.getUsername());
				ckName.setMaxAge(3600);
				response.addCookie(ckName);
				Cookie ckPassword = new Cookie("password", account.getPassword() );
				ckPassword.setMaxAge(3600);
				response.addCookie(ckPassword);
			}
			return "redirect:dashboard";
		}
		else
		{
			System.out.println("Invalid login not from cookie");
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

	public Account checkCookie(HttpServletRequest request)  {
		Cookie[] cookies = request.getCookies();
		Account account = null;
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
			account = new Account(username, password);
		return account;
	}
}
