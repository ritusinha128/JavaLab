package com.javainuse.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.javainuse.dao.StudentDao;
import com.javainuse.model.AttributeValue;
import com.javainuse.model.Student;

@Repository
public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	@Override
	public void insertStudent(Student emp) {
		String sql = "INSERT INTO student " +
				"(USN, Name, Category, City, Branch, Sem, Gender, DOB) VALUES (?, ?, ?, ?, ?, ?, ?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				emp.getUSN(), emp.getName(), emp.getCategory(), emp.getCity(), emp.getbranch(), emp.getSem(),emp.getGender(),emp.getDob()
		});
	}
	
	@Override
	public void insertStudents(final List<Student> employees) {
		String sql = "INSERT INTO student " + "(USN, Name, Category, City, Branch, Sem, Gender, DOB) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Student employee = employees.get(i);
				ps.setString(1, employee.getUSN());
				ps.setString(2, employee.getName());
				ps.setString(3, employee.getCategory());
				ps.setString(4, employee.getCity());
				ps.setString(5, employee.getbranch());
				ps.setInt(6, employee.getSem());
				ps.setString(7, employee.getGender());
				ps.setString(8, employee.getDob());
			}
			
			public int getBatchSize() {
				return employees.size();
			}
		});

	}
	@Override
	public List<Student> getAllStudents(){
		String sql = "SELECT * FROM student";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Student> result = new ArrayList<Student>();
		for(Map<String, Object> row:rows){
			Student emp = new Student();
			emp.setUSN((String)row.get("USN"));
			emp.setName((String)row.get("Name"));
			emp.setCategory((String)row.get("Category"));
			emp.setCity((String)row.get("City"));
			emp.setbranch((String)row.get("Branch"));
			emp.setSem((Integer)row.get("Sem"));
			emp.setGender((String)row.get("Gender"));
			emp.setDob((String)row.get("dob"));
			result.add(emp);
		}
		
		return result;
	}

	@Override
	public Student getStudentById(String empId) {
		String sql = "SELECT * FROM student WHERE USN = ?";
		return (Student)getJdbcTemplate().queryForObject(sql, new Object[]{empId}, new RowMapper<Student>(){
			@Override
			public Student mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Student emp = new Student();
				emp.setUSN(rs.getString("USN"));
				emp.setName(rs.getString("Name"));
				emp.setCategory(rs.getString("Category"));
				emp.setCity(rs.getString("City"));
				emp.setbranch(rs.getString("Branch"));
				emp.setSem(rs.getInt("Sem"));
				emp.setGender(rs.getString("Gender"));
				emp.setDob(rs.getString("dob"));
				return emp;
			}
		});
	}

	@Override
	public List<Student> getStudents(AttributeValue attr) {
		// TODO Auto-generated method stub
		String sql;
		if (attr.getAttribute().equalsIgnoreCase("sem"))
		{
			Integer val = Integer.parseInt(attr.getValue());
			sql = "SELECT * FROM student WHERE " + attr.getAttribute() + "=" + val;
		}
		else
		{
		sql = "SELECT * FROM student WHERE " + attr.getAttribute() + "=" + attr.getValue();
		}
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Student> result = new ArrayList<Student>();
		for(Map<String, Object> row:rows){
			Student emp = new Student();
			emp.setUSN((String)row.get("USN"));
			emp.setName((String)row.get("Name"));
			emp.setCategory((String)row.get("Category"));
			emp.setCity((String)row.get("City"));
			emp.setbranch((String)row.get("Branch"));
			emp.setSem((Integer)row.get("Sem"));
			emp.setGender((String)row.get("Gender"));
			emp.setDob((String)row.get("dob"));
			result.add(emp);
		}
		
		return result;
	}
}