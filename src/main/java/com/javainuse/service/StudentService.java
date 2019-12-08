package com.javainuse.service;

import java.util.List;

import com.javainuse.model.AttributeValue;
import com.javainuse.model.Student;

public interface StudentService {
	void insertEmployee(Student emp);
	void insertEmployees(List<Student> employees);
	List<Student> getAllEmployees();
	Student getEmployeeById(String empid);
	List <Student> getEmployee(AttributeValue attr);
	void deleteStudent(Student attr);
}