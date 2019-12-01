package com.vgi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vgi.dao.CustomerRatingReviewDao;
import com.vgi.dao.InventoryDao;
import com.vgi.dao.StoreDao;
import com.vgi.dao.VideoGameDao;
import com.vgi.model.Inventory;
import com.vgi.model.Store;
import com.vgi.tuple.*;
import com.vgi.constants.*;

/**
 * Servlet implementation class VideoGameController
 */

public class VideoGameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private VideoGameDao dao;
	
	//TODO
	private static String LIST_HOME_FILTER_RESULTS = "/FilterResults_VideoGame.jsp";

	//3DS Console filter results
	private static String LIST_3DS_FILTER_RESULTS = "/FilterResults_3ds.jsp";
	//SWITCH Console filter results
	private static String LIST_SWITCH_FILTER_RESULTS = "/FilterResults_Switch.jsp";
	//PLAYSTATION 4 Console filter results
	private static String LIST_PLAYSTATION_4_FILTER_RESULTS = "/FilterResults_Ps4.jsp";
	//XBOX Console filter results
	private static String LIST_XBOX_FILTER_RESULTS = "/FilterResults_Xbox.jsp";
	//PSVITA Console filter results
	private static String LIST_PSVITA_FILTER_RESULTS = "/FilterResults_Psvita.jsp";
	
	private static String DISPLAY_GAME_INFORMATION = "/VideoGameInfoPage.jsp";
	//create constants for relevant jsp files
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoGameController() {
        super();
        dao = new VideoGameDao();
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
					.getRequestDispatcher(DISPLAY_GAME_INFORMATION );
			
			
			//retrieve a VideoGame object whose info will be displayed in the product page
			request.setAttribute("VideoGame", dao.retrieveVideoGame(upc));
			//retrieve a total number of reviews to display on the videogame page
			request.setAttribute("totalReviews", crrDao.getProductReviews(upc).size());
			//retrieve a list of reviews to display on the videogame page
			request.setAttribute("CRRList", crrDao.getReviewsForProductPage(upc));
			
			//get the average rating from CustomerReviewRating table
			request.setAttribute("averageRating",String.format("%.2f",crrDao.getProductAverageRating(upc)));
			
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
		
		/*
		 * This method gets information from input forms that are sent to the VideoGameController class
		 */
		//When a user wants to go back to video game page after creating/modifying/deleting a review
		String inputSource =  request.getParameter("filterForm");
		boolean requestReceived = false;
		String requestFromPresetConsole = "";
		
		if(inputSource.equals("false")){
			
			doGet(request,response);
		}
		//When a video game filter function sends a request
				
		
		
		if (inputSource.equals("videogame")){
			/*
			 * !!!!!!KEEP THE HASH KEY VALUES CONSTANT AS THEY ARE THE DATABASE COLUMN NAMES FOR VIDEOGAME TABLE
			 */
			requestFromPresetConsole = request.getParameter("presetConsole");
			requestReceived = true;
			String userQuery =""; //will format the user's filter query when results appear
			/*
			 * Create the hashmap object that will be used in doGet in order to filter the games by specified categories
			 */
			HashMap<String,Object> input = new HashMap<String,Object>();
			/*
			 * Format all the inputs to their appropriate values in order to be sent to the doGet method
			 */
			
			String genreValue = request.getParameter("genreFilter");
			//only add genre to filter query if user does not specify "All Games"
			if (!genreValue.equals("genre0")){
				userQuery = userQuery + genreValue +" Games, ";
				input.put("Genre",genreValue);
			}
			
			String yearValue = request.getParameter("yearFilter");
			//only add release year to filter query if user does not specify "All Years"
			if(!yearValue.equals("year0")){
				ReleaseDateRange rdr;
				String userYear = "";
				
				if (yearValue.equals("2015")){
					userYear = "<" + 2015;
					String oneSidedDate = yearValue + "-01-01";
					rdr = new ReleaseDateRange(oneSidedDate, false);
				}
				else if (yearValue.equals("2019")){
					userYear = ">" + 2019;
					String oneSidedDate = yearValue + "-01-01";
					rdr = new ReleaseDateRange(oneSidedDate, true);
				}
				else{
					userYear = yearValue;
					String startDate = yearValue + "-01-01";
					String endDate = yearValue + "-12-31";
					rdr = new ReleaseDateRange(startDate,endDate);
				}
				
				userQuery = userQuery + "released in " + userYear + ", ";
				input.put("Release_Date",rdr);
			}
			
			String priceValue = request.getParameter("priceFilter");
			//only add price to filter query if user does not specify "All Price Ranges"
			if(!priceValue.equals("price0")){
				PriceRange pr;
				String userPrice="";
				
				//determine which price range will be used in the query
				if(priceValue.equals("price1")){
					userPrice="<$" + String.format("%.2f",FilterConstants.PRICE_1_UPPER_BOUND);
					pr = new PriceRange(FilterConstants.PRICE_1_UPPER_BOUND, false );
				}
				else if(priceValue.equals("price2")){
					userPrice="$"+String.format("%.2f",FilterConstants.PRICE_2_LOWER_BOUND) + "-$" + String.format("%.2f",FilterConstants.PRICE_2_UPPER_BOUND);
					pr = new PriceRange(FilterConstants.PRICE_2_LOWER_BOUND,FilterConstants.PRICE_2_UPPER_BOUND);
				}
				else if(priceValue.equals("price3")){
					userPrice="$"+String.format("%.2f",FilterConstants.PRICE_3_LOWER_BOUND) + "-" + String.format("%.2f",FilterConstants.PRICE_3_UPPER_BOUND);
					pr = new PriceRange(FilterConstants.PRICE_3_LOWER_BOUND,FilterConstants.PRICE_3_UPPER_BOUND);
				}
				else {
					userPrice=">$" + String.format("%.2f",FilterConstants.PRICE_4_LOWER_BOUND);
					pr = new PriceRange(FilterConstants.PRICE_4_LOWER_BOUND, true);
				}
				userQuery = userQuery + " Price Range " + userPrice +",";
				input.put("Price", pr);
				
			}
			
			String consoleValue = request.getParameter("consoleFilter");
			//only add console to filter query if user does not specify "All Consoles"
			if (!consoleValue.equals("console0")){
				userQuery = userQuery + consoleValue +" Console,";
				input.put("Console", consoleValue);
			}
			
			String playerValue = request.getParameter("playerFilter");
			if (!playerValue.equals("player0")){
				MaxPlayer mp;
				String userPlayer="";
				//the user specified that they want games with more than 4 players
				if(playerValue.equals("moreThan4")){
					userPlayer = ">"+4;
					mp = new MaxPlayer(4,true);
				}
				//otherwise, just specify the number of players
				else{
					userPlayer = playerValue;
					int player = Integer.parseInt(playerValue);
					mp = new MaxPlayer(player);
				}
				userQuery = userQuery + " with maximum " + userPlayer + " players,";
				//add the player specification to the hashmap
				input.put("Max_Players", mp);
				
			}
			System.out.println("================================");
			System.out.println("These are the Filters applied " + input.toString());
			
			//prepare the request and send it to the appropriate "Filter Results" page for Videogames
			RequestDispatcher view = request
					.getRequestDispatcher(LIST_HOME_FILTER_RESULTS);
			
			//see if the console was preset
			String presetConsole = request.getParameter("presetConsole");
			
			if(presetConsole.equals("true")){
				
				//forward to corresponding home pages based on console name parameter
				if (consoleValue.equals("3DS")){
					 view = request.getRequestDispatcher(LIST_3DS_FILTER_RESULTS);
				}
				else if (consoleValue.equals("Switch")){
					 view = request.getRequestDispatcher(LIST_SWITCH_FILTER_RESULTS);
				}
				else if (consoleValue.equals("Playstation 4")){
					System.out.println(LIST_PLAYSTATION_4_FILTER_RESULTS );
					 view = request.getRequestDispatcher(LIST_PLAYSTATION_4_FILTER_RESULTS);
				}
				else if (consoleValue.equals("Xbox One")){
					 view = request.getRequestDispatcher(LIST_XBOX_FILTER_RESULTS);
				}
				else if (consoleValue.equals("PS Vita")){
					 view = request.getRequestDispatcher(LIST_PSVITA_FILTER_RESULTS);
				}
			}
			//request.setAttribute("vgFilters", input.toString());
			request.setAttribute("userQuery", userQuery);
			request.setAttribute("videogames", dao.getFilteredVideoGames(input));
			view.forward(request, response);
			
			
		}
		
	}

}
