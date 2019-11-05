package com.vgi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vgi.dao.AccessoryDao;
import com.vgi.dao.CustomerRatingReviewDao;

/**
 * Servlet implementation class CustomerRatingReviewController
 */
@WebServlet("/CustomerRatingReviewController")
public class CustomerRatingReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerRatingReviewDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRatingReviewController() {
        super();
        dao = new CustomerRatingReviewDao();
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
		out.println("<p><b>This is the CustomerRatingReviewController Servlet from doGet method</b> </p>");
		out.println("</body>");
		out.println("</html>");
		
		// TODO add new actions accordingly
//				/**
//				 * This class retrieves the appropriate 'action' found on the JSP pages:
//				 * addReview - adds a written review for a product
//				 * addRating - adds a number rating
//				 * updateReview - updates a written review
//				 * deleteReview - deletes a review
//				 * deleteRating - deletes a rating
//				 */ 
//				 
//				 
//				 String forward = "";
//					String action = request.getParameter("addReview");
//					
//					//TODO
//					//establish appropriate logic for the filter and display functions
//					if (action.equalsIgnoreCase("addRating")) {
//						//int studentId = Integer.parseInt(request.getParameter("studentId"));
//						//dao.deleteStudent(studentId);
//						//forward = LIST_STUDENT_ADMIN;
//						//request.setAttribute("students", dao.getAllStudents());
//					} else if (action.equalsIgnoreCase("updateReview")) {
//						//forward = INSERT;
//						//request.setAttribute("students", dao.getAllStudents());
//					} else if (action.equalsIgnoreCase("deleteReview")) {
//						//forward = INSERT;
//						//request.setAttribute("students", dao.getAllStudents());
//					} else if (action.equalsIgnoreCase("deleteRating")) {
//						//forward = INSERT;
//						//request.setAttribute("students", dao.getAllStudents());
//					}
//					else{
//						//forward = display;
//					}
//					//RequestDispatcher view = request.getRequestDispatcher(forward);
//					//view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
