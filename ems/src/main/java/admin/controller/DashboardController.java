package admin.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import admin.model.Question;
import admin.model.Student;
import admin.model.StudentAnswer;
import admin.service.DashboardService;
import admin.service.StudentService;

@Controller 
@RequestMapping(path ="/admin")
public class DashboardController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping(path="/dashboard", method = RequestMethod.GET)
	public String dashBoardHome(Model model) {
		this.exam(model);
		this.getDonutChart(model);
		this.getBarChart(model);
		return "admin/dashboard";
	}
	
	@RequestMapping(path = "/changePassword")
	public String myAccount() {
		return "admin/dashboard/changePassword";
	}

	public String exam(Model model) {
		List<Student> student = this.studentService.getStudent();
		List<Question> question = this.dashboardService.getAllQuestion();
		List<StudentAnswer> studentAnswer = this.studentService.getStudentAnswers();
		
		int totalRegStudents = 0;
		int totalQueCount = 0;
		int totalPassStudents = 0;

		totalRegStudents = student.size();
		totalQueCount = question.size();
		
		for (StudentAnswer sa : studentAnswer) {
			if(sa.getStatus().equalsIgnoreCase("Pass")) {
				totalPassStudents++;
			}
		}
		
		model.addAttribute("totalStudents", totalRegStudents);
		model.addAttribute("totalQuestions", totalQueCount);
		model.addAttribute("totalPass", totalPassStudents);		
		return "admin/dashboard";
	}

	public String getDonutChart(Model model){
		List<StudentAnswer> studentAnswer = this.studentService.getStudentAnswers();
		List<Integer> labelList = new ArrayList<Integer>();
		List<Integer> valueList = new ArrayList<Integer>();
		int totalPassStudents = 0;
		int totalFailedStudents = 0;

		for (StudentAnswer sa : studentAnswer) {
			String date = sa.getDate().substring(0, 4);
			int d = Integer.parseInt(date);
			if(!labelList.contains(d)) {
				labelList.add(d);
			}
		}
		
		for (Integer integer : labelList) {
			for (StudentAnswer sa : studentAnswer) {
				String date = sa.getDate().substring(0, 4);
				int d = Integer.parseInt(date);
				if(integer == d) {
					if(sa.getStatus().equalsIgnoreCase("Pass")){
						totalPassStudents++;
					}else {
						totalFailedStudents++;
					}
				}
			} 
			valueList.add(totalPassStudents);
			totalPassStudents = 0; 
		}
		valueList.add(totalPassStudents);
		valueList.add(totalFailedStudents);

        model.addAttribute("donutValueArray",valueList);
        model.addAttribute("donutLabelArray",labelList);
		return "admin/dashboard";
	}

	public String getBarChart(Model model) {
		List<StudentAnswer> studentAnswer = this.studentService.getStudentAnswers();
		List<Integer> labelList = new ArrayList<Integer>();
		int totalPassStudents = 0;
		int totalFailedStudents = 0;
		int totalStudents = 0;
		
		List<Integer> passValueList = new ArrayList<Integer>();
		List<Integer> failedValueList = new ArrayList<Integer>();
		List<Integer> totalValueList = new ArrayList<Integer>();
		for (StudentAnswer sa : studentAnswer) {
			String date = sa.getDate().substring(0, 4);
			int d = Integer.parseInt(date);
			if(!labelList.contains(d)) {
				labelList.add(d);
			}
		}
		
		for (Integer integer : labelList) {
			
			for (StudentAnswer sa : studentAnswer) {
				String date = sa.getDate().substring(0, 4);
				int d = Integer.parseInt(date);
				if(integer == d) {
					if(sa.getStatus().equalsIgnoreCase("Pass")){
						totalPassStudents++;
					}else {
						totalFailedStudents++;
					}
					totalStudents++;
				}	
			} 
			passValueList.add(totalPassStudents);
			failedValueList.add(totalFailedStudents);
			totalValueList.add(totalStudents);
			
			totalPassStudents = 0;
			totalFailedStudents = 0;
			totalStudents = 0;
		}	
        model.addAttribute("passValueArray",passValueList);
        model.addAttribute("failedValueArray",failedValueList);
        model.addAttribute("totalValueArray", totalValueList);
		
        return "admin/dashboard";
	}
}
