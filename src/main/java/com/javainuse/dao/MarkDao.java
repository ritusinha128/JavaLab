package com.javainuse.dao;

import java.util.List;

import com.javainuse.model.Marks;

public interface MarkDao {
	void insertMark(Marks cus);
	void insertMarks(List<Marks> employees);
	List<Marks> getAllMarks();
	Marks getMarkByCodeandUSN(String code,String USN);
}
