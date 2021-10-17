package servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.class_students;
import entity.student;
import util.HibernateX;

/**
 * Servlet implementation class deletestudentservlet
 */
public class deletestudentservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletestudentservlet() {
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
			RequestDispatcher rd=request.getRequestDispatcher("delete_student.jsp");
			System.out.println(request.getParameter("student_id"));
			
			
			   
			  Session session=HibernateX.getsession();
			  session.beginTransaction();
			  student t1=session.get(student.class,Integer.parseInt(request.getParameter("student_id")));
			  
			  if(t1==null) {
				  session.getTransaction().commit();
				  session.close();
				  out.println("<h3 style='color:red'>Student Not Found!! Having ID number:"+request.getParameter("student_id")+"</h3>");
				  rd.include(request, response);	  
			  }
			  session.delete("student", t1);
			  session.createNativeQuery("delete from class_students where student_id="+Integer.parseInt(request.getParameter("student_id"))).executeUpdate();
			  
			  
//			  try {
//				  class_students s1=session.get(class_students.class,Integer.parseInt(request.getParameter("student_id")));
//				  session.delete("class_students", s1);
//			  }catch(Exception e) {
//				  System.out.println(e.getMessage());
//				  e.printStackTrace();
//				  System.out.println("Seems like student not found in class_students table");
//			  }
			 
			  
			  session.getTransaction().commit();
			  session.close();
			  
			  
			  out.println("<h3 style='color:green'>Student Deleted Successfully! Having ID number:"+t1.getId()+"</h3>");
			  
			  rd.include(request, response);
			 
			
			
			
		}
	}
	

}
