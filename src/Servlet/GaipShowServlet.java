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

import Javabean.ChapBean;
import Javabean.ChapBean1;
import Beanhelp.DataBase;
@WebServlet(name = "GaipShowServlet" ,urlPatterns = "/gaip")
public class GaipShowServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public GaipShowServlet() {
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
		if(session.getAttribute("name") == null ){ 
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
		 String str = request.getParameter("type");
		 String str1 = request.getParameter("num");
		 session.setAttribute("num1", str1);
		 if("学生".equals(str)){
		 ChapBean a = new ChapBean();
		 request.setAttribute("gaip1", a);
		 DataBase b = new DataBase();
		 ArrayList<ChapBean> am = b.getAll3("select * from SIECCW.dbo.stu where stu_num ='"+str1+"'");
		 ChapBean c = am.get(0);
		 a.setName(c.getName());
		 a.setNum(c.getNum());
		 a.setClasses(c.getClasses());
		 a.setPhone(c.getPhone());
		 a.setSchool(c.getSchool());
		 RequestDispatcher dispatcher = request.getRequestDispatcher("gaistu.jsp");
			dispatcher.forward(request, response);	
		 return;
		}
		 if("评委教师".equals(str)){
			 ChapBean1 a = new ChapBean1();
			 request.setAttribute("gaip1", a);
			 DataBase b = new DataBase();
			 ArrayList<ChapBean1> am = b.getAll1("select * from SIECCW.dbo.tea where tea_num ='"+str1+"'");
			 ChapBean1 c = am.get(0);
			 a.setName(c.getName());
			 a.setNum(c.getNum());
			 a.setPhone(c.getPhone());
			 RequestDispatcher dispatcher = request.getRequestDispatcher("gaitea.jsp");
				dispatcher.forward(request, response);	
			 return;
			}
		 if("大赛组委会".equals(str)){
			 ChapBean1 a = new ChapBean1();System.out.println("123");
			 request.setAttribute("gaip1", a);
			 DataBase b = new DataBase();
			 ArrayList<ChapBean1> am = b.getAll1("select * from SIECCW.dbo.occ where occ_num ='"+str1+"'");
			 ChapBean1 c = am.get(0);
			 a.setName(c.getName());System.out.println(a.getName());
			 a.setNum(c.getNum());
			 a.setPhone(c.getPhone());
			 RequestDispatcher dispatcher = request.getRequestDispatcher("gaiocc.jsp");
				dispatcher.forward(request, response);	
			 return;
			}
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
