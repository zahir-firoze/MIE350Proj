package com.vgi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vgi.dao.AccessoryDao;
import com.vgi.dao.VideoGameDao;
/**
 * Servlet implementation class AccessoryController
 */
@WebServlet("/AccessoryController")
public class AccessoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AccessoryDao dao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessoryController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new AccessoryDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p><i>This is the AccessoryController doGet page</i></p>");
		out.println("</body>");
		out.println("</html>");
//		// TODO add new actions accordingly
//		/**
//		 * This class retrieves the appropriate 'action' found on the JSP pages:
//		 * filter - filter list of games based on attribute(s)
//		 * display - displays the video game information
//		 */ 
//		 
//		 
//		 String forward = "";
//			String action = request.getParameter("action");
//			
//			//TODO
//			//establish appropriate logic for the filter and display functions
//			if (action.equalsIgnoreCase("filter")) {
//				//int studentId = Integer.parseInt(request.getParameter("studentId"));
//				//dao.deleteStudent(studentId);
//				//forward = LIST_STUDENT_ADMIN;
//				//request.setAttribute("students", dao.getAllStudents());
//			} else if (action.equalsIgnoreCase("display")) {
//				//forward = INSERT;
//				//request.setAttribute("students", dao.getAllStudents());
//			}
//			else{
//				//forward = display;
//			}
//			//RequestDispatcher view = request.getRequestDispatcher(forward);
//			//view.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
