package com.javainuse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javainuse.model.Student;
import com.javainuse.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}

	@RequestMapping(value = "/addNewStudent", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addStudent", "stud", new Student());
	}

	@RequestMapping(value = "/addNewStudent", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("stud") Student stud) {
		
		studentService.insertEmployee(stud);
		List<Student> students = studentService.getAllEmployees();
		ModelAndView model = new ModelAndView("getStudents");
		model.addObject("students", students);
		return model;
	}

	@RequestMapping("/getStudents")
	public ModelAndView getEmployees() {
		List<Student> students = studentService.getAllEmployees();
		ModelAndView model = new ModelAndView("getStudents");
		model.addObject("students", students);
		return model;
	}
	
	@RequestMapping(value = "/getStudentbyUSN", method = RequestMethod.GET)
	public ModelAndView showusn(@RequestParam String id)
	{
		ModelAndView model = new ModelAndView ("getStudentbyUSN");
		Student student = studentService.getEmployeeById(id);
		model.addObject(student);
		return model;
	}

}
