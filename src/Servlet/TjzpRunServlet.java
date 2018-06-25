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

import Beanhelp.Bianhao;
import Beanhelp.DataBase;
import Beanhelp.IndexHelp;
@WebServlet(name = "TjzpRunServlet",urlPatterns = "/tjzprun")
public class TjzpRunServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TjzpRunServlet() {
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
		String topic1 = request.getParameter("topic");
		String zpname1 = request.getParameter("zpname");
		String jj1 = request.getParameter("jj");
		String baiduhttp = request.getParameter("baidu");
		String num = ((String) session.getAttribute("num")).trim();
		String name =((String) session.getAttribute("name")).trim();

		IndexHelp a = new IndexHelp();

		DataBase c = new DataBase();
		String bmqrpd = a.neirong("select bm_or from SIECCW.dbo.bm where bm_stu='"+num+"' and bm_ds='"+topic1+"'").trim();
		System.out.println("");
		System.out.println("select bm_zt from SIECCW.dbo.bm where bm_stu='"+num+"' and bm_ds='"+topic1+"'");
		String ytj = a.neirong("select * from SIECCW.dbo.tj where tj_name='"+name+"' and tj_type='"+topic1+"'");

		if(!"已确认".equals(bmqrpd))
		{
			RequestDispatcher dispather	= request.getRequestDispatcher("weiqueren.jsp");
			dispather.forward(request,response ); return;
		}else if(!"".equals(ytj)){
			RequestDispatcher dispather	= request.getRequestDispatcher("ytj.jsp");
			dispather.forward(request,response ); return;

		}
		else{
			String school = a.neirong("select stu_school from SIECCW.dbo.stu where stu_num='"+num+"'").trim();
			String classes = a.neirong("select stu_class from SIECCW.dbo.stu where stu_num='"+num+"'").trim();
			String stuname = a.neirong("select stu_name from SIECCW.dbo.stu where stu_num ='"+num+"'");
			String z_class = a.neirong("select sd_type from SIECCW.dbo.ds where sd_topic = '"+topic1+"'").trim();
			c.update("insert into SIECCW.dbo.tj values"+"("+"'"+school+"','"+classes+"','"+stuname+"','"+num+"','"+z_class+"','"+zpname1+"','"+topic1+"','"+jj1+"','"+baiduhttp+"')");
			RequestDispatcher dispather	= request.getRequestDispatcher("tjcg.jsp");
			dispather.forward(request,response ); return;
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
