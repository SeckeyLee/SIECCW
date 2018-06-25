package Servlet;
import Beanhelp.Md5;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
@WebServlet(name = "HandleLoginServlet",urlPatterns = {"/hand"})
public class HandleLoginServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public HandleLoginServlet() {
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
    if(session.getAttribute("num") != null) {
    	response.sendRedirect("not.jsp") ;
		return;  
    	
    }
	Connection conn;
	Statement stmt;
	ResultSet rs = null;
	String str1 = request.getParameter("text");
	String str2 = request.getParameter("password");
	String str3 = request.getParameter("identity");
	Md5 md5 = new Md5();
	str2 = md5.md5jm(str2);
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url="jdbc:sqlserver://127.0.0.1:1433;DatabassName=SIECCW";
	String name="sa";
	String pwd="lhcdsr19960830";
	conn=DriverManager.getConnection(url,name,pwd);
	stmt=conn.createStatement();
	String sql = null;
	if(str3.equals("administrator")){System.out.print("2");
	sql ="select * from SIECCW.dbo.adm where adm_num='"+str1+"' and  adm_key='"+str2+"'" ;
	rs = stmt.executeQuery(sql);
	if(rs.next()){
	session.setAttribute("num", rs.getString(1));
	session.setAttribute("psd", rs.getString(2));
	session.setAttribute("name", rs.getString(3));
	session.setAttribute("phone", rs.getString(4));
	response.sendRedirect("admin") ;
	return;
	}
	else
	{
		
		response.sendRedirect("dlsb.jsp") ;
		return;                        
	}
	}
	if(str3.equals("Committee") ){System.out.print("3");
		sql ="select * from SIECCW.dbo.occ where occ_num='"+str1+"' and  occ_key='"+str2+"'" ;
		rs = stmt.executeQuery(sql);
		if(rs.next()){
		session.setAttribute("num", rs.getString(1));
		session.setAttribute("psd", rs.getString(2));
		session.setAttribute("name", rs.getString(3));
		session.setAttribute("phone", rs.getString(4));
		response.sendRedirect("occ") ;
		return;
		}
		else
		{
			
			response.sendRedirect("dlsb.jsp") ;
			return;                                
		}	
	}
	if(str3.equals("teacher")){System.out.print("4");
		sql ="select * from SIECCW.dbo.tea where tea_num='"+str1+"' and  tea_key='"+str2+"'" ;
		rs = stmt.executeQuery(sql);
		if(rs.next()){
		session.setAttribute("num", rs.getString(1));
		session.setAttribute("psd", rs.getString(2));
		session.setAttribute("name", rs.getString(3));
		session.setAttribute("phone", rs.getString(4));
		response.sendRedirect("tea") ;
		return;
		}
		else
		{
			
			response.sendRedirect("dlsb.jsp") ;
			return;                                 
		}	
	}
	if(str3.equals("student")){System.out.print("5");
		sql ="select * from SIECCW.dbo.stu where stu_num='"+str1+"' and  stu_key='"+str2+"'" ;
		rs = stmt.executeQuery(sql);
		if(rs.next()){
		session.setAttribute("num", rs.getString(1));
		session.setAttribute("psd", rs.getString(2));
		session.setAttribute("name", rs.getString(3));
		session.setAttribute("school", rs.getString(4));
		session.setAttribute("class", rs.getString(5));
		session.setAttribute("phone", rs.getString(6));
		response.sendRedirect("stu") ;
		return;
		}
		else
		{
			
			
			response.sendRedirect("dlsb.jsp") ;	                                                     
			return;                                
		}}
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e);
	}
	 
	   
			}
	    	
	
	
	
	
	
	
	
	

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		
	}

}
