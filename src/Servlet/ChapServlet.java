package Servlet;
import Javabean.*;
import Beanhelp.*;
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
@WebServlet(name = "ChapServlet",urlPatterns = "/chap")
public class ChapServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public ChapServlet() {
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
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String str = request.getParameter("ziduan");
		if(str == null)str = "大赛组委会";
		ChapBean1 n = new ChapBean1();
		StringBuffer a = new StringBuffer();
		String condition = new String();
		if("大赛组委会".equals(str)){
		condition = "select * from SIECCW.dbo.occ";}
		if("评委教师".equals(str)){
		condition = "select * from SIECCW.dbo.tea";}
		if("学生".equals(str)){
		condition = "select * from SIECCW.dbo.stu";}
		request.setAttribute("chap1", n);
		DataBase db = new DataBase();
		if("学生".equals(str)){
		ArrayList<ChapBean1> am = db.getAll2(condition);
		int pall = am.size();
		for(int i = 0 ; i < pall ; i++  ){
		ChapBean1 m = am.get(i)	;
		  a.append("<tr class='cen'>");
		  a.append("<td>"+m.getNum()+"</td>") ;
		  a.append("<td>"+m.getName()+"</td>") ;
		  a.append("<td>"+m.getPhone()+"</td>") ;
		  a.append("<td><a href='gaip?type=学生&num="+m.getNum()+"'  class='mr-5'>更改</a><a href='shanp?type=学生&num="+m.getNum()+"''>删除</a></td>");
		  a.append("</tr>");
		  n.setResult(a.toString());
			
		}
		}
		if("大赛组委会".equals(str)){
			ArrayList<ChapBean1> am1 = db.getAll1(condition);
			int pall1 = am1.size();
			for(int i = 0 ; i < pall1 ; i++  ){
			ChapBean1 m = am1.get(i)	;
			  a.append("<tr class='cen'>");
			  a.append("<td>"+m.getNum()+"</td>") ;
			  a.append("<td>"+m.getName()+"</td>") ;
			  a.append("<td>"+m.getPhone()+"</td>") ;
			  a.append("<td><a href='gaip?type=大赛组委会&num="+m.getNum()+"'  class='mr-5'>更改</a><a href='shanp?type=大赛组委会&num="+m.getNum()+"''>删除</a></td>");
			  a.append("</tr>");
			  n.setResult(a.toString());
				
			}
		}
			if("评委教师".equals(str)){
				ArrayList<ChapBean1> am2 = db.getAll1(condition);
				int pall2 = am2.size();
				for(int i = 0 ; i < pall2 ; i++  ){
		
					ChapBean1 m = am2.get(i)	;
				  a.append("<tr class='cen'>");
				  a.append("<td>"+m.getNum()+"</td>") ;
				  a.append("<td>"+m.getName()+"</td>") ;
				  a.append("<td>"+m.getPhone()+"</td>") ;
				  a.append("<td><a href='gaip?type=评委教师&num="+m.getNum()+"'  class='mr-5'>更改</a><a href='shanp?type=评委教师&num="+m.getNum()+"''>删除</a></td>");
				  a.append("</tr>");
				  n.setResult(a.toString());
					
				}
		}
			 RequestDispatcher dispather	= request.getRequestDispatcher("chap.jsp");
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
