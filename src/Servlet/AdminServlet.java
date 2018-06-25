package Servlet;
import Javabean.InfoBean;
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
@WebServlet(name = "AdminServlet" ,urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AdminServlet() {
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

HttpSession session =  request.getSession() ;System.out.println(session.getAttribute("num") == null); System.out.print(session.getAttribute("num"));
if(session.getAttribute("num") == null ){   
RequestDispatcher dispather	= request.getRequestDispatcher("login.jsp");
dispather.forward(request,response ); return;}
String qx = "a{1}[0-9]{5}";
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
InfoBean a = new InfoBean();
request.setAttribute("info1", a);
a.setName((String) session.getAttribute("name"));
a.setNum((String) session.getAttribute("num"));
a.setPhone((String) session.getAttribute("phone"));
RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
dispatcher.forward(request, response);
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

	doGet(request, response);
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
