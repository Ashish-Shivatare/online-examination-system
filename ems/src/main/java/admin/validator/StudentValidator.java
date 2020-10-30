package admin.validator;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import admin.model.Student;
import admin.service.StudentService;

@Component
public class StudentValidator implements Validator {
	
	@Autowired
	private StudentService studentService;
	
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	public void validate(Object obj, Errors err) {

		ValidationUtils.rejectIfEmpty(err, "name", "student.name.empty");
		ValidationUtils.rejectIfEmpty(err, "email", "student.email.empty");
		ValidationUtils.rejectIfEmpty(err, "mobileNo", "student.mobileNo.empty");
		ValidationUtils.rejectIfEmpty(err, "higherEducation", "student.higherEducation.empty");
		ValidationUtils.rejectIfEmpty(err, "gender", "student.gender.empty");
		ValidationUtils.rejectIfEmpty(err, "dob", "student.dob.empty");
		ValidationUtils.rejectIfEmpty(err, "address", "student.address.empty");
		ValidationUtils.rejectIfEmpty(err, "city", "student.city.empty");
		ValidationUtils.rejectIfEmpty(err, "country", "student.country.empty");
		ValidationUtils.rejectIfEmpty(err, "panCard", "student.panCard.empty");
		ValidationUtils.rejectIfEmpty(err, "higherEducationCertificate", "student.higherEducationCertificate.empty");
		ValidationUtils.rejectIfEmpty(err, "registrationDate", "student.registrationDate.empty");
		ValidationUtils.rejectIfEmpty(err, "password", "student.password.empty");
		ValidationUtils.rejectIfEmpty(err, "confirmPassword", "student.confirmPassword.empty");
		ValidationUtils.rejectIfEmpty(err, "agree", "student.agree.empty");
		Student student = (Student) obj;
		
		Boolean userExist = this.studentService.findEmail(student.getEmail());
		
		if(userExist)
		{
			err.rejectValue("email", "student.email.exist");
		}
		
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);

		if (!(student.getEmail().isEmpty()) && !(pattern.matcher(student.getEmail()).matches())) {
			err.rejectValue("email", "student.email.invalid");
		}

		if(!(student.getConfirmPassword().isEmpty()) && !(student.getPassword().equals(student.getConfirmPassword()))){
			err.rejectValue("confirmPassword", "student.confirmPassword.invalid");
		}
		
		if(!(student.getPassword().length() >=4 && student.getPassword().length() <=8)){
			err.rejectValue("password", "student.password.invalid");
		}
	}
}
