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
import Beanhelp.IndexHelp;
import Javabean.pm;

@WebServlet(name = "DszpzsRunServlet" ,urlPatterns = "/dszpzsrun")
public class DszpzsRunServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public DszpzsRunServlet() {
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
					TjzpBean n = new TjzpBean();
					pm pm = new pm();
					IndexHelp a = new IndexHelp();
					DataBase b = new DataBase();
					b.update("truncate table SIECCW.dbo.zz");
					ArrayList<TjzpBean> am = b.getAll8("select * from SIECCW.dbo.tj");
					int i = am.size();
					for(int j = 0 ;j < i ; j++ ){
						TjzpBean c = am.get(j);
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
						String fs = a.neirong("select avg(pf_fs) from SIECCW.dbo.pf where pf_stu = '"+n.getTj_num()+"' and pf_ds='"+n.getTj_type()+"'");
						b.update("insert into SIECCW.dbo.zz values"+
						"('"+n.getTj_school()+"','"+n.getTj_class()+ "','"+n.getTj_name()+
								"','"+n.getTj_num()+"','"+n.getTj_zclass()+"','"+n.getTj_zname()+
								"','"+fs+"','正在开发中','"+n.getTj_type()+"','"+n.getTj_introduce()+"','"+n.getTj_baidu()+"')");


					}

	
					 RequestDispatcher dispatcher = request.getRequestDispatcher("zpzs");
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
