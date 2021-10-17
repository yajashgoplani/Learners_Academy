package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String username;
	@Column
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(int id, String firstname, String lastname, String username, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ ", password=" + password + "]";
	}
	public User(String firstname, String lastname, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	
//	public static void main(String[] args)
//	{
//		User u1=new User("Rahul", "Kumar", "rahulkumar", "password");
//		User u2=new User("Rahul1", "Kumar1", "rahulkumar1", "password1");
//		User u3=new User("Rahul2", "Kumar2", "rahulkumar2", "password2");
//		User u4=new User("Rahul3", "Kumar3", "rahulkumar3", "password3");
//		User u5=new User("Rahul4", "Kumar4", "rahulkumar4", "password4");		
//		
//		
//		Session session=HibernateX.getsession();
//		
//		session.beginTransaction();
//		
//		session.save("User", u1);
//		session.save("User", u2);
//		session.save("User", u3);
//		session.save("User", u4);
//		session.save("User", u5);
//		
//		session.getTransaction().commit();
//		session.getSessionFactory().close();
//		session.close();
//		
//	}
	
	
	
	
}
