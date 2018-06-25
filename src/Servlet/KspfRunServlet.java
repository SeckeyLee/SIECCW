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

import Beanhelp.*;

@WebServlet(name = "KspfRunServlet", urlPatterns = "/kspfrun")
public class KspfRunServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public KspfRunServlet() {
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
		if (session.getAttribute("num") == null) {
			RequestDispatcher dispather = request.getRequestDispatcher("login.jsp");
			dispather.forward(request, response);
			return;
		}
		String qx = "t{1}[0-9]{5}";
		Pattern pattern = Pattern.compile(qx);
		String numpd = ((String) session.getAttribute("num")).trim();
		System.out.println(numpd);
		Matcher matcher = pattern.matcher(numpd);
		System.out.println(matcher.matches());
		if (matcher.matches() == false) {
			session.invalidate();
			RequestDispatcher dispather = request.getRequestDispatcher("myqx.jsp");
			dispather.forward(request, response);
			return;
		}
		String pf_ds1 = request.getParameter("pf_ds");
		String pf_stu1 = request.getParameter("pf_stu");
		String afs1 = request.getParameter("fs1");
		IndexHelp a = new IndexHelp();
		String jsname = (String) session.getAttribute("name");
		String teaid = a.neirong("select tea_num from SIECCW.dbo.tea where tea_name='" + jsname + "'");
		String pd = a.neirong("select pf_id from SIECCW.dbo.pf where pf_teaid ='" + teaid + "'and pf_ds='"+pf_ds1+"'and pf_stu='"+pf_stu1+"'");
		System.out.println(pd+"这个值是不是空的？");
		if (!"".equals(pd)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("pfed.jsp");
			dispatcher.forward(request, response);
			return;
		} else {

			int fs = Integer.parseInt(afs1);

			DataBase b = new DataBase();
			b.update("insert into SIECCW.dbo.pf values" + "('" + pf_ds1 + "','" + pf_stu1 + "','" + teaid + "','" + fs + "')");
			RequestDispatcher dispatcher = request.getRequestDispatcher("pf");
			dispatcher.forward(request, response);
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
