package com.javainuse.service;

import java.util.List;

import com.javainuse.model.AttributeValue;
import com.javainuse.model.Marks;


public interface MarksService {
	void insertMark(Marks emp);
	void insertMarks(List<Marks> employees);
	List<Marks> getAllMarks();
	void getMarksByCodeandUSN(String code, String USN);
	List <Marks> getMarksbyValue (AttributeValue attr);
	Integer getSGPA (AttributeValue attr);
}
