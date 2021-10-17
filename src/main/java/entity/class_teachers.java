package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class class_teachers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	int teacher_id;
	String classstandard;
	String classsection;
	String subjectname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getClassstandard() {
		return classstandard;
	}
	public void setClassstandard(String classstandard) {
		this.classstandard = classstandard;
	}
	public String getClasssection() {
		return classsection;
	}
	public void setClasssection(String classsection) {
		this.classsection = classsection;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public class_teachers(int id, int teacher_id, String classstandard, String classsection, String subjectname) {
		super();
		this.id = id;
		this.teacher_id = teacher_id;
		this.classstandard = classstandard;
		this.classsection = classsection;
		this.subjectname = subjectname;
	}
	public class_teachers(int teacher_id, String classstandard, String classsection, String subjectname) {
		super();
		this.teacher_id = teacher_id;
		this.classstandard = classstandard;
		this.classsection = classsection;
		this.subjectname = subjectname;
	}
	public class_teachers() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "class_teachers [id=" + id + ", teacher_id=" + teacher_id + ", classstandard=" + classstandard
				+ ", classsection=" + classsection + ", subjectname=" + subjectname + "]";
	}
	
	
	
	
	

}
