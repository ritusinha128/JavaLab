package com.javainuse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.dao.StudentDao;
import com.javainuse.model.AttributeValue;
import com.javainuse.model.Student;
import com.javainuse.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao employeeDao;

	@Override
	public void insertEmployee(Student employee) {
		employeeDao.insertStudent(employee);
	}

	@Override
	public void insertEmployees(List<Student> employees) {
		employeeDao.insertStudents(employees);
	}

	public List<Student> getAllEmployees() {
		return employeeDao.getAllStudents();
	}

	@Override
	public Student getEmployeeById(String empId) {
		Student employee = employeeDao.getStudentById(empId);
		return (employee);
	}

	@Override
	public List<Student> getEmployee(AttributeValue attr) {
		// TODO Auto-generated method stub
		return employeeDao.getStudents(attr);
	}

	@Override
	public void deleteStudent(Student attr) {
		// TODO Auto-generated method stub
		employeeDao.deleteStudents(attr);
	}
	
	

}