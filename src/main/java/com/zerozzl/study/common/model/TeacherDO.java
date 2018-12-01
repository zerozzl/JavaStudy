package com.zerozzl.study.common.model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "teacher")
public class TeacherDO implements Serializable {

	private static final long serialVersionUID = 8153050887340288910L;
	@Value("-1")
	private int id;
	@Value("default teacher")
	private String name;

	public TeacherDO() {
		super();
	}

	public TeacherDO(
			int id,
			String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + "]";
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

}
