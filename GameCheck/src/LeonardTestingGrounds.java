

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vgi.dao.ConsoleDao;
import com.vgi.dao.StoreDao;
import com.vgi.dao.VideoGameDao;
import com.vgi.dao.InventoryDao;

/**
 * Servlet implementation class LeonardTestingGrounds
 */
@WebServlet("/LeonardTestingGrounds")
public class LeonardTestingGrounds extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//The jsp where your dao output will show up
	private static String OUTPUT_PAGE = "/LeonardTestingGrounds.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeonardTestingGrounds() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher view = request
			.getRequestDispatcher(OUTPUT_PAGE);

	/*		
	 
	VideoGameDao dao = new VideoGameDao(); //declared your dao object here
	
	//format your parameters here 
	//THE STUFF BELOW IS A PLACEHOLDER SO YOU CAN SEE HOW THE JSP WORKS
	//REMOVE THE TEXT OR COMMENT IT WHEN YOU ARE USING THIS SERVLET
	HashMap<String,Object> input = new HashMap<String,Object>();
	
	input.put("Price",19.99);
	
	System.out.println(input.toString());
	

	
	//you can set as many attributes as you want to the request
	//just specify the name of the attribute in the <c:out value="${attribute1}" />  elements :)
	request.setAttribute("attribute1", dao.getFilteredVideoGames(input)); //put the return object from your dao here
	request.setAttribute("attribute2", input.toString());
	
	*/

	
/*	InventoryDao dao = new InventoryDao();
	int upc = 454965;
	request.setAttribute("attribute1", dao.getProductInventory(upc));
	view.forward(request, response);
	System.out.println(dao.getProductInventory(upc).toString());*/
	
/*	ConsoleDao cdao = new ConsoleDao();
	String name = "Playstation 4";
	request.setAttribute("attribute1", cdao.getConsoleInfo(name));
	view.forward(request, response);
	System.out.println(cdao.getConsoleInfo(name).toString());*/
	
	StoreDao sdao = new StoreDao();
	int storeid = 1;
	request.setAttribute("attribute1", sdao.getStore(storeid));
	view.forward(request, response);
	System.out.println(sdao.getStore(storeid).toString());
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
