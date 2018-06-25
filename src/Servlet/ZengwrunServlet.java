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

import Beanhelp.*;
@WebServlet(name = "ZengwrunServlet",urlPatterns = "/zengwrun")


public class ZengwrunServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public ZengwrunServlet() {
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
		request.setCharacterEncoding("utf-8");
		IndexHelp n = new IndexHelp();


		 String str = request.getParameter("content");
		 String str1 = request.getParameter("topic");
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
         java.util.Date currentTime = new java.util.Date();
         String str_date1 = formatter.format(currentTime);
		 String str_date2 = str_date1.toString();
		 String edit = (String) session.getAttribute("name");
		 String editid = n.neirong("select occ_num from SIECCW.dbo.occ where occ_name = '"+edit+"'");
			DataBase a = new DataBase();
			String str2="insert into SIECCW.dbo.sjds values"+"('"+str1+"','"+str_date2+"','"+editid+"','"+str+"')";
		System.out.println("lalala"+str2);
			
			a.update(str2);
			
			  RequestDispatcher dispatcher = request.getRequestDispatcher("chaw");
				dispatcher.forward(request, response);
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
