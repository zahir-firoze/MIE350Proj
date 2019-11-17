package com.vgi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vgi.dao.VideoGameDao;

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
				RequestDispatcher view = request
						.getRequestDispatcher(LIST_FILTER_RESULTS);
				
				request.setAttribute("videogames", dao.getFilteredVideoGames(input));
				request.setAttribute("vgFilters", input.toString());
				view.forward(request, response);
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
			requestReceived = true;
			/*
			 * Format all the inputs to their appropriate values in order to be sent to the doGet method
			 */
			String genreValue = request.getParameter("genreFilter");
			
			
		}
		
	}

}
