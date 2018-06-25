package Servlet;

import java.io.IOException;
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

import Javabean.DsBean;
import Javabean.DsbmBean;
import Beanhelp.DataBase;
@WebServlet(name = "DsbmServlet",urlPatterns = "/dsbm")
public class DsbmServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public DsbmServlet() {
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
	    dispather.forward(request,response); return;}
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
		 DsbmBean n = new DsbmBean();
	    StringBuffer a = new StringBuffer();
	String condition ="select * from SIECCW.dbo.bm order by bm_or ";
	request.setAttribute("dsbm", n);
	 DataBase db = new DataBase();
	 ArrayList<DsbmBean> am =db.getAll6(condition);
	 int pall = am.size();
	 for(int i=0;i<pall;i++)
	 {
		 DsbmBean m = am.get(i);
		  a.append("<tr class='cen'>");
		  a.append("<td>"+m.getBm_ds()+"</td>") ;
		  a.append("<td>"+m.getBm_stu()+"</td>");
		  if("未确认".equals(m.getBm_zt().trim())){
		  a.append("<td><a href='qrbm?id="+m.getBm_id()+"'  class='mr-5'>"+m.getBm_zt()+"</a><a href='info?num="+m.getBm_stu()+"'>查看信息</a></td>");}
		  else{ a.append("<td>"+m.getBm_zt()+"<a href='info?num="+m.getBm_stu()+"'>查看信息</a></td>");}
		  a.append("</tr>");
		  n.setResult(a.toString());
	 }
	    RequestDispatcher dispather	= request.getRequestDispatcher("dsbm.jsp");
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
