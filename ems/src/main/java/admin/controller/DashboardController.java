package admin.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import admin.model.Exam;
import admin.service.ExamService;

@Controller 
public class DashboardController {

	@Autowired
	private ExamService examService;
	
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
		List<Exam> exam = this.examService.getExam();
		int totalRegStudents = 0;
		int totalQueCount = 0;
		int totalPassStudents = 0;

		for (Exam ex : exam) {
			totalRegStudents = totalRegStudents + ex.getTotalStudents();
			totalQueCount = totalQueCount + ex.getTotalQuestions();
			totalPassStudents = totalPassStudents + ex.getTotalPass();
		}
		model.addAttribute("totalStudents", totalRegStudents);
		model.addAttribute("totalQuestions", totalQueCount);
		model.addAttribute("totalPass", totalPassStudents);
		
		return "admin/dashboard";
	}

	public String getDonutChart(Model model) {
		List<Exam> exam = this.examService.getExam();
		List<Integer> labelList = new ArrayList<Integer>();
		List<Integer> valueList = new ArrayList<Integer>();
		int totalFailedStudents = 0;
		for (Exam ex : exam) {
			labelList.add(ex.getExamYear());
			valueList.add(ex.getTotalPass());
			totalFailedStudents = totalFailedStudents + ex.getTotalFailed();
		}
		valueList.add(totalFailedStudents);
        model.addAttribute("donutValueArray",valueList);
        model.addAttribute("donutLabelArray",labelList);
     
		return "admin/dashboard";
	}
	
	public String getBarChart(Model model) {
		List<Exam> exam = this.examService.getExam();
		List<Integer> passValueList = new ArrayList<Integer>();
		List<Integer> failedValueList = new ArrayList<Integer>();
		List<Integer> totalValueList = new ArrayList<Integer>();
		for (Exam ex : exam) {
			passValueList.add(ex.getTotalPass());
			failedValueList.add(ex.getTotalFailed());
			totalValueList.add(ex.getTotalStudents());
		}
        model.addAttribute("passValueArray",passValueList);
        model.addAttribute("failedValueArray",failedValueList);
        model.addAttribute("totalValueArray", totalValueList);
		return "admin/dashboard";
	}
}
