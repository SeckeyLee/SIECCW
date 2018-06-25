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

import Javabean.TjzpBean;
import Beanhelp.DataBase;
@WebServlet(name = "XxxxServlet" , urlPatterns = "/xxxx")
public class XxxxServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public XxxxServlet() {
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
		String id1 = request.getParameter("id");
		TjzpBean n = new TjzpBean();
		request.setAttribute("xxxx", n);
		DataBase b = new DataBase();
		ArrayList<TjzpBean> am = b.getAll8("select * from SIECCW.dbo.tj where tj_id='"+id1+"'");
		TjzpBean c = am.get(0);
		n.setTj_id(c.getTj_id().trim());
		n.setTj_class(c.getTj_class());
		n.setTj_introduce(c.getTj_introduce());
		n.setTj_name(c.getTj_name());
		n.setTj_num(c.getTj_num().trim());
		n.setTj_school(c.getTj_school());
		n.setTj_type(c.getTj_type().trim());
		n.setTj_zclass(c.getTj_zclass());
		n.setTj_zname(c.getTj_zname());
		n.setTj_baidu(c.getTj_baidu());
		 RequestDispatcher dispatcher = request.getRequestDispatcher("xxxx.jsp");
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
