package com.javainuse.model;

public class Subject {

	String code, sub_name;
	Integer sub_sem, credits;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	@Override
	public String toString()
	{
		return "SUBJECT: [ CODE=" + code + " ,NAME=" + sub_name + " ,SEM=" + sub_sem + " ,CREDITS=" + credits; 
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public Integer getSub_sem() {
		return sub_sem;
	}
	public void setSub_sem(Integer sub_sem) {
		this.sub_sem = sub_sem;
	}
}
