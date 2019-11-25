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





import com.vgi.constants.FilterConstants;
import com.vgi.dao.AccessoryDao;
import com.vgi.dao.VideoGameDao;
import com.vgi.tuple.PriceRange;
/**
 * Servlet implementation class AccessoryController
 */
@WebServlet("/AccessoryController")
public class AccessoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AccessoryDao dao;
	
	
	private static String LIST_FILTER_RESULTS = "/FilterResults_Accessory.jsp";
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
		/*RequestDispatcher view = request
				.getRequestDispatcher(TEST_LIST_FILTER_RESULTS);
		request.setAttribute("accessories", dao.getFilteredAccessories(input));
		request.setAttribute("accFilters",input.toString());
		view.forward(request, response);*/
		//*************filter accessories action END********************


		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String inputSource =  request.getParameter("filterForm"); //get doPost parameter from the filter form for Accessory
		boolean requestReceived = false;
		//see if the doPost was called by the filter form for Accessory
		if (inputSource.equals("accessory")){
			/*
			 * !!!!!!KEEP THE HASH KEY VALUES CONSTANT AS THEY ARE THE DATABASE COLUMN NAMES FOR VIDEOGAME TABLE
			 */
			String userQuery =""; //this will display what the user searched for in SimpleText
			requestReceived = true; // we received a request!
			/*
			 * Create the hashmap object that will be used in doGet in order to filter the games by specified categories
			 */
			HashMap<String,Object> input = new HashMap<String,Object>();
			/*
			 * Format all the inputs to their appropriate values in order to be sent to the doGet method
			 */
			String priceValue = request.getParameter("priceFilter");
			//only add price to filter query if user does not specify "All Price Ranges"
			if(!priceValue.equals("price0")){
				PriceRange pr;
				String userPrice=""; //portray the price in a simple format for results page
				
				//determine which price range will be used in the query
				if(priceValue.equals("price1")){
					userPrice="<$" + FilterConstants.PRICE_1_UPPER_BOUND;
					pr = new PriceRange(FilterConstants.PRICE_1_UPPER_BOUND, false );
				}
				else if(priceValue.equals("price2")){
					userPrice="$"+FilterConstants.PRICE_2_LOWER_BOUND + "-$" + FilterConstants.PRICE_2_UPPER_BOUND;
					pr = new PriceRange(FilterConstants.PRICE_2_LOWER_BOUND,FilterConstants.PRICE_2_UPPER_BOUND);
				}
				else if(priceValue.equals("price3")){
					userPrice="$"+FilterConstants.PRICE_3_LOWER_BOUND+ "-" + FilterConstants.PRICE_3_UPPER_BOUND;
					pr = new PriceRange(FilterConstants.PRICE_3_LOWER_BOUND,FilterConstants.PRICE_3_UPPER_BOUND);
				}
				else {
					userPrice=">$" + FilterConstants.PRICE_4_LOWER_BOUND;
					pr = new PriceRange(FilterConstants.PRICE_4_LOWER_BOUND, true);
				}
				userQuery = userQuery + "Price is " + userPrice +", ";
				input.put("Price", pr);
				
			}
			
			String consoleValue = request.getParameter("consoleFilter");
			//only add console to filter query if user does not specify "All Consoles"
			if (!consoleValue.equals("console0")){
				userQuery = userQuery + " ConsoleCompatibility is " + consoleValue +",";
				input.put("ConsoleCompatibility", consoleValue);
			}
			
			System.out.println("================================");
			System.out.println("These are the Filters applied " + input.toString());
			
			//prepare the request and send it to the "Filter Results" page for Videogames
			RequestDispatcher view = request
					.getRequestDispatcher(LIST_FILTER_RESULTS);
			request.setAttribute("userQuery", userQuery);
			request.setAttribute("accessories", dao.getFilteredAccessories(input));
			view.forward(request, response);
		}

		
        //doGet(request, response);
		
	}

}
