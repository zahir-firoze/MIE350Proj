package com.vgi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Date;
import java.text.SimpleDateFormat;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vgi.dao.VideoGameDao;
import com.vgi.tuple.*;
import com.vgi.constants.*;

/**
 * Servlet implementation class VideoGameController
 */
@WebServlet("/VideoGameController")
public class VideoGameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private VideoGameDao dao;
	
	//TODO
	private static String TEST_LIST_FILTER_RESULTS = "/TEST_displayFilterResults.jsp";
	private static String LIST_FILTER_RESULTS = "/FilterResults.jsp";
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

		boolean someValue = true;
		
		if (someValue){
			System.out.println("Byyyye");
		}//if
		//		PrintWriter out = response.getWriter();
//		String forward = "";
//		String action = request.getParameter("action");
//		System.out.println(action);
//		String filterTest = request.getParameter("playerFilter");
//		System.out.println(filterTest);
		
		//*************filter videogames action INPUT - REMOVE ONCE TESTING DONE********************
				HashMap<String,Object> input = new HashMap<String,Object>();
				
				input.put("Price",19.99);
				//input.put("Genre","Adventure");
				//input.put("ESRB_Rating","E");
				System.out.println(input.toString());
				//*************filter videogames action START********************
//				RequestDispatcher view = request
//						.getRequestDispatcher(TEST_LIST_FILTER_RESULTS);
				//RequestDispatcher view = request
					//	.getRequestDispatcher(LIST_FILTER_RESULTS);
				
				//request.setAttribute("videogames", dao.getFilteredVideoGames(input));
				//request.setAttribute("vgFilters", input.toString());
				//view.forward(request, response);
				//*************filter accessories action END********************
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * This method gets information from the HomePage.jsp when someone utilizes the filter feature
		 */
		
		String inputSource =  request.getParameter("filterForm");
		boolean requestReceived = false;
		if (inputSource.equals("videogame")){
			/*
			 * !!!!!!KEEP THE HASH KEY VALUES CONSTANT AS THEY ARE THE DATABASE COLUMN NAMES FOR VIDEOGAME TABLE
			 */
			requestReceived = true;
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
				input.put("Genre",genreValue);
			}
			
			String yearValue = request.getParameter("yearFilter");
			//only add release year to filter query if user does not specify "All Years"
			if(!yearValue.equals("year0")){
				ReleaseDateRange rdr;
				
				if (yearValue.equals("2015")){
					String oneSidedDate = yearValue + "-01-01";
					rdr = new ReleaseDateRange(oneSidedDate, false);
				}
				else if (yearValue.equals("2019")){
					String oneSidedDate = yearValue + "-01-01";
					rdr = new ReleaseDateRange(oneSidedDate, true);
				}
				else{
					String startDate = yearValue + "-01-01";
					String endDate = yearValue + "-12-31";
					rdr = new ReleaseDateRange(startDate,endDate);
				}
				
				input.put("Release_Date",rdr);
			}
			String priceValue = request.getParameter("priceFilter");
			//only add price to filter query if user does not specify "All Price Ranges"
			if(!priceValue.equals("price0")){
				PriceRange pr;
				
				//determine which price range will be used in the query
				if(priceValue.equals("price1")){
					pr = new PriceRange(FilterConstants.PRICE_1_UPPER_BOUND, false );
				}
				else if(priceValue.equals("price2")){
					pr = new PriceRange(FilterConstants.PRICE_2_LOWER_BOUND,FilterConstants.PRICE_2_UPPER_BOUND);
				}
				else if(priceValue.equals("price3")){
					pr = new PriceRange(FilterConstants.PRICE_3_LOWER_BOUND,FilterConstants.PRICE_3_UPPER_BOUND);
				}
				else {
					pr = new PriceRange(FilterConstants.PRICE_4_LOWER_BOUND, true);
				}
				input.put("Price", pr);
				
			}
			
			String consoleValue = request.getParameter("consoleFilter");
			//only add console to filter query if user does not specify "All Consoles"
			if (!consoleValue.equals("console0")){
				input.put("Console", consoleValue);
			}
			
			String playerValue = request.getParameter("playerFilter");
			if (!playerValue.equals("player0")){
				MaxPlayer mp;
				//the user specified that they want games with more than 4 players
				if(playerValue.equals("moreThan4")){
					mp = new MaxPlayer(4,true);
				}
				//otherwise, just specify the number of players
				else{
					int player = Integer.parseInt(playerValue);
					mp = new MaxPlayer(player);
				}
				
				//add the player specification to the hashmap
				input.put("Max_Players", mp);
				
			}
			
			
			//prepare the request and send it to the "Filter Results" page for Videogames
			RequestDispatcher view = request
					.getRequestDispatcher(LIST_FILTER_RESULTS);
			request.setAttribute("vgFilters", input.toString());
			request.setAttribute("videogames", dao.getFilteredVideoGames(input));
			view.forward(request, response);
			
			
		}
		
	}

}
