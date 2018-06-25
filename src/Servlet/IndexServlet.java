package Servlet;

import Beanhelp.DataBase;
import Beanhelp.ZpzsHelp;
import Javabean.Sjds;
import Javabean.ZpzsBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "IndexServlet",urlPatterns = {"/index"})
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Sjds sjds = new Sjds();
        ZpzsBean zpzsBean = new ZpzsBean();
        request.setAttribute("indexsjds",sjds);
        request.setAttribute("indexzpzs",zpzsBean);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        DataBase dataBase = new DataBase();
        ArrayList<Sjds> arrayList = dataBase.getAll("select top 5 * from SIECCW.dbo.sjds order by sjds_date desc");
        sjds.setSum(arrayList.size());
        for (int i = 0; i < 5; i++) {
            if(i>=sjds.getSum())break;
            Sjds sjds1 = arrayList.get(i);
            stringBuilder.append("<a class='indexlj' href='sjds_nr?id="+
                    sjds1.getSjds_id().trim()+"&lj=1'>"+
            sjds1.getSjds_topic()+"</a><br>");
        }
            ZpzsHelp zpzsHelp = new ZpzsHelp();
ArrayList<ZpzsBean> arrayList1 = zpzsHelp.getAll("select top 5 * from SIECCW.dbo.zz order by zz_grade desc");
zpzsBean.setSum(arrayList1.size());
        System.out.println(zpzsBean.getSum());
            for (int j = 0; j < 5 ; j++) {
                if (j>=zpzsBean.getSum())break;
                ZpzsBean zpzsBean1 = arrayList1.get(j);
                System.out.println("恭喜");
                stringBuilder1.append("<a class='indexlj' href='zpzs_nr?id="+
                        zpzsBean1.getZz_id().trim()+"&lj=1'>"+
                        zpzsBean1.getZz_zname()+"</a><br>");
            }

        System.out.println("恭喜1");
        sjds.setResult(stringBuilder.toString());
            zpzsBean.setResult(stringBuilder1.toString());
        System.out.println(stringBuilder.toString());
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
