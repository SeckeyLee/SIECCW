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
import Beanhelp.DataBase;
import Beanhelp.Md5;
@WebServlet(name = "ReTeaServlet",urlPatterns = "/retea")
public class ReTeaServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public ReTeaServlet() {
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

		request.setCharacterEncoding("utf-8");
		HttpSession session =  request.getSession() ;
		String qx = "t{1}[0-9]{5}";
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
		DataBase a = new DataBase();
		Md5 md5 = new Md5();
		String str1 = request.getParameter("name");
		String str2 = request.getParameter("phone");
		String str3 = request.getParameter("psd");
		String str4 = (String) session.getAttribute("num");
		String str5 = "update SIECCW.dbo.tea set tea_name ='"+str1+"' where tea_num='"+str4+"'";
		String str6 = "update SIECCW.dbo.tea set tea_phone ='"+str2+"' where tea_num='"+str4+"'";
		System.out.print(str3.equals(""));
		if(str3.equals("")){
				
			a.update(str5);
			a.update(str6);
			session.setAttribute("name", str1);
			session.setAttribute("phone", str2);}
		else
		{
			
			str3 = md5.md5jm(str3);	
			String str7 = "update SIECCW.dbo.tea set tea_key ='"+str3+"' where tea_num='"+str4+"'";
			a.update(str5);
			a.update(str6);
			a.update(str7);
			session.setAttribute("name", str1);
			session.setAttribute("phone", str2);
			session.setAttribute("psd", str3);
		}
		
		
		
		

		 RequestDispatcher dispatcher = request.getRequestDispatcher("tea");
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
