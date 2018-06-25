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
import Beanhelp.IndexHelp;

@WebServlet(name = "GaiwRunServlet",urlPatterns = "/gaiwrun")
public class GaiwRunServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public GaiwRunServlet() {
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
		request.setCharacterEncoding("utf-8");
         String id = request.getParameter("id");
		 String str = request.getParameter("content");
		 String str1 = request.getParameter("topic");
		 String name = (String) session.getAttribute("name");
			DataBase a = new DataBase();
			String str2="update SIECCW.dbo.sjds set sjds_topic ='"+str1+"' where sjds_id='"+id+"'";
			String str3="update SIECCW.dbo.sjds set sjds_main  ='"+str+"'where   sjds_id='"+id+"'";
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date currentTime = new java.util.Date();
            String str_date1 = formatter.format(currentTime);
			String str_date2 = str_date1.toString();
		IndexHelp indexHelp = new IndexHelp();
			String zzid = indexHelp.neirong("select occ_num from SIECCW.dbo.occ where occ_name = '"+name+"'");
			String str4="update SIECCW.dbo.sjds set sjds_date  ='"+str_date2+"' where sjds_id='"+id+"'";
			String str5="update SIECCW.dbo.sjds set sjds_editid  ='"+zzid+"' where sjds_id='"+id+"'";
			a.update(str2);
			a.update(str3);
			a.update(str4);
			a.update(str5);
			  RequestDispatcher dispatcher = request.getRequestDispatcher("chaw");
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
