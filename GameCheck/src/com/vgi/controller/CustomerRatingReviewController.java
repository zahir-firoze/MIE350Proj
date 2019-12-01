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
import com.vgi.dao.ProductDao;
import com.vgi.dao.VideoGameDao;
import com.vgi.model.CustomerRatingReview;

/**
 * Servlet implementation class CustomerRatingReviewController
 */

public class CustomerRatingReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerRatingReviewDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    private static String TEST_CRR_OUTPUT = "/crr_test.jsp";
    //goes to the page that retrieve user's email to create/delete/modify a review
    private static String RETRIEVE_EMAIL_FOR_REVIEW_OPS = "/Email_Review_Index.jsp";
    private static String CONFIRMATION_PAGE = "/RatingReview_Confirmation_Page.jsp";
    private static String WRITE_REVIEW_GIVE_RATING = "/WriteReview_GiveRating_Index.jsp";
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
		String action =  request.getParameter("action");
		String forward = ""; //forwards the user to the page based on action they want to perform
		
		
		//the user wants to delete a review; check that the review belongs to them
		if(action.equals("confirmDelete")){
			//redirect to jsp to get the current user email to confirm the deletion
			forward = RETRIEVE_EMAIL_FOR_REVIEW_OPS;
			//System.out.println("upc from confirmDelete " + request.getParameter("upc"));
			//System.out.println("originalEmail from confirmDelete " + request.getParameter("email"));
			//pass the review's email and upc number to that confirm page
			request.setAttribute("upcNumber",request.getParameter("upc"));
			request.setAttribute("action","performDelete");
			request.setAttribute("originalEmail",request.getParameter("email"));
			request.setAttribute("servlet",request.getParameter("servlet"));
			request.setAttribute("operationForReview", "DELETE");
			
		}
		else if (action.equals("performDelete")){
			forward = CONFIRMATION_PAGE;
			String email = request.getParameter("Email");
			System.out.println("email inputted " + email);
			String originalEmail = request.getParameter("originalEmail");
			System.out.println("originalEmail inputted " + originalEmail);
			int upc = Integer.parseInt(request.getParameter("upc"));
			String outputMessage = "";
			//check if the emails are equal
			if(originalEmail.equals(email)){
				//perform deletion
				outputMessage = dao.deleteRatingReview(email, upc);
			}
			else{
				outputMessage = "ERROR: You do not have permission to delete this review";
			}
			//the product that the user is deleting can be a videogame or accessory; must call appropriate controller
			request.setAttribute("servlet",request.getParameter("servlet"));
			request.setAttribute("outputMessage", outputMessage);
			//upc number is needed so the user can go back to game page they were writing a review for
			request.setAttribute("upc",upc);
		}
		
		else if(action.equals("confirmUpdate")){
			//redirect to jsp to get the current user email to confirm the deletion
			forward = RETRIEVE_EMAIL_FOR_REVIEW_OPS;
			//System.out.println("upc from confirmDelete " + request.getParameter("upc"));
			//System.out.println("originalEmail from confirmDelete " + request.getParameter("email"));
			
			//pass the review's email and upc number to update page
			request.setAttribute("upcNumber",request.getParameter("upc"));
			
			request.setAttribute("originalEmail",request.getParameter("email"));
			
			//we need to get the updated rating and review from user
			request.setAttribute("action","retrieveUpdateInformation"); 
			
			request.setAttribute("servlet",request.getParameter("servlet"));
			request.setAttribute("operationForReview", "MODIFY");
			
		}
		else if(action.equals("retrieveUpdateInformation")){
			//confirm that the original review email and newly entered one match
			String email = request.getParameter("Email");
			String originalEmail = request.getParameter("originalEmail");
			int upc = Integer.parseInt(request.getParameter("upc"));
			String outputMessage = "";
			String productName = "ACCESSORY";
			String servlet = "AccessoryController";
			
			System.out.println("email inputted " + email);
			System.out.println("originalEmail inputted " + originalEmail);
			
			
			//check if the emails are equal
			if(originalEmail.equals(email)){
				// present the user with the update page
				forward = WRITE_REVIEW_GIVE_RATING;
				
				//retrieve the name of the product to review
				//use product dao to see what type of product the upc number maps to
				ProductDao pDao = new ProductDao();
				
				if(pDao.isVideoGame(upc)){
					VideoGameDao vgDao = new VideoGameDao();
					productName = vgDao.retrieveVideoGame(upc).getConsole() + " > " + vgDao.retrieveVideoGame(upc).getTitle();
				}
				//TODO Write one for accessory too
				//retrieve old review content
				request.setAttribute("reviewContent", dao.retrieveRatingReview(email, upc).getReview());
				request.setAttribute("product", productName);
				//set parameters for the write review page
				request.setAttribute("action","performUpdate"); 
				request.setAttribute("email",email);
				request.setAttribute("operation","Update Review");
				request.setAttribute("submitLabel","UPDATE");
			}
			else{
				forward = CONFIRMATION_PAGE;
				outputMessage = "ERROR: You do not have permission to modify this review";
				//the product that the user is updating can be a videogame or accessory; must call appropriate controller
				//use product dao to see what type of product the upc number maps to
				ProductDao pDao = new ProductDao();
				
				//change servlet to post to if the upc is for a videogame
				if(pDao.isVideoGame(upc)){
					VideoGameDao vgDao = new VideoGameDao();
					servlet = "VideoGameController";
				}
				
				request.setAttribute("servlet",servlet);
			}
			
			request.setAttribute("outputMessage", outputMessage);
			//upc number is needed so the user can go back to game page they were writing a review for
			request.setAttribute("upc",upc);
			
		}
		else if (action.equals("performUpdate")){
			
			forward = CONFIRMATION_PAGE;
			String email = request.getParameter("email");
			int upc = Integer.parseInt(request.getParameter("upc"));
			double rating; 
			String reviewText;
			
			//check for null values for star rating
			if(request.getParameter("rating") == null){
				rating = 0.0; 
			}
			else{
				rating = Double.parseDouble(request.getParameter("rating"));
			}
			
			//check for null values for the review textbox
			if (request.getParameter("review-textbox") == null){
				reviewText="";
			}
			else{
				reviewText = request.getParameter("review-textbox");
			}
			CustomerRatingReview crr = new CustomerRatingReview();
			
			//the servlet that determines which type of product page to go back to when user
			//wants to leave confirmation page
			String servlet ="AccessoryController";
			//create new customer rating review object so the database can be updated
			crr.setEmail(email);
			crr.setRating(rating);
			crr.setReview(reviewText);
			crr.setUPCNumber(upc);
			
			//get appropriate output message for confirmation page
			request.setAttribute("outputMessage", dao.updateRatingReview(crr));
			
			 //the product that the user is updating can be a videogame or accessory; must call appropriate controller
			//use product dao to see what type of product the upc number maps to
			ProductDao pDao = new ProductDao();
			
			//change servlet to post to if the upc is for a videogame
			if(pDao.isVideoGame(upc)){
				VideoGameDao vgDao = new VideoGameDao();
				servlet = "VideoGameController";
			}
			
			request.setAttribute("servlet",servlet);
			//upc number is needed so the user can go back to game page they were writing a review for
			request.setAttribute("upc",upc);
			 
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
