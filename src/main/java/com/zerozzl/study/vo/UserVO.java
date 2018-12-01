package com.zerozzl.study.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class UserVO implements Serializable {

	private static final long serialVersionUID = -4235499531422056819L;
	private int id;
	@NotNull
	private String name;
	private int age;
	@NumberFormat(pattern = "###,###.##")
	private float salary;
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;

	public UserVO() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", birthdate="
				+ (birthdate != null ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(birthdate) : "") + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

}
