package com.vgi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import com.vgi.constants.FilterConstants;
import com.vgi.dao.AccessoryDao;
import com.vgi.dao.CustomerRatingReviewDao;
import com.vgi.dao.InventoryDao;
import com.vgi.dao.StoreDao;
import com.vgi.dao.VideoGameDao;
import com.vgi.model.Inventory;
import com.vgi.model.Store;
import com.vgi.tuple.PriceRange;
import com.vgi.tuple.StoreAvailability;
/**
 * Servlet implementation class AccessoryController
 */

public class AccessoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AccessoryDao dao;
	
	
	private static String LIST_FILTER_RESULTS = "/FilterResults_Accessory.jsp";
	private static String DISPLAY_ACCESSORY_INFORMATION = "/AccessoryInfoPage.jsp";
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
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String forward = "";
		String action = request.getParameter("action");
		
		
		
		//if action is display, display the videogame information page
		if (action.equals("display")){
			CustomerRatingReviewDao crrDao = new CustomerRatingReviewDao();
			//get the upc number for the videogame
			int upc = Integer.parseInt(request.getParameter("upc"));
		
			
			RequestDispatcher view = request
					.getRequestDispatcher(DISPLAY_ACCESSORY_INFORMATION );
			
			
			//retrieve a VideoGame object whose info will be displayed in the product page
			request.setAttribute("Accessory", dao.retrieveAccessory(upc));
			//retrieve a total number of reviews to display on the videogame page
			request.setAttribute("totalReviews", crrDao.getProductReviews(upc).size());
			//retrieve a list of reviews to display on the accessory page
			request.setAttribute("CRRList", crrDao.getReviewsForProductPage(upc));
			
			//get the average rating from CustomerReviewRating table
			request.setAttribute("averageRating",crrDao.getProductAverageRating(upc));
			
			
			//get store inventory
			StoreDao stDao = new StoreDao();
			InventoryDao invDao = new InventoryDao();
			
			//will store the Store information and quantity of the product
			List<StoreAvailability> storeAvList = new ArrayList<StoreAvailability>();
			
			
			System.out.println("size of the inventory list " + invDao.getProductInventory(upc).size());
			//iterate through returned inventory list
			if (!invDao.getProductInventory(upc).isEmpty()){
				
				int inventoryListSize = invDao.getProductInventory(upc).size();
				for(int i = 0; i < inventoryListSize; i++){
					
					Inventory tempInventory = invDao.getProductInventory(upc).get(i);
					//get the store id
					int storeID = tempInventory.getStoreID();
					int quantity = tempInventory.getQuantity();
					//save the store that has the product into a temporary variable
					Store tempStore = new Store(stDao.getStore(storeID));
					
					StoreAvailability sA = new StoreAvailability(tempStore,quantity);
					storeAvList.add(sA);
					
					
				}
			}
			
			request.setAttribute("inventoryList", storeAvList);
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String inputSource =  request.getParameter("filterForm"); //get doPost parameter from the filter form for Accessory
		boolean requestReceived = false;
		
		if(inputSource.equals("false")){
			
			doGet(request,response);
		}
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
