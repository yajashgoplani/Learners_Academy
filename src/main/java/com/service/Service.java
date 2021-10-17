package com.service;

import java.util.List;

import com.dao.Dao;

import entity.User;
import entity.student;
import entity.subject;
import entity.teacher;

public class Service {
	private Dao d= new Dao();
	
	public int validateUser(String name,String password)
	{
		int x=0;
		String firstname="";
		List<User> userlist=d.getUsers();
		for(User u:userlist)
			if(u.getUsername().equals(name))
				if(u.getPassword().equals(password))
					x++;
		return x;
	}
	public int signUp(String newpass,String repass,String username,String firstname,String lastname)
	{
		User user=new User(firstname,lastname,username,newpass);
    	return d.signUp(user);
	}
	public boolean addStudent(student stud)
	{
		return d.addStudent(stud);
	}
	
	public boolean addSubject(subject sub)
	{
		return d.addSubject(sub);
	}
	
	public boolean addTeacher(teacher t1)
	{
		return d.addTeacher(t1);
	}
	
	public int deleteSubject(int sub)
	{
		return d.deleteSubject(sub);
	}
	public int deleteStudent(int stu)
	{
		return d.deleteStudent(stu);
	}
	public int deleteTeacher(int tea)
	{
		return d.deleteTeacher(tea);
	}
}
