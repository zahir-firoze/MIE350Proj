package com.vgi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vgi.dao.AccessoryDao;
import com.vgi.dao.CustomerRatingReviewDao;
import com.vgi.model.CustomerRatingReview;

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
    
    private static String TEST_CRR_OUTPUT = "/crr_test.jsp";
    
    public CustomerRatingReviewController() {
        super();
        dao = new CustomerRatingReviewDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	
		//add test
		CustomerRatingReview crr = new CustomerRatingReview();
		
		crr.setEmail("ciel.emond@gmail.com");
		crr.setRating(3.2);
		crr.setReview("hallo this will work");
		crr.setUPCNumber(1234567);
		RequestDispatcher view = request
				.getRequestDispatcher(TEST_CRR_OUTPUT );
		
		//retrieve a VideoGame object whose info will be displayed in the product page
		request.setAttribute("outputMessage", dao.getProductAverageRating(454965));
		//TODO put store info, reviews and inventory request.setAttribute
		view.forward(request, response);
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
