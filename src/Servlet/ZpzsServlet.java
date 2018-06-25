package Servlet;

import Beanhelp.ZpzsHelp;
import Javabean.ZpzsBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ZpzsServlet",urlPatterns = "/zpzs")
public class ZpzsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ZpzsBean n = new ZpzsBean();
        StringBuffer a = new StringBuffer();
        request.setAttribute("zpzs1",n);
        ZpzsHelp db = new ZpzsHelp();
        ArrayList<ZpzsBean> am = db.getAll("select * from SIECCW.dbo.zz order by zz_type,zz_grade desc");
        n.setSum(am.size());
        n.setPall(n.getSum()%5 == 0 ? n.getSum() / 5 : n.getSum()/5+1 );
        String str = request.getParameter("page");
        if(str == null){str = "1";}
        n.setX(Integer.parseInt(str));
        if(n.getX() > n.getPall()){n.setX(n.getPall());}
        if(n.getX() <= 0){n.setX(1);}
        for(int i = (n.getX()-1)*5;i<(n.getX()-1)*5+5;i++)
        {
            if(i>=n.getSum())break;
            ZpzsBean m = am.get(i);
            a.append("<a href='zpzs_nr?id="+
                    m.getZz_id()+"&lj=2'</li> <font style='float:left;'>"+
                    m.getZz_zname() +"</font><font style='float:right'>" +
                            m.getZz_name() + "</font></li><br></a>");
        }

        n.setResult(a.toString());

        RequestDispatcher dispather	= request.getRequestDispatcher("zpzs.jsp");
        dispather.forward(request,response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
