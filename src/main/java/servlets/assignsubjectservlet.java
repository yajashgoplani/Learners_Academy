package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dao.class_subject;
import util.HibernateX;

/**
 * Servlet implementation class assignsubjectservlet
 */
public class assignsubjectservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assignsubjectservlet() {
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
			String[] sub_ids = request.getParameterValues("assignsubjectids");
			String stud_class = request.getParameter("selectedclassforstudents");
			String stud_section = request.getParameter("selectedsectionforstudents");
			if(sub_ids==null) {
//				out.println("<h2 style='color:red;font-weight:bold;'>Select Students Before Assigning!!!</h2>");
				request.getRequestDispatcher("assign_subject.jsp").include(request, response);
				out.println("<script>document.getElementById('errorspace').innerHTML='Select Subjects Before Assigning!!!';</script>");
				
			} else {
				int subss_ids[]=new int[sub_ids.length];
				for(int i=0;i<sub_ids.length;i++) {subss_ids[i]=Integer.parseInt(sub_ids[i]);  System.out.println("sel stud id :: "+sub_ids[i]);}
				System.out.println(stud_class);
				System.out.println(stud_section);
				
				for(int stid:subss_ids) {
					class_subject st=new class_subject(stid, stud_class, stud_section);
					Session getsession = HibernateX.getsession();
					getsession.beginTransaction();
					getsession.save("class_subject", st);
					getsession.getTransaction().commit();
					getsession.close();
				}
				
				request.getRequestDispatcher("success.jsp").include(request, response);
				out.println("<script>document.getElementById('messagespace').innerHTML='"+subss_ids.length+" Subject(s) have been added to class "+stud_class+" of section "+stud_section+"';</script>");
				
				
			}
			
			
			
			
		}
	}
}


