package courseSystem.model;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class GetWebApplicationPathServlet extends HttpServlet {

    public GetWebApplicationPathServlet() {
    super();
    }
        protected String doGet() throws ServletException, IOException {
 
    String path = getServletContext().getRealPath("");
    return path;
    }
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
    }
}