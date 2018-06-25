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

import Javabean.PfBean;
import Javabean.TjzpBean;
import Beanhelp.DataBase;
@WebServlet(name = "PfServlet" ,urlPatterns = "/pf")
public class PfServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public PfServlet() {
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
			RequestDispatcher dispather	= request.getRequestDispatcher("login.jsp");
	    dispather.forward(request,response ); return;}
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
		 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
         java.util.Date currentTime = new java.util.Date();

	     TjzpBean n = new TjzpBean();
	     StringBuffer a = new StringBuffer();
	 	String condition ="select * from SIECCW.dbo.tj";
	 	request.setAttribute("pf1", n);
	 	DataBase db = new DataBase();
	 	ArrayList<TjzpBean> am = db.getAll8(condition);
	 	int pall = am.size();
	 	for(int i = 0 ; i < pall ; i++){
	 	TjzpBean m = am.get(i);
	 			 a.append("<tr class='cen'>");
		  a.append("<td>"+m.getTj_type()+"</td>") ;
		  a.append("<td>"+m.getTj_name()+"</td>") ;
		  a.append("<td><a href='xxxx?id="+m.getTj_id()+"' class='mr-5'>查看</a><a href='kspf?type="+m.getTj_type()+"&xsnum="+m.getTj_num()+"' class='mr-5'>评分</a></td>");
		  a.append("</tr>");
		  n.setResult(a.toString());	
	 	}
	 	 RequestDispatcher dispather	= request.getRequestDispatcher("pf.jsp");
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
