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

import com.javainuse.dao.MarkDao;
import com.javainuse.model.AttributeValue;
import com.javainuse.model.Marks;
import com.javainuse.model.Subject;

@Repository
public class MarkDaoImpl extends JdbcDaoSupport implements MarkDao {
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	@Override
	public void insertMark(Marks cus) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO marks " +
				"(Student_USN, Sub_code, Grade, Sem) VALUES (?, ?, ?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				cus.getStudent_USN(), cus.getSub_code(), cus.getGrade(), cus.getSem()
		});
	}
	

	@Override
	public void insertMarks(List<Marks> employees) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO marks " + "(Student_USN, Sub_code, Grade, Sem) VALUES (?, ?, ?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Marks employee = employees.get(i);
				ps.setString(1, employee.getStudent_USN());
				ps.setString(2, employee.getSub_code());
				ps.setString(3, employee.getGrade());
				ps.setInt(4, employee.getSem());
			}
			
			public int getBatchSize() {
				return employees.size();
			}
		});
	}

	@Override
	public List<Marks> getAllMarks() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM marks";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Marks> result = new ArrayList<Marks>();
		for(Map<String, Object> row:rows){
			Marks emp = new Marks();
			emp.setStudent_USN((String)row.get("Student_USN"));
			emp.setSub_code((String)row.get("Sub_code"));
			emp.setSem((Integer)row.get("Sem"));
			emp.setGrade((String)row.get("Grade"));
			result.add(emp);
		}
		
		return result;
	}

	@Override
	public Marks getMarkByCodeandUSN(String code, String USN) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM marks WHERE Sub_code = ? AND Student_USN = ?";
		return (Marks)getJdbcTemplate().queryForObject(sql, new Object[]{code}, new RowMapper<Marks>(){
			@Override
			public Marks mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Marks emp = new Marks();
				emp.setStudent_USN(rs.getString("Student_USN"));
				emp.setSub_code(rs.getString("Sub_code"));
				emp.setGrade(rs.getString("Grade"));
				emp.setSem(rs.getInt("Sem"));
				return emp;
			}
		});
	}

	@Override
	public List<Marks> getMarksbyValue(AttributeValue attr) {
		// TODO Auto-generated method stub
		String sql;
		if (attr.getAttribute().equalsIgnoreCase("sem"))
		{
			Integer val = Integer.parseInt(attr.getValue());
			sql = "SELECT * FROM marks WHERE " + attr.getAttribute() + "=" + val;
		}
		else
		{
		 sql = "SELECT * FROM marks WHERE " + attr.getAttribute() + "=" + "'" + attr.getValue() + "'";
		}
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Marks> result = new ArrayList<Marks>();
		for(Map<String, Object> row:rows){
			Marks emp = new Marks();
			emp.setStudent_USN((String)row.get("Student_USN"));
			emp.setSub_code((String)row.get("Sub_code"));
			emp.setSem((Integer)row.get("Sem"));
			emp.setGrade((String)row.get("Grade"));
			result.add(emp);
		}
		
		return result;
	}

	@Override
	public Integer getCGPA(AttributeValue attr) {
		// TODO Auto-generated method stub
		String sql;
		Integer sgpa = 0;
		Integer val = Integer.parseInt(attr.getValue());
		sql = "SELECT Grade, Credits FROM Marks,Subject WHERE Code=Sub_code AND Student_USN=" + attr.getAttribute() + " AND Sem=" + val;
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		for (Map <String, Object> row:rows)
		{
			Integer credits = (Integer)row.get("Credits");
			String grade = (String)row.get("Grade");
			if (grade.equals("S+"))
			{
				sgpa += 10*credits;
			}
			else if (grade.equals("S"))
			{
				sgpa += 9*credits;
			}
			else if (grade.equals("A"))
			{
				sgpa += 8*credits;
			}
			else if (grade.equals("B"))
			{
				sgpa += 7*credits;
			}
			else if (grade.equals("C"))
			{
				sgpa += 6*credits;
			}
			else if (grade.equals("D"))
			{
				sgpa += 4*credits;
			}
			else 
			{
				sgpa += 0;
			}
		}
		return sgpa;
		
	}
	
	

}
