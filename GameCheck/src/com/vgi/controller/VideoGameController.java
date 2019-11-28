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
	private static String LIST_FILTER_RESULTS = "/FilterResults_VideoGame.jsp";
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

		PrintWriter out = response.getWriter();
		String forward = "";
		String action = request.getParameter("action");
		if (action.equals("display")){
			
			int upc = Integer.parseInt(request.getParameter("upc"));
		
			
			RequestDispatcher view = request
					.getRequestDispatcher(DISPLAY_GAME_INFORMATION );
			
			//retrieve a VideoGame object whose info will be displayed in the product page
			request.setAttribute("VideoGame", dao.retrieveVideoGame(upc));
			//TODO put store info, reviews and inventory request.setAttribute
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * This method gets information from the HomePage.jsp when someone utilizes the filter feature
		 */
		
		String inputSource =  request.getParameter("filterForm");
		//TODO add logic to redirect the filter results to their corresonding page if they
		//are already sorted by console
		String requestFromPresetConsole = request.getParameter("presetConsole");
		boolean requestReceived = false;
		if (inputSource.equals("videogame")){
			/*
			 * !!!!!!KEEP THE HASH KEY VALUES CONSTANT AS THEY ARE THE DATABASE COLUMN NAMES FOR VIDEOGAME TABLE
			 */
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
				userQuery = userQuery + "Genre is " + genreValue +", ";
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
				
				userQuery = userQuery + "Year is " + userYear + ", ";
				input.put("Release_Date",rdr);
			}
			String priceValue = request.getParameter("priceFilter");
			//only add price to filter query if user does not specify "All Price Ranges"
			if(!priceValue.equals("price0")){
				PriceRange pr;
				String userPrice="";
				
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
				userQuery = userQuery + " Price is " + userPrice +",";
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
				userQuery = userQuery + " Number of Players is " + userPlayer + ",";
				//add the player specification to the hashmap
				input.put("Max_Players", mp);
				
			}
			System.out.println("================================");
			System.out.println("These are the Filters applied " + input.toString());
			
			//prepare the request and send it to the "Filter Results" page for Videogames
			RequestDispatcher view = request
					.getRequestDispatcher(LIST_FILTER_RESULTS);
			//request.setAttribute("vgFilters", input.toString());
			request.setAttribute("userQuery", userQuery);
			request.setAttribute("videogames", dao.getFilteredVideoGames(input));
			view.forward(request, response);
			
			
		}
		
	}

}
