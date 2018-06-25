package Servlet;
import Beanhelp.*;
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
@WebServlet(name = "ZengpRunServlet",urlPatterns ="/zengprun")
public class ZengpRunServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public ZengpRunServlet() {
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
		String str1  = request.getParameter("type");
		String name  = request.getParameter("name");
		String num   = request.getParameter("num");
		String phone = request.getParameter("phone");
		String school= request.getParameter("school");
		String classes = request.getParameter("class");
		String key = new String();
		Md5 md5 = new Md5();
		IndexHelp c = new IndexHelp();
		DataBase a = new DataBase();
		Bianhao b = new Bianhao();
		if("学生".equals(str1)){
		key = md5.md5jm(num);
		a.update("insert into SIECCW.dbo.stu values"+"("+"'"+num+"','"+key+"','"+name+"','"+school+"','"+classes+"','"+phone+"')");
		 RequestDispatcher dispather	= request.getRequestDispatcher("chap");
		    dispather.forward(request,response );return;
		}
		if("评委教师".equals(str1)){
		String num_1 = c.neirong("select top 1 tea_num from SIECCW.dbo.tea order by tea_num desc").trim();
		num = b.aoto(num_1);
		key = md5.md5jm(num);
			a.update("insert into SIECCW.dbo.tea values"+"("+"'"+num+"','"+key+"','"+name+"','"+phone+"')");
			 RequestDispatcher dispather	= request.getRequestDispatcher("chap");
			    dispather.forward(request,response );return;
			}
		if("大赛组委会".equals(str1)){
			String num_1 = c.neirong("select top 1 occ_num from SIECCW.dbo.occ order by occ_num desc").trim();
			num = b.aoto(num_1);
			key = md5.md5jm(num);
				a.update("insert into SIECCW.dbo.occ values"+"("+"'"+num+"','"+key+"','"+name+"','"+phone+"')");
				 RequestDispatcher dispather	= request.getRequestDispatcher("chap");
				    dispather.forward(request,response );return;
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
