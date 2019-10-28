package com.banksteel.bean;

public class User {
	private String userName;
	private Integer age;
	private Double salary;
	private boolean sex;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", age=" + age + ", salary=" + salary + ", sex=" + sex + "]";
	}
	
}
