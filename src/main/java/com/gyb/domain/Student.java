package com.gyb.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

 



 
@Entity
@Table(name="Students")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String studentName;
	
	private Boolean sex;
	private Date birthday;
	 
	private School school;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE})
	@JoinColumn(name="school_Id")
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	
	@Id
	@SequenceGenerator(name="an_seq", sequenceName="hibernate_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="an_seq")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;   
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="BirthDay")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
