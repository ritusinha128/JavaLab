package com.javainuse.model;

public class Student {

	private String USN;
	private String Name, category, city, gender, dob, branch;
	private Integer sem;
	public String getUSN() {
		return USN;
	}
	public void setUSN(String uSN) {
		USN = uSN;
	}
	public void setbranch (String branch)
	{
		this.branch = branch;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Integer getSem() {
		return sem;
	}
	public void setSem(Integer sem) {
		this.sem = sem;
	}
	public String getbranch ()
	{
		return branch;
	}
	

	/*@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}*/
	
	public String toString()
	{
		return "Student [USN=" + USN + ", Name=" + Name + " ,Category=" + category + " ,City=" + city + ",Branch:" + branch + " ,Sex" + gender + ",DOB=" + dob + " ,Sem=" + sem + "]";
	}

}