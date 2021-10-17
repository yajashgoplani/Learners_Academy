package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;

//import dao.User;
import dao.student;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.HibernateX;



public class addstudentservlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addstudentservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession(false).getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			student s1=new student(request.getParameter("student_name"), request.getParameter("student_dob"),String.valueOf(request.getParameter("student_phoneno")) ,request.getParameter("student_gender"));
			Session session=HibernateX.getsession();
			session.beginTransaction();
			
			session.save("student", s1);
			
			session.getTransaction().commit();
			session.getSessionFactory().close();
			session.close();
			
			
			out.println("<h3>Student Added</h3>");
			out.println("<h3>Student Name :-"+s1.getName()+"</h3>");
			out.println("<h3>Student DOB :-"+s1.getDOB()+"</h3>");
			out.println("<h3>Student Phone NO :-"+s1.getPhoneno()+"</h3>");
			out.println("<h3>Student Gender :-"+s1.getGender()+"</h3>");
			
			rd.include(request, response);
			
			
			
		}
		
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Get pushed");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
