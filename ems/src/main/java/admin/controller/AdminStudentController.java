package admin.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import admin.model.Student;
import admin.service.AdminService;

@Controller
public class AdminStudentController {
	
	@Autowired
	private AdminService adminservice;
	
	@RequestMapping(path = "/studentInformation")
	public String studentInfo(Model model) {
		System.out.println("Student Controller");
		List<Student> studentList = this.adminservice.getStudent();
		model.addAttribute("studentInfoList", studentList);
		return "dashboard/studentInfo";
	}
	
	@RequestMapping(path = "/update/{studentId}")
	public String updateStudentInfo(@PathVariable("studentId") int studentId, Model model) {
		Student student = this.adminservice.getStudentDetails(studentId);
		model.addAttribute("student", student);
		return "updateStudent";
	}
	
	@RequestMapping(path = "/updateStudentForm", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute Student student) {
		System.out.println("updateStudent Controller");
		this.adminservice.updateStudentDetails(student);
		return "redirect:studentInformation";
	}
	
	@RequestMapping(path = "/studentReport")
	public String studentReport() {
		System.out.println("StudentReport Controller");
		return "dashboard/reports";
	}
}
