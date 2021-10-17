package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;


import dao.teacher;
import util.HibernateX;

/**
 * Servlet implementation class addteacherservlet
 */
public class addteacherservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addteacherservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
			teacher t1=new teacher(request.getParameter("teacher_name"), request.getParameter("teacher_dob"),String.valueOf(request.getParameter("teacher_phoneno")) ,request.getParameter("teacher_gender"));
			Session session=HibernateX.getsession();
			session.beginTransaction();
			
			session.save("teacher", t1);
			
			session.getTransaction().commit();
			session.getSessionFactory().close();
			session.close();
			
			
			out.println("<h3>Teacher Added</h3>");
			out.println("<h3>Teacher Name :-"+t1.getName()+"</h3>");
			out.println("<h3>Teacher DOB :-"+t1.getDOB()+"</h3>");
			out.println("<h3>Teacher Phone NO :-"+t1.getPhoneno()+"</h3>");
			out.println("<h3>Teacher Gender :-"+t1.getGender()+"</h3>");
			
			rd.include(request, response);
			
			
			
		}

}

}
