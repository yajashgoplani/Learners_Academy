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

import com.service.Service;

import entity.User;
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
		
		Service serv= new Service();
		
		
		
		int x=serv.validateUser(username, password);
		String firstname="";
		firstname=username;
		
		
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
