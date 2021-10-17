package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class classes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String ClassName;
	
	private String Class_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public String getClass_id() {
		return Class_id;
	}

	public void setClass_id(String class_id) {
		Class_id = class_id;
	}

	
	public classes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public classes(int id, String className, String class_id) {
		super();
		this.id = id;
		ClassName = className;
		Class_id = class_id;
	}

	@Override
	public String toString() {
		return "classes [id=" + id + ", ClassName=" + ClassName + ", Class_id=" + Class_id + "]";
	}
	
	
}
