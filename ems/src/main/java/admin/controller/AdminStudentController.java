package admin.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import admin.model.Answer;
import admin.model.Question;
import admin.model.Student;
import admin.model.StudentAnswer;
import admin.service.DashboardService;
import admin.service.StudentService;
import admin.validator.StudentValidator;

@Controller
@RequestMapping(path = "admin")
public class AdminStudentController {

	@Autowired
	private DashboardService dashboardService;
	
	@Autowired
	private StudentService studentService;
	
	private Student st = new Student();
	
	@RequestMapping(path = "/studentInformation")
	public String studentInfo(Model model) {
		List<Student> studentList = this.studentService.getStudent();
		model.addAttribute("studentInfoList", studentList);
		return "admin/dashboard/studentInfo";
	}

	@RequestMapping(path = "/update/{studentId}")
	public String updateStudentInfo(@PathVariable("studentId") int studentId, Model model) {
		Student student = this.dashboardService.getStudentDetails(studentId);
		model.addAttribute("student", student);
		st = student;
		return "admin/dashboard/updateStudent";
	}

	@RequestMapping(path = "/updateStudentForm", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute("updateStudent")Student student) {
		student.setPassword(st.getPassword());
		student.setConfirmPassword(st.getConfirmPassword());
		student.setAgree(st.getAgree());
		student.setExamAttempt(st.getExamAttempt());
		student.setAnswer(st.getAnswer());
		student.setExamDate(st.getExamDate());
		this.dashboardService.updateStudentDetails(student);
		return "redirect:/admin/studentInformation";
	}

	@RequestMapping(path = "/studentReport")
	public String studentReport(Model model) {
		List<StudentAnswer> allStudentList = this.studentService.getStudentAnswers(); 
		model.addAttribute("studentReportList", allStudentList);
		return "admin/dashboard/reports";
	}
	
	@RequestMapping(path = "/studentReport/paper/{studentId}")
	public String questionPaper(@PathVariable("studentId") int studentId, Model model) {
		Student student = this.dashboardService.getStudentDetails(studentId);
		model.addAttribute("student", student);
		List<Question> questionList = new ArrayList<Question>();
		for (Answer ans : student.getAnswer()) {
			Question ques = this.dashboardService.getQuestion(ans.getQuestionId());
			questionList.add(ques);
		}
		model.addAttribute("questionList", questionList);
		return "admin/dashboard/report/questionPaper";
	}
}


