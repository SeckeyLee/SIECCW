package Servlet;

import Beanhelp.IndexHelp;
import Javabean.ZpzsBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ZpzsnrServlet",urlPatterns = "/zpzs_nr")
public class ZpzsnrServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ZpzsBean db = new ZpzsBean();
        request.setAttribute("zpzsnr1",db);
        IndexHelp b = new IndexHelp();
        String str = request.getParameter("id");
        db.setZz_id(str.trim());
        db.setZz_class(b.neirong("select zz_class from SIECCW.dbo.zz where zz_id ='"+str+"'"));
        db.setZz_grade(b.neirong("select zz_grade from SIECCW.dbo.zz where zz_id ='"+str+"'"));
        db.setZz_name(b.neirong("select zz_name from SIECCW.dbo.zz where zz_id ='"+str+"'"));
        db.setZz_no(b.neirong("select zz_no from SIECCW.dbo.zz where zz_id ='"+str+"'"));
        db.setZz_num((b.neirong("select zz_num from SIECCW.dbo.zz where zz_id ='"+str+"'")).trim());
        db.setZz_school(b.neirong("select zz_school from SIECCW.dbo.zz where zz_id ='"+str+"'"));
        db.setZz_type((b.neirong("select zz_type from SIECCW.dbo.zz where zz_id ='"+str+"'")).trim());
        db.setZz_zclass(b.neirong("select zz_zclass from SIECCW.dbo.zz where zz_id ='"+str+"'"));
        db.setZz_zname(b.neirong("select zz_zname from SIECCW.dbo.zz where zz_id ='"+str+"'"));
        db.setZz_baidu(b.neirong("select zz_baidu from SIECCW.dbo.zz where zz_id ='"+str+"'"));
        db.setZz_introduce(b.neirong("select zz_introduce from SIECCW.dbo.zz where zz_id ='"+str+"'"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("zpzsnr.jsp");
        dispatcher.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
