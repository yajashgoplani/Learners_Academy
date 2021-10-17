package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import dao.User;

import org.hibernate.Session;

import dao.User;
import util.HibernateX;

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
		out.println("<h4 style='color:red;font-weight:bold'>Try Again!</h4><br/>");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newpass = request.getParameter("newpassword");
    	String repass = request.getParameter("repassword");
    	String username = request.getParameter("username");
    	String firstname = request.getParameter("firstname");
    	String lastname = request.getParameter("lastname");
    	
    	int user_flag = 0;
    	int pass_flag = 0;
    	
    	response.setContentType("text/html");
    	Session session=HibernateX.getsession();
    	List<User> userlist=session.createNativeQuery("Select * from User", User.class).getResultList();
    	//Validations
    	if(!newpass.equals((String)repass))
        {
    		pass_flag++;
            
        }
         else
        {
            
        } 
    	
    	for(User u:userlist) {
	    	if(u.getUsername().equals(username))
		    	{
		    		user_flag++;
		    	}
		    	else {
		    		
		    	}
    	}
    	
    	if(user_flag>0) {	
    		response.setContentType("text/html");
	    	PrintWriter out=response.getWriter();
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			out.println("<h4 style='color:red;font-weight:bold'>Username has already been taken! Choose another!</h4><br/>");
			rd.include(request, response);
			
    	}
    	else if(pass_flag>0) {
    		response.setContentType("text/html");
    		PrintWriter out=response.getWriter();
    		RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
    		out.println("<h4 style='color:red;font-weight:bold'>Passwords do not match!</h4><br/>");
    		rd.include(request, response);
    	}
    	else {
    	
	    	// Signup Process
	    	User newUser=new User(firstname,lastname,username,newpass);
	    	
			session.beginTransaction();
			session.save("User", newUser);
			
			session.getTransaction().commit();
			session.getSessionFactory().close();
			session.close();
			
			PrintWriter out=response.getWriter();
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			out.println("<h4 style='color:green;font-weight:bold'>User succesfully added!</h4><br/>");
			rd.include(request, response);
    	}
    	
	}

}
