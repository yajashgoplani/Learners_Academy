package servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

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
			RequestDispatcher rd=request.getRequestDispatcher("delete_subject.jsp");
			System.out.println(request.getParameter("subject_id"));
			
			
			   
			  Session session=HibernateX.getsession();
			  session.beginTransaction();
			  subject t1=session.get(subject.class,Integer.parseInt(request.getParameter("subject_id")));
			  
			  if(t1==null) {
				  session.getTransaction().commit();
				  session.close();
				  out.println("<h3 style='color:red'>Subject Not Found!! Having ID number:"+request.getParameter("subject_id")+"</h3>");
				  rd.include(request, response);
				 
				  
			  }
			  session.delete("subject", t1);
//			  try {
//				  class_students s1=session.get(class_students.class,Integer.parseInt(request.getParameter("teacher_id")));
//				  session.delete("class_students", s1);
//			  }
//			  finally {
//				  System.out.println("All records deleted");
//			  }
			  
			  session.getTransaction().commit(); session.getSessionFactory().close();
			  session.close();
			  
			  
			  out.println("<h3 style='color:green'>Subject Deleted Successfully! Having ID number:"+t1.getId()+"</h3>");
			  
			  rd.include(request, response);
			 
			
			
			
		}
	}
}


