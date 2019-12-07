package com.javainuse.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javainuse.model.AttributeValue;
import com.javainuse.model.Subject;
import com.javainuse.service.SubjectService;

@Controller
public class SubjectController {
	@Autowired
	SubjectService subjectService;

	@RequestMapping("/welcomesubject")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome_subject");
	}

	@RequestMapping(value = "/addNewSubject", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addSubject", "stud", new Subject());
	}

	@RequestMapping(value = "/addNewSubject", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("stud") Subject stud) {
		
		subjectService.insertSubject(stud);
		List<Subject> students = subjectService.getAllSubjects();
		ModelAndView model = new ModelAndView("getSubjects");
		model.addObject("students", students);
		return model;
	}

	@RequestMapping("/getSubjects")
	public ModelAndView getEmployees() {
		List<Subject> students = subjectService.getAllSubjects();
		ModelAndView model = new ModelAndView("getSubjects");
		model.addObject("students", students);
		return model;
	}
	
	@RequestMapping (value = "/getSubjectbyValues", method = RequestMethod.GET)
	public ModelAndView showval()
	{
		return new ModelAndView("getSubjectbyValue", "attr", new AttributeValue());
	}
	
	@RequestMapping (value = "/getSubjectbyValues", method = RequestMethod.POST)
	public ModelAndView process(@ModelAttribute("attr") AttributeValue attr)
	{
		List <Subject> students = subjectService.getSubjectbyValue(attr);
		ModelAndView model = new ModelAndView("getSubjects");
		model.addObject("students", students);
		return model;
	}
}

