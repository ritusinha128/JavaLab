package com.javainuse.dao;

import java.util.List;

import com.javainuse.model.Subject;


public interface SubjectDao {
	void insertSubject(Subject cus);
	void insertSubjects(List<Subject> employees);
	List<Subject> getAllSubjects();
	Subject getSubjectByCode(String code);

}
