package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Javabean.Tjzp;
import Beanhelp.DataBase;
import Beanhelp.IndexHelp;
@WebServlet(name = "Tjz[Servlet" ,urlPatterns = "/tjzp")
public class TjzpServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public TjzpServlet() {
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

		response.setContentType("text/html");
		HttpSession session =  request.getSession() ;
		if(session.getAttribute("num") == null ){   
			RequestDispatcher dispather	= request.getRequestDispatcher("login.jsp");
			dispather.forward(request,response ); return;}
		String qx = "[0-9]{9}";
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
		Tjzp a = new Tjzp();
		request.setAttribute("tjzp1", a);
		StringBuffer b = new StringBuffer();
		String condition="select sd_topic from SIECCW.dbo.ds";
		DataBase db = new DataBase();
		ArrayList<Tjzp> am = db.getAll7(condition);
		int pall = am.size();
		b.append("<select name='topic'>");
		for(int i=0 ; i<pall; i++)
		{
		Tjzp m = am.get(i);
		b.append("<option value='"+m.getTopic()+"'>"+m.getTopic()+"</option>");
			
		}
		b.append("</select>");
		a.setResult(b.toString());
		
		 RequestDispatcher dispather	= request.getRequestDispatcher("tjzp.jsp");
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
