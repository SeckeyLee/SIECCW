package Beanhelp;
import java.sql.*;
import java.util.ArrayList;
import Javabean.ZpzsBean;
public class ZpzsHelp {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public ZpzsHelp(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=SIECCW";
			String name="sa";
			String pwd="lhcdsr19960830";
			conn=DriverManager.getConnection(url, name, pwd);
			stmt=conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
	public ArrayList<ZpzsBean> getAll(String sql){
     ArrayList<ZpzsBean> al = new ArrayList<ZpzsBean>();
     try{
        rs = stmt.executeQuery(sql);
     while(rs.next()){
    	 ZpzsBean m = new ZpzsBean();
    	m.setZz_id(rs.getString(1));
    	m.setZz_school(rs.getString(2));
    	m.setZz_class(rs.getString(3));
    	m.setZz_name(rs.getString(4));
    	m.setZz_num(rs.getString(5));
    	m.setZz_zclass(rs.getString(6));
    	m.setZz_zname(rs.getString(7));
    	m.setZz_grade(rs.getString(8));
    	m.setZz_no(rs.getString(9));
    	m.setZz_type(rs.getString(10));
    	m.setZz_introduce(rs.getString(11));
    	m.setZz_baidu(rs.getString(12));
    	 al.add(m);
    	 
    	 
     }
     } catch (SQLException e) {
 		System.out.println(e);
 		}
 		return al;
 	}
 
 	public ResultSet query(String sql){
 		try {
 			rs=stmt.executeQuery(sql);
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return rs;
 	}
}
