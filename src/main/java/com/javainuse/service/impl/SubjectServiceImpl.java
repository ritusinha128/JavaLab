package com.javainuse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.dao.SubjectDao;
import com.javainuse.model.AttributeValue;
import com.javainuse.model.Student;
import com.javainuse.model.Subject;
import com.javainuse.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	SubjectDao subjectdao; 
	@Override
	public void insertSubject(Subject emp) {
		// TODO Auto-generated method stub
			subjectdao.insertSubject(emp);
	}

	@Override
	public void insertSubjects(List<Subject> employees) {
		// TODO Auto-generated method stub
		subjectdao.insertSubjects(employees);
	}

	@Override
	public List<Subject> getAllSubjects() {
		// TODO Auto-generated method stub
		return subjectdao.getAllSubjects();
	}

	@Override
	public void getSubjectByCode(String code) {
		// TODO Auto-generated method stub
		Subject subject = subjectdao.getSubjectByCode(code);
		System.out.println(subject);
	}

	@Override
	public List<Subject> getSubjectbyValue(AttributeValue attr) {
		// TODO Auto-generated method stub
		return subjectdao.getSubjectbyValue(attr);
	}

}
