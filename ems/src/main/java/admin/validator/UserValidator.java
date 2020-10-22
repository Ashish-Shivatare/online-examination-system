//package admin.validator;
//
//import java.util.regex.Pattern;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//import admin.model.User;
//import admin.service.AdminService;
//
//@Component
//public class UserValidator implements Validator {
//
//	@Autowired
//	private AdminService adminService;
//	
//	public boolean supports(Class<?> clazz) {
//		return User.class.equals(clazz);
//	}
//
//	public void validate(Object obj, Errors err) {
//
//		ValidationUtils.rejectIfEmpty(err, "name", "user.name.empty");
//		ValidationUtils.rejectIfEmpty(err, "email", "user.email.empty");
//		ValidationUtils.rejectIfEmpty(err, "password", "user.password.empty");
//		ValidationUtils.rejectIfEmpty(err, "confirmPassword", "user.confirmPassword.empty");
//		ValidationUtils.rejectIfEmpty(err, "agree", "user.agree.empty");
//		User user = (User) obj;
//		
//		Boolean userExist = this.adminService.findEmail(user.getEmail());
//		
//		if(userExist)
//		{
//			err.rejectValue("email", "user.email.exist");
//		}
//		
//		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
//				Pattern.CASE_INSENSITIVE);
//
//		if (!(user.getEmail().isEmpty()) && !(pattern.matcher(user.getEmail()).matches())) {
//			err.rejectValue("email", "user.email.invalid");
//		}
//
//		if(!(user.getConfirmPassword().isEmpty()) && !(user.getPassword().equals(user.getConfirmPassword()))){
//			err.rejectValue("confirmPassword", "user.confirmPassword.invalid");
//		}
//		
//		if(!(user.getPassword().length() >=4 && user.getPassword().length() <=8)){
//			err.rejectValue("password", "user.password.invalid");
//		}
//	}
//}
