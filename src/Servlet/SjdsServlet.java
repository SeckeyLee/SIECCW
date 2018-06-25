package Servlet;

import Beanhelp.DataBase;
import Javabean.Sjds;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SjdsServlet",urlPatterns = {"/sjds"})
public class SjdsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Sjds sjds = new Sjds();
        StringBuilder stringBuilder = new StringBuilder();
        request.setAttribute("sjds1",sjds);
        DataBase dataBase = new DataBase();
        ArrayList<Sjds> arrayList = dataBase.getAll("select * from SIECCW.dbo.sjds order by sjds_date desc");
        sjds.setSum(arrayList.size());
        sjds.setPall(sjds.getSum()%5==0?sjds.getSum()/5:sjds.getSum()/5+1);
        System.out.println(sjds.getPall()+"\t"+sjds.getSum());
        String string = request.getParameter("page");
        if(string == null){string = "1";}
        sjds.setX(Integer.parseInt(string));
        if(sjds.getX() > sjds.getPall()){
        sjds.setX(sjds.getPall());}
        if(sjds.getX() <= 0)
        {
            sjds.setX(1);
        }
        for (int i = (sjds.getX()-1)*5; i <(sjds.getX()-1)*5+5 ; i++) {
         if(i>=sjds.getSum())break;
         Sjds sjds1 = arrayList.get(i);
         stringBuilder.append("<a href='sjds_nr?id="+
                 sjds1.getSjds_id()+"&lj=2'><li><font style='float:left;'>"+
               sjds1.getSjds_topic() +"</font><font style='float:right'>" +
                 sjds1.getSjds_date() + "</font></li><br></a>");
        }
        sjds.setResult(stringBuilder.toString());
        System.out.println(stringBuilder.toString());
        RequestDispatcher dispatcher = request.getRequestDispatcher("sjds.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
