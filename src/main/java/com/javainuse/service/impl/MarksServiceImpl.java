package com.javainuse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.dao.MarkDao;
import com.javainuse.model.AttributeValue;
import com.javainuse.model.Marks;
import com.javainuse.service.MarksService;

@Service
public class MarksServiceImpl implements MarksService {
	@Autowired
	MarkDao marksdao; 
	@Override
	public void insertMark(Marks emp) {
		// TODO Auto-generated method stub
		marksdao.insertMark(emp);
	}

	@Override
	public void insertMarks(List<Marks> employees) {
		// TODO Auto-generated method stub
		marksdao.insertMarks(employees);
	}

	@Override
	public List<Marks> getAllMarks() {
		// TODO Auto-generated method stub
		return marksdao.getAllMarks();
	}

	@Override
	public void getMarksByCodeandUSN(String code, String USN) {
		// TODO Auto-generated method stub
		Marks marks = marksdao.getMarkByCodeandUSN(code,USN);
		System.out.println(marks);
	}

	@Override
	public List<Marks> getMarksbyValue(AttributeValue attr) {
		// TODO Auto-generated method stub
		return marksdao.getMarksbyValue(attr);
	}

	@Override
	public Integer getSGPA(AttributeValue attr) {
		// TODO Auto-generated method stub
		return marksdao.getCGPA(attr);
	}

}
