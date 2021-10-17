package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class class_subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	int subject_id;
	String class_standard;
	String class_section;
	@Column(name = "teacher_id",nullable = true)
	Integer teacher_id;
	
	
	public class_subject(int id, int subject_id, String class_standard, String class_section, int teacher_id) {
		super();
		this.id = id;
		this.subject_id = subject_id;
		this.class_standard = class_standard;
		this.class_section = class_section;
		this.teacher_id = teacher_id;
	}
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	public class_subject(int subject_id, String class_standard, String class_section) {
		super();
		this.subject_id = subject_id;
		this.class_standard = class_standard;
		this.class_section = class_section;
	}
	public class_subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public class_subject(int id, int subject_id, String class_standard, String class_section) {
		super();
		this.id = id;
		this.subject_id = subject_id;
		this.class_standard = class_standard;
		this.class_section = class_section;
	}
	@Override
	public String toString() {
		return "class_subject [id=" + id + ", subject_id=" + subject_id + ", class_standard=" + class_standard
				+ ", class_section=" + class_section + ", teacher_id=" + teacher_id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getClass_standard() {
		return class_standard;
	}
	public void setClass_standard(String class_standard) {
		this.class_standard = class_standard;
	}
	public String getClass_section() {
		return class_section;
	}
	public void setClass_section(String class_section) {
		this.class_section = class_section;
	}


}
