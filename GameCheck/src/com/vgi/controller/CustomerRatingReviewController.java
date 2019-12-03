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
    private static String VIEW_ALL_REVIEWS = "/AllReviewsPage.jsp";
    public CustomerRatingReviewController() {
        super();
        dao = new CustomerRatingReviewDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String action =  request.getParameter("action");
		String forward = ""; //forwards the user to the page based on action they want to perform
		
		//before seeing which action to perform, see what  type of product that the customer is reviewing or rating
		ProductDao pDao = new ProductDao();
		String servlet;
		int upc = Integer.parseInt(request.getParameter("upc"));
		//change servlet to post to if the upc is for a videogame
		
		if(pDao.isVideoGame(upc)){
			servlet = "VideoGameController";
		}
		else{
			servlet = "AccessoryController";
		}
		
		if(action.equals("viewAllReviews")){
			forward = VIEW_ALL_REVIEWS;
			String productName = " ";
			if(pDao.isVideoGame(upc)){
				VideoGameDao vgDao = new VideoGameDao();
				productName = vgDao.retrieveVideoGame(upc).getConsole() + " > " + vgDao.retrieveVideoGame(upc).getTitle();
			}
			//TODO put accessory logic
			request.setAttribute("upc", upc);
			request.setAttribute("servlet", servlet);
			request.setAttribute("reviewList", dao.getProductReviews(upc));
			request.setAttribute("product", productName);
		}
		else if(action.equals("confirmAddRating")){
			//redirect to jsp to get the current user email to confirm the deletion
			forward = RETRIEVE_EMAIL_FOR_REVIEW_OPS;
			System.out.println("the entered rating is " + request.getParameter("rating"));
			//pass the review's email and upc number to that confirm page
			request.setAttribute("upcNumber",request.getParameter("upc"));
			request.setAttribute("action","performAddRating");
			request.setAttribute("rating", request.getParameter("rating"));
			request.setAttribute("operationForReview", "ADD");
			
		}
		else if (action.equals("performAddRating")){
			forward = CONFIRMATION_PAGE;
			String email = request.getParameter("Email");
			//int upc = Integer.parseInt(request.getParameter("upc"));
			double rating; 
			String reviewText;
			
			String outputMessage = "";
			//String servlet = "AccessoryController";
			//ProductDao pDao = new ProductDao();
			
			//add customer review
			CustomerRatingReview crr = new CustomerRatingReview();
			
			
			if(dao.retrieveRatingReview(email, upc)== null){	
				//check for null or empty values for star rating
				if(request.getParameter("newRating") == null || request.getParameter("newRating").isEmpty() ){
					rating = 0.0; 
				}
				else{
					rating = Double.parseDouble(request.getParameter("newRating"));
				}
				
				//check for null values for the review textbox
				if (request.getParameter("review-textbox") == null){
					reviewText="";
				}
				else{
					reviewText = request.getParameter("review-textbox");
				}
				crr.setEmail(email);
				crr.setRating(rating);
				crr.setReview(reviewText);
				crr.setUPCNumber(upc);
				
				System.out.println("crr " + crr);
				
				outputMessage = dao.addRatingReview(crr);
			}
			
			else{
				forward = CONFIRMATION_PAGE;
				outputMessage = "ERROR: You already created a review. Please locate your review and UPDATE it.";
				
			}
			
			//the product that the user is rating can be a videogame or accessory; must call appropriate controller
			//use product dao to see what type of product the upc number maps to
			ProductDao productDao = new ProductDao();
			
			//change servlet to post to if the upc is for a videogame
			if(productDao.isVideoGame(upc)){
				servlet = "VideoGameController";
			}
			
			request.setAttribute("servlet",servlet);
			request.setAttribute("outputMessage", outputMessage);
			//upc number is needed so the user can go back to game page they were writing a review for
			request.setAttribute("upc",upc);
			
		}
		
		
		else if(action.equals("confirmAddReview")){
			//redirect to jsp to get the current user email to confirm the deletion
			forward = RETRIEVE_EMAIL_FOR_REVIEW_OPS;
			
			//pass the review's email and upc number to that confirm page
			request.setAttribute("upcNumber",request.getParameter("upc"));
			request.setAttribute("action","retrieveNewReview");
			request.setAttribute("originalEmail",request.getParameter("email"));
			request.setAttribute("operationForReview", "ADD");
		}
		else if (action.equals("retrieveNewReview")){
			String email = request.getParameter("Email");
			//int upc = Integer.parseInt(request.getParameter("upc"));
			String outputMessage = "";
			
			
			String productName = "ACCESSORY";
			
			
			//if they are a new user, create one for them
			if(dao.retrieveRatingReview(email, upc)== null){
				
				// present the user with the write review page
				forward = WRITE_REVIEW_GIVE_RATING;
				
				//retrieve the name of the product to review
				//use product dao to see what type of product the upc number maps to
				//ProductDao pDao = new ProductDao();
				
				if(pDao.isVideoGame(upc)){
					VideoGameDao vgDao = new VideoGameDao();
					productName = vgDao.retrieveVideoGame(upc).getConsole() + " > " + vgDao.retrieveVideoGame(upc).getTitle();
				}
				//TODO Write one for accessory too
				
				
				//request.setAttribute("reviewContent","");
				request.setAttribute("product", productName);
				
				//set parameters for the write review page
				request.setAttribute("action","performAddReview"); 
				request.setAttribute("email",email);
				request.setAttribute("operation","Add Review");
				request.setAttribute("submitLabel","ADD");
			}
			else{
				forward = CONFIRMATION_PAGE;
				outputMessage = "ERROR: You already created a review. Please locate your review and UPDATE it.";
				
				request.setAttribute("servlet",servlet);
			}
			
			request.setAttribute("outputMessage", outputMessage);
			//upc number is needed so the user can go back to game page they were writing a review for
			request.setAttribute("upc",upc);
			
		}
		else if (action.equals("performAddReview")){
			forward = CONFIRMATION_PAGE;
			String email = request.getParameter("email");
			//int upc = Integer.parseInt(request.getParameter("upc"));
			double rating; 
			String reviewText;
			
			String outputMessage = "";
			
			//add customer review
			CustomerRatingReview crr = new CustomerRatingReview();
			
			
			
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
			crr.setEmail(email);
			crr.setRating(rating);
			crr.setReview(reviewText);
			crr.setUPCNumber(upc);
			
			
			outputMessage = dao.addRatingReview(crr);
			

			
			request.setAttribute("servlet",servlet);
			request.setAttribute("outputMessage", outputMessage);
			//upc number is needed so the user can go back to game page they were writing a review for
			request.setAttribute("upc",upc);
		}
		//the user wants to delete a review; check that the review belongs to them
		else if(action.equals("confirmDelete")){
			//redirect to jsp to get the current user email to confirm the deletion
			forward = RETRIEVE_EMAIL_FOR_REVIEW_OPS;
			
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
			//int upc = Integer.parseInt(request.getParameter("upc"));
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
			//int upc = Integer.parseInt(request.getParameter("upc"));
			String outputMessage = "";
			String productName = "ACCESSORY";
			
			System.out.println("email inputted " + email);
			System.out.println("originalEmail inputted " + originalEmail);
			
			
			//check if the emails are equal
			if(originalEmail.equals(email)){
				// present the user with the update page
				forward = WRITE_REVIEW_GIVE_RATING;
				
				//retrieve the name of the product to review
				//use product dao to see what type of product the upc number maps to
				
				
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
			//if the emails do not match, send the user to confirmation page with an error message
			else{
				forward = CONFIRMATION_PAGE;
				outputMessage = "ERROR: You do not have permission to modify this review";
				//the product that the user is updating can be a videogame or accessory; must call appropriate controller
				//use product dao to see what type of product the upc number maps to
				//ProductDao pDao = new ProductDao();
				
				//change servlet to post to if the upc is for a videogame
//				if(pDao.isVideoGame(upc)){
//					VideoGameDao vgDao = new VideoGameDao();
//					servlet = "VideoGameController";
//				}
				
				request.setAttribute("servlet",servlet);
			}
			
			request.setAttribute("outputMessage", outputMessage);
			//upc number is needed so the user can go back to game page they were writing a review for
			request.setAttribute("upc",upc);
			
		}
		else if (action.equals("performUpdate")){
			
			forward = CONFIRMATION_PAGE;
			String email = request.getParameter("email");
			//int upc = Integer.parseInt(request.getParameter("upc"));
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
			//String servlet ="AccessoryController";
			//create new customer rating review object so the database can be updated
			crr.setEmail(email);
			crr.setRating(rating);
			crr.setReview(reviewText);
			crr.setUPCNumber(upc);
			
			//get appropriate output message for confirmation page
			request.setAttribute("outputMessage", dao.updateRatingReview(crr));
			
			 //the product that the user is updating can be a videogame or accessory; must call appropriate controller
			//use product dao to see what type of product the upc number maps to
			//ProductDao pDao = new ProductDao();
			
			//change servlet to post to if the upc is for a videogame
//			if(pDao.isVideoGame(upc)){
//				VideoGameDao vgDao = new VideoGameDao();
//				servlet = "VideoGameController";
//			}
			
			request.setAttribute("servlet",servlet);
			//upc number is needed so the user can go back to game page they were writing a review for
			request.setAttribute("upc",upc);
			 
		}
		System.out.println("servlet value is " + servlet);
		System.out.println("upc " + upc);
		request.setAttribute("servlet", servlet);
		request.setAttribute("upc",upc);
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}
