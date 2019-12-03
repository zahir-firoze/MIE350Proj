package com.vgi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vgi.dao.ConsoleDao;


/**
 * Servlet implementation class ConsoleController
 */

public class ConsoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONSOLE_HOMEPAGE_3DS = "/3dsHomePage.jsp";
	private static final String CONSOLE_HOMEPAGE_SWITCH = "/SwitchHomePage.jsp";   
	private static final String CONSOLE_HOMEPAGE_PLAYSTATION_4 = "/Ps4HomePage.jsp"; 
	private static final String CONSOLE_HOMEPAGE_XBOX = "/XboxHomePage.jsp"; 
	private static final String CONSOLE_HOMEPAGE_PSVITA = "/PsvitaHomePage.jsp"; 
	
	private ConsoleDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsoleController() {
        super();
        dao = new ConsoleDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String forward = "";
		//give the request dispatched a default value
		RequestDispatcher view = request.getRequestDispatcher(CONSOLE_HOMEPAGE_3DS);
		String action = request.getParameter("action");
		
		//when the action is display, redirect user to the console home page
		//the console home page contains all games for a specific console
		if (action.equals("display")){
			
			String consoleName = request.getParameter("name");
			
			//forward to corresponding home pages based on console name parameter
			if (consoleName.equals("3DS")){
				 view = request.getRequestDispatcher(CONSOLE_HOMEPAGE_3DS);
			}
			else if (consoleName.equals("Switch")){
				 view = request.getRequestDispatcher(CONSOLE_HOMEPAGE_SWITCH);
			}
			else if (consoleName.equals("Playstation 4")){
				 view = request.getRequestDispatcher(CONSOLE_HOMEPAGE_PLAYSTATION_4);
			}
			else if (consoleName.equals("Xbox One")){
				 view = request.getRequestDispatcher(CONSOLE_HOMEPAGE_XBOX);
			}
			else if (consoleName.equals("PS Vita")){
				 view = request.getRequestDispatcher(CONSOLE_HOMEPAGE_PSVITA);
			}
			
			
			//retrieve a Console object whose info will be displayed in the console home page
			request.setAttribute("Console", dao.getConsoleInfo(consoleName));
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
