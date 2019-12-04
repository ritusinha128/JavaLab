package com.javainuse.service;

import java.util.List;

import com.javainuse.model.Subject;


public interface SubjectService {
	void insertSubject(Subject emp);
	void insertSubjects(List<Subject> employees);
	List<Subject> getAllSubjects();
	void getSubjectByCode(String code);
}
