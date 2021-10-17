package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dao.User;
import util.HibernateX;

public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public loginservlet() {
        super();
        
    }

	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//User u1=new User();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Session session=HibernateX.getsession();
		
		List<User> userlist=session.createNativeQuery("Select * from User", User.class).getResultList();
		
		session.getSessionFactory().close();
		session.close();
		
		int x=0;
		String firstname="";
		for(User u:userlist)
		{
			if(u.getUsername().equals(username))
			{
				if(u.getPassword().equals(password))
				{
					x++;
					firstname=u.getFirstname();
				}
			}
		}
		
		if(x==1)
		{
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("firstname", firstname);
			response.sendRedirect("success.jsp");
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			out.println("<h4>Invalid Credentials!!!</h4><br/>");
			rd.include(request, response);
		}
			
		
		
		
	}

}
