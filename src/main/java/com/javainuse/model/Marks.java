package com.javainuse.model;

public class Marks {
	String Student_USN, Grade, Sub_code;
	Integer Sem;
	public String getStudent_USN() {
		return Student_USN;
	}
	public void setStudent_USN(String student_USN) {
		Student_USN = student_USN;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	public String getSub_code() {
		return Sub_code;
	}
	public void setSub_code(String sub_code) {
		Sub_code = sub_code;
	}
	public Integer getSem() {
		return Sem;
	}
	public void setSem(Integer sem) {
		Sem = sem;
	}
	@Override
	public String toString() {
		return "Marks [Student_USN=" + Student_USN + ", Grade=" + Grade + ", Sub_code=" + Sub_code + ", Sem=" + Sem
				+ "]";
	}

}
