package com.javainuse.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
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


import org.springframework.beans.factory.annotation.Autowired;

import com.javainuse.dao.SubjectDao;
import com.javainuse.model.Student;
import com.javainuse.model.Subject;

@Repository
public class SubjectDaoImpl extends JdbcDaoSupport implements SubjectDao {
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	@Override
	public void insertSubject(Subject cus) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO subject " +
				"(Code, Sub_Name, Sub_sem, Credits) VALUES (?, ?, ?, ?)" ;
		getJdbcTemplate().update(sql, new Object[]{
				cus.getCode(), cus.getSub_name(), cus.getSub_sem(), cus.getCredits()
		});
	}

	@Override
	public void insertSubjects(List<Subject> employees) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO subject " + "(Code, Sub_Name, Sub_sem, Credits) VALUES (?, ?, ?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Subject employee = employees.get(i);
				ps.setString(1, employee.getCode());
				ps.setString(2, employee.getSub_name());
				ps.setInt(3, employee.getSub_sem());
				ps.setInt(4, employee.getCredits());
			}
			
			public int getBatchSize() {
				return employees.size();
			}
		});

	}

	@Override
	public List<Subject> getAllSubjects() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM subject";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Subject> result = new ArrayList<Subject>();
		for(Map<String, Object> row:rows){
			Subject emp = new Subject();
			emp.setCode((String)row.get("code"));
			emp.setSub_name((String)row.get("sub_name"));
			emp.setSub_sem((Integer)row.get("sub_sem"));
			emp.setCredits((Integer)row.get("credits"));
			result.add(emp);
		}
		
		return result;
	}

	@Override
	public Subject getSubjectByCode(String code) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM subject WHERE Code = ?";
		return (Subject)getJdbcTemplate().queryForObject(sql, new Object[]{code}, new RowMapper<Subject>(){
			@Override
			public Subject mapRow(ResultSet rs, int rwNumber) throws SQLException {
				Subject emp = new Subject();
				emp.setCode(rs.getString("code"));
				emp.setSub_name(rs.getString("sub_name"));
				emp.setSub_sem(rs.getInt("sub_sem"));
				emp.setCredits(rs.getInt("credits"));
				return emp;
			}
		});
		
	}

}
