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
@WebServlet(name = "GaipRunServlet" ,urlPatterns = "/gaiprun")
public class GaipRunServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public GaipRunServlet() {
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
		HttpSession session = request.getSession();
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
		DataBase a = new DataBase();
		Md5 md5 = new Md5();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String psd = request.getParameter("psd");
		String school = request.getParameter("school");
		String classes = request.getParameter("class");
		String type = request.getParameter("type");
		String num  = request.getParameter("num");
		String str1 = "update SIECCW.dbo.stu set stu_name='"+name+"' where stu_num='"+num+"'";
		String str2 = "update SIECCW.dbo.stu set stu_phone='"+phone+"'where stu_num='"+num+"'";
		String psd1 = md5.md5jm(psd);
		String str3 = "update SIECCW.dbo.stu set stu_key='"+psd1+"'where stu_num='"+num+"'";
		String str4 = "update SIECCW.dbo.stu set stu_school='"+school+"'where stu_num='"+num+"'";
		String str5 = "update SIECCW.dbo.stu set stu_class='"+classes+"'where stu_num='"+num+"'";
		String str6 = "update SIECCW.dbo.tea set tea_name='"+name+"'where tea_num='"+num+"'";
		String str7 = "update SIECCW.dbo.tea set tea_phone='"+phone+"'where tea_num='"+num+"'";
		String str8 = "update SIECCW.dbo.tea set tea_key='"+psd1+"'where tea_num='"+num+"'";
		String str9 = "update SIECCW.dbo.occ set occ_name='"+name+"'where occ_num='"+num+"'";
		String str10 = "update SIECCW.dbo.occ set occ_phone='"+phone+"'where occ_num='"+num+"'";
		String str11 = "update SIECCW.dbo.occ set occ_key='"+psd1+"'where occ_num='"+num+"'";
		if(type.equals("学生")){
        if("".equals(psd)){
        a.update(str1);
        a.update(str2);
        a.update(str4);
        a.update(str5);
        }
        else
        {
        	 a.update(str1);
             a.update(str2);
             a.update(str3);
             a.update(str4);
             a.update(str5);	
        }
        }
		if(type.equals("评委教师")){
	        if("".equals(psd)){
	        a.update(str6);
	        a.update(str7);
	        }
	        else
	        {
	        	 a.update(str6);
	             a.update(str7);
	             a.update(str8);
	        }
	        }
		if(type.equals("大赛组委会")){
	        if("".equals(psd)){
	        a.update(str9);
	        a.update(str10);
	        }
	        else
	        {
	        	 a.update(str9);
	             a.update(str10);
	             a.update(str11);
	        }
	        }
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher("chap");
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
