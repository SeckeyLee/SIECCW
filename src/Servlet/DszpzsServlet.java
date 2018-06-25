package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "DszpzsServlet",urlPatterns = "/dszpzs")
public class DszpzsServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public DszpzsServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 HttpSession session =  request.getSession() ;
		   String qx = "o{1}[0-9]{5}";
			Pattern pattern = Pattern.compile(qx);
			String numpd = ((String)session.getAttribute("num")).trim();
			System.out.println(numpd);
			Matcher matcher = pattern.matcher(numpd);
			System.out.println(matcher.matches());
			if(matcher.matches() == false){
				session.invalidate();
				RequestDispatcher dispather	= request.getRequestDispatcher("myqx.jsp");
				dispather.forward(request,response ); return;
			}
		 RequestDispatcher dispather	= request.getRequestDispatcher("dszpzs.jsp");
		    dispather.forward(request,response );return;
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
