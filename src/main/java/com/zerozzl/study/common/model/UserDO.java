package com.zerozzl.study.common.model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "user")
public class UserDO implements Serializable {

	private static final long serialVersionUID = 1898000128111707363L;
	@Value("-1")
	private int id;
	@Value("default user")
	private String name;
	@Value("10")
	private int age;
	@Autowired
	private TeacherDO teacher;

	public UserDO() {
		super();
	}

	public UserDO(
			int id,
			String name,
			int age) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.teacher = null;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", teacher="
				+ (teacher != null ? teacher.toString() : "") + "]";
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

	public TeacherDO getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherDO teacher) {
		this.teacher = teacher;
	}

}
