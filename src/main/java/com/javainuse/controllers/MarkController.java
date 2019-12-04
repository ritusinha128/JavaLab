package com.javainuse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javainuse.model.Marks;
import com.javainuse.model.Subject;
import com.javainuse.service.MarksService;
import com.javainuse.service.SubjectService;

@Controller
public class MarkController {
	@Autowired
	MarksService markService;

	@RequestMapping("/welcomemarks")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome_mark");
	}

	@RequestMapping(value = "/addNewMark", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addMark", "stud", new Marks());
	}

	@RequestMapping(value = "/addNewMark", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("stud") Marks stud) {
		
		markService.insertMark(stud);
		List<Marks> students = markService.getAllMarks();
		ModelAndView model = new ModelAndView("getMarks");
		model.addObject("students", students);
		return model;
	}

	@RequestMapping("/getMarks")
	public ModelAndView getEmployees() {
		List<Marks> marks = markService.getAllMarks();
		ModelAndView model = new ModelAndView("getMarks");
		model.addObject("students", marks);
		return model;
	}
}
