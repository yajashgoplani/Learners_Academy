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

import entity.teacher;
import util.HibernateX;

/**
 * Servlet implementation class deleteteacherservlet
 */
public class deleteteacherservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteteacherservlet() {
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
			System.out.println(request.getParameter("teacher_id"));
			Service service= new Service();
			int t1=service.deleteTeacher(Integer.parseInt(request.getParameter("teacher_id")));
			  if(t1==0) {
				  out.println("<h3 style='color:red'>Teacher Not Found!! Having ID number:"+request.getParameter("teacher_id")+"</h3>");
				  rd.include(request, response);  
			  }
			  out.println("<h3 style='color:red'>Teacher Deleted Successfully! Having ID number:"+request.getParameter("teacher_id")+"</h3>");		  
			  rd.include(request, response);
		}
	}

}
