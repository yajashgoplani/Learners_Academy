package servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import entity.class_subject;
import util.HibernateX;

/**
 * Servlet implementation class assignteacherservlet
 */
public class assignteacherservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assignteacherservlet() {
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
			String teacher_id = request.getParameterValues("teacherid")[0];
			String sub_id = request.getParameterValues("subjectid")[0];
			String stud_class = request.getParameter("selectedstandard");
			String stud_section = request.getParameter("selectedsection");
			if(teacher_id==null || sub_id==null) {
//				out.println("<h2 style='color:red;font-weight:bold;'>Select Students Before Assigning!!!</h2>");
				request.getRequestDispatcher("allot_subject.jsp").include(request, response);
				out.println("<script>document.getElementById('errorspace').innerHTML='Select Students Before Assigning!!!';</script>");
				
			} else {
				System.out.println(teacher_id);
				System.out.println(sub_id);
				System.out.println(stud_class);
				System.out.println(stud_section);
				
//				class_subject st=new class_subject(stid, stud_class, stud_section);
				Session getsession = HibernateX.getsession();
				getsession.beginTransaction();
				class_subject subject = getsession.load(class_subject.class, Integer.parseInt(sub_id));
				subject.setTeacher_id(Integer.parseInt(teacher_id));
				getsession.update(subject);
				getsession.getTransaction().commit();
				getsession.close();
				
				request.getRequestDispatcher("success.jsp").include(request, response);
				out.println("<script>document.getElementById('messagespace').innerHTML='"+" Teacher having ID "+teacher_id+" been assigned to class "+stud_class+" of section "+stud_section+"';</script>");
				
				
			}
			
			
			
			
		}
	}
}

