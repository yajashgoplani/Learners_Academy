package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String subjectForClass;
	
	private String subjectName;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectForClass() {
		return subjectForClass;
	}

	public void setSubjectForClass(String subjectForClass) {
		this.subjectForClass = subjectForClass;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}



	public subject(int id, String subjectForClass, String subjectName) {
		super();
		this.id = id;
		this.subjectForClass = subjectForClass;
		this.subjectName = subjectName;
	}

	public subject(String subjectForClass, String subjectName) {
		super();
		this.subjectForClass = subjectForClass;
		this.subjectName = subjectName;
	}

	public subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "subject [id=" + id + ", subjectForClass=" + subjectForClass + ", subjectName=" + subjectName + "]";
	}
	
	
	

}
