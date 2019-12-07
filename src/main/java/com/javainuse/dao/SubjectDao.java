package com.javainuse.dao;

import java.util.List;

import com.javainuse.model.Subject;
import com.javainuse.model.AttributeValue;


public interface SubjectDao {
	void insertSubject(Subject cus);
	void insertSubjects(List<Subject> employees);
	List<Subject> getAllSubjects();
	Subject getSubjectByCode(String code);
	List<Subject>getSubjectbyValue(AttributeValue attr);
}
