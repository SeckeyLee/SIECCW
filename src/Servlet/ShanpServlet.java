package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Javabean.IndexBean;
import Beanhelp.DataBase;
import Beanhelp.IndexHelp;
@WebServlet(name = "ShanpServlet",urlPatterns = "/shanp")
public class ShanpServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public ShanpServlet() {
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
		if(session.getAttribute("num") == null ){   
			RequestDispatcher dispather	= request.getRequestDispatcher("bg");
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
String num = request.getParameter("num");
String type = request.getParameter("type");
DataBase a = new DataBase();
IndexHelp b = new IndexHelp();
String str1 ="delete from SIECCW.dbo.stu where stu_num ='"+num+"'" ;
String str2 ="delete from SIECCW.dbo.tea where tea_num ='"+num+"'" ;
String str3 ="delete from SIECCW.dbo.occ where occ_num ='"+num+"'" ;
String str4 ="select COUNT (*) from SIECCW.dbo.stu";
String str5 ="select COUNT (*) from SIECCW.dbo.tea";
String str6 ="select COUNT (*) from SIECCW.dbo.occ";
if("学生".equals(type)){
if(b.neirong(str4).equals("1")){
	RequestDispatcher dispather	= request.getRequestDispatcher("stop.jsp");
    dispather.forward(request,response ); return;	
}
else{
	a.update(str1);
}	
}
if("评委教师".equals(type)){
if(b.neirong(str5).equals("1")){
	RequestDispatcher dispather	= request.getRequestDispatcher("stop.jsp");
    dispather.forward(request,response ); return;	
}
else{
	a.update(str2);
}	
}
if("大赛组委会".equals(type)){
if(b.neirong(str6).equals("1")){
	RequestDispatcher dispather	= request.getRequestDispatcher("stop.jsp");
    dispather.forward(request,response ); return;	
}
else{
	a.update(str3);
}	
}
RequestDispatcher dispather	= request.getRequestDispatcher("chap");
dispather.forward(request,response );
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
