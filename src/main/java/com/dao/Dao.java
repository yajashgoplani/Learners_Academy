package com.dao;

import java.util.List;

import org.hibernate.Session;

import entity.User;
import entity.student;
import entity.subject;
import entity.teacher;
import util.HibernateX;

public class Dao {

	public List<User> getUsers()
	{

		Session session=HibernateX.getsession();
		List<User> userlist=session.createNativeQuery("Select * from User", User.class).getResultList();
		session.getSessionFactory().close();
		session.close();
		return userlist;
	}
	public int signUp(User user)
	{
		try {
		Session session=HibernateX.getsession();
		session.beginTransaction();
		session.save("User",user);
		session.getTransaction().commit();
		session.getSessionFactory().close();
		session.close();
		}
		catch(Exception e)
		{
			System.out.println("Try After Some time");
			return 0;
		}
		return 1;
	}
	public boolean addStudent(student stud)
	{
		try {
		Session session=HibernateX.getsession();
		session.beginTransaction();
		session.save("student", stud);
		session.getTransaction().commit();
		session.getSessionFactory().close();
		session.close();
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	public boolean addSubject(subject sub)
	{
		try {
			Session session=HibernateX.getsession();
			session.beginTransaction();
			session.save("subject", sub);
			session.getTransaction().commit();
			session.getSessionFactory().close();
			session.close();
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	public boolean addTeacher(teacher t1)
	{
		try {
			Session session=HibernateX.getsession();
			session.beginTransaction();
			session.save("teacher", t1);
			session.getTransaction().commit();
			session.getSessionFactory().close();
			session.close();
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	public int deleteSubject(int sub)
	{
		Session session=HibernateX.getsession();
		session.beginTransaction();
		subject t1=session.get(subject.class,sub);
		if(t1==null)
			return 0;
		session.delete("subject", t1);
		session.getTransaction().commit();
		session.close();
		return 1;
	}
	public int deleteTeacher(int teach)
	{
		Session session=HibernateX.getsession();
		session.beginTransaction();
		teacher t1=session.get(teacher.class,teach);
		if(t1==null)
			return 0;
		session.delete("teacher", t1);
		session.getTransaction().commit();
		session.close();
		return 1;
	}
	public int deleteStudent(int stud)
	{
		Session session=HibernateX.getsession();
		session.beginTransaction();
		student t1=session.get(student.class,stud);
		if(t1==null)
			return 0;
		session.delete("student", t1);
		session.getTransaction().commit();
		session.close();
		return 1;
	}
	
}
