package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table
public class Student {
	@Id
	@SequenceGenerator(name = "student_sequence",
	sequenceName = "student_sequence",
	allocationSize = 1)
	@GeneratedValue(generator = "student_sequence",
	strategy =GenerationType.SEQUENCE)
	private Long id;
	private String name;
	@Transient
	private Integer age;
	private String email;
	private LocalDate dob;
	public Student() {
		super();
	}
	public Student(Long id, String name, String email, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		
		this.email = email;
		this.dob = dob;
	}
	public Student(String name, String email, LocalDate dob) {
		super();
		this.name = name;
		
		this.email = email;
	this.dob = dob;
	}
	

	
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}
	public String getEmail() {
		return email;
	}
	public LocalDate getDob() {
		return dob;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", dob=" + dob + "]";
	}

}
