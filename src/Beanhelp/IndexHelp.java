package Beanhelp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IndexHelp {
private Connection conn;
private Statement stmt;
private ResultSet rs;
public IndexHelp(){
	
	try{
	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	  String url="jdbc:sqlserver://127.0.0.1:1433;DatabassName=SIECCW";
		String name="sa";
		String pwd="lhcdsr19960830";
		conn=DriverManager.getConnection(url,name,pwd);
		stmt=conn.createStatement();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}}

	public String neirong(String sql){
		StringBuffer a = new StringBuffer();
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
		  a.append(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a.toString();
	}
	public Date neirong1(String sql){
		Date a = new Date(0);
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				 a = rs.getDate(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
	}


}
