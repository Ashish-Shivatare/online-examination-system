package admin.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@RequestMapping(path = "/studentInformation")
	public String studentType() {
		System.out.println("Student Controller");
		return "studentInfo";
	}
	
	@RequestMapping(path = "/studentReport")
	public String studentReport() {
		System.out.println("Student Controller");
		return "reports";
	}
}
