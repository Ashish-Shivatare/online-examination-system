package admin.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import admin.model.Exam;
import admin.service.AdminService;

@Controller
public class DashboardController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(path = "/dashboard")
	public String dashBoardHome(Model model) {
		this.exam(model);
		this.getDonutChart(model);
		this.getBarChart(model);
		return "dashboard";
	}
	
	public String exam(Model model) {
		List<Exam> exam = this.adminService.getExam();
		int totalRegStudents = 0;
		int totalQueCount = 0;
		int totalPassStudents = 0;

		for (Exam ex : exam) {
			totalRegStudents = totalRegStudents + ex.getTotalStudents();
			totalQueCount = totalQueCount + ex.getTotalQuestions();
			totalPassStudents = totalPassStudents + ex.getTotalPass();
		}
		System.out.println("Exam controller");
		model.addAttribute("totalStudents", totalRegStudents);
		model.addAttribute("totalQuestions", totalQueCount);
		model.addAttribute("totalPass", totalPassStudents);
		
		return "dashboard";
	}

	public String getDonutChart(Model model) {
		List<Exam> exam = this.adminService.getExam();
		System.out.println("DonutChart controller");
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
     
		return "dashboard";
	}
	
	public String getBarChart(Model model) {
		List<Exam> exam = this.adminService.getExam();
		System.out.println("BarChart controller");
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
     
		return "dashboard";
	}
}
