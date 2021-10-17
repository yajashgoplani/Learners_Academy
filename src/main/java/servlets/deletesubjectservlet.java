package servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.service.Service;

import entity.subject;
import util.HibernateX;

/**
 * Servlet implementation class deletesubjectservlet
 */
public class deletesubjectservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletesubjectservlet() {
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
			System.out.println(request.getParameter("subject_id"));
			Service service= new Service();
			int t1=service.deleteSubject(Integer.parseInt(request.getParameter("subject_id")));  
			  if(t1==1) {
				  out.println("<h3 style='color:red'>Subject Not Found!! Having ID number:"+request.getParameter("subject_id")+"</h3>");
				  rd.include(request, response);
			  }
			  out.println("<h3 style='color:green'>Subject Deleted Successfully! Having ID number:"+request.getParameter("subject_id")+"</h3>");
			  rd.include(request, response);
		}
	}
}


