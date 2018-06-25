package Servlet;

import Beanhelp.IndexHelp;
import Javabean.Sjds;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Sjdsnr",urlPatterns = "/sjds_nr")
public class Sjdsnr extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Sjds db =new Sjds();
        request.setAttribute("sjdsnr1",db);
        IndexHelp b =new IndexHelp();
        String str =request.getParameter("id");
        db.setSjds_topic(b.neirong("select sjds_topic from SIECCW.dbo.sjds where sjds_id='"+str+"'"));
        db.setSjds_date(b.neirong1("select sjds_date from SIECCW.dbo.sjds where sjds_id='"+str+"'"));
        db.setSjds_edit(b.neirong("select occ_name from SIECCW.dbo.occ where occ_num = (select sjds_editid from SIECCW.dbo.sjds where sjds_id='"+str+"')"));
        db.setSjds_main(b.neirong("select sjds_main from SIECCW.dbo.sjds where sjds_id='"+str+"'"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("sjdsnr.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
