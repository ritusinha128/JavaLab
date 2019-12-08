package com.javainuse.dao;

import java.util.List;

import com.javainuse.model.AttributeValue;
import com.javainuse.model.Student;

public interface StudentDao {
	void insertStudent(Student cus);
	void insertStudents(List<Student> employees);
	List<Student> getAllStudents();
	Student getStudentById(String empId);
	List<Student> getStudents(AttributeValue attr);
	void deleteStudents (Student attr);
}