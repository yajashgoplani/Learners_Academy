package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dao.subject;
import util.HibernateX;

/**
 * Servlet implementation class addsubjectservlet
 */
public class addsubjectservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addsubjectservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
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
			subject s1=new subject(request.getParameter("subject_class"), request.getParameter("subject_name"));
			Session session=HibernateX.getsession();
			session.beginTransaction();
			
			session.save("subject", s1);
			
			session.getTransaction().commit();
			session.getSessionFactory().close();
			session.close();
			
			
			out.println("<h3>Subject Added</h3>");
			out.println("<h3>Subject Name :-"+s1.getSubjectName()+"</h3>");
			out.println("<h3>Subject intended for class :-"+s1.getSubjectForClass()+"</h3>");
			
			rd.include(request, response);
		}
	}

}
