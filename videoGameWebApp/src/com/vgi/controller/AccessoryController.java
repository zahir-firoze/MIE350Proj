package com.vgi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
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
	/*
	 * Remove TEST_ constants once testing is completed
	 */
	private static String TEST_LIST_FILTER_RESULTS = "/TEST_displayFilterResults.jsp";
	
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

		
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<p><i>This is the AccessoryController doGet page</i></p>");
//		out.println("<p><i>There are " + rowCount + " rows in daddy's TODO table</p>");
//		out.println("</body>");
//		out.println("</html>");
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
		
//		ToDoDAO dao = new ToDoDAO();
//		int rowCount = dao.testDB();
//        Integer daddyInteger = new Integer(rowCount);
//		RequestDispatcher rd = request
//				.getRequestDispatcher(TEST_LIST_FILTER_RESULTS);    
//        request.setAttribute("daddyInt", daddyInteger);
//        rd.forward(request, response);
        
        
        
		//*************filter accessories action INPUT - REMOVE ONCE TESTING DONE********************
		HashMap<String,Object> input = new HashMap<String,Object>();
		
		input.put("Price",15.99);
		//input.put("ConsoleCompatibility","Nintendo3DS");
		
		//*************filter accessories action START********************
		RequestDispatcher view = request
				.getRequestDispatcher(TEST_LIST_FILTER_RESULTS);
		request.setAttribute("accessories", dao.getFilteredAccessories(input));
		request.setAttribute("accFilters",input.toString());
		view.forward(request, response);
		//*************filter accessories action END********************


		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		/** TODO: CHANGE DESCRIPTION ONCE THE METHOD IS FINALIZED
		 * This method posts the database query results
		 * Database query is dynamically created by the hashmap input
		 */
		
        doGet(request, response);
		
	}

}
