package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class class_students {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	int student_id;
	String class_standard;
	String class_section;
	
	@OneToOne
	@JoinColumn(table = "student",name = "id")
	public student student;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
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
	public class_students(int id, int student_id, String class_standard, String class_section) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.class_standard = class_standard;
		this.class_section = class_section;
	}
	public class_students(int student_id, String class_standard, String class_section) {
		super();
		this.student_id = student_id;
		this.class_standard = class_standard;
		this.class_section = class_section;
	}
	public class_students() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "class_students [id=" + id + ", student_id=" + student_id + ", class_standard=" + class_standard
				+ ", class_section=" + class_section + "]";
	}
	
	

}
