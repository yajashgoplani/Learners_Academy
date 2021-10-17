package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dao.class_students;
import util.HibernateX;

/**
 * Servlet implementation class assignstudentservlet
 */
public class assignstudentservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assignstudentservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/HTML");
		if(request.getSession(false).getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
		else {
			String[] stud_ids = request.getParameterValues("assignstudentids");
			String stud_class = request.getParameter("selectedclassforstudents");
			String stud_section = request.getParameter("selectedsectionforstudents");
			if(stud_ids==null) {
//				out.println("<h2 style='color:red;font-weight:bold;'>Select Students Before Assigning!!!</h2>");
				request.getRequestDispatcher("assign_student.jsp").include(request, response);
				out.println("<script>document.getElementById('errorspace').innerHTML='Select Students Before Assigning!!!';</script>");
				
			} else {
				int studs_ids[]=new int[stud_ids.length];
				for(int i=0;i<stud_ids.length;i++) {studs_ids[i]=Integer.parseInt(stud_ids[i]);  System.out.println("sel stud id :: "+stud_ids[i]);}
				System.out.println(stud_class);
				System.out.println(stud_section);
				
				for(int stid:studs_ids) {
					class_students st=new class_students(stid, stud_class, stud_section);
					Session getsession = HibernateX.getsession();
					getsession.beginTransaction();
					getsession.save("class_students", st);
					getsession.getTransaction().commit();
					getsession.close();
				}
				
				request.getRequestDispatcher("success.jsp").include(request, response);
				out.println("<script>document.getElementById('messagespace').innerHTML='"+studs_ids.length+" Student(s) have been added to class "+stud_class+" of section "+stud_section+"';</script>");
				
				
			}
			
			
			
			
		}
	}

}
