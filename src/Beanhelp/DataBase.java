package Beanhelp;
import java.sql.*;
import java.util.ArrayList;

import Javabean.*;

public class DataBase {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	public DataBase(){
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
		
	public ArrayList<Sjds> getAll(String sql){
     ArrayList<Sjds> al = new ArrayList<Sjds>();
     try{
        rs = stmt.executeQuery(sql);
     while(rs.next()){
         Sjds m = new Sjds();
    	 m.setSjds_id(rs.getString(1));
    	 m.setSjds_topic(rs.getString(2));
    	 m.setSjds_date(rs.getDate(3));
    	 m.setSjds_edit(rs.getString(4));
    	 m.setSjds_main(rs.getString(5));
    	 al.add(m);
    	 
    	 
     }
     } catch (SQLException e) {
 		System.out.println(e);
 		}
 		return al;
 	}
	public ArrayList<ChapBean1> getAll1(String sql){
	     ArrayList<ChapBean1> al = new ArrayList<ChapBean1>();
	     try{
	        rs = stmt.executeQuery(sql);
	     while(rs.next()){
	    	 ChapBean1 m = new ChapBean1();
	    	m.setNum(rs.getString(1));
	    	m.setName(rs.getString(3));
	    	m.setPhone(rs.getString(4));
	    	 al.add(m);
	    	 
	    	 
	     }
	     } catch (SQLException e) {
	 		System.out.println(e);
	 		}
	 		return al;
	 	}
	public ArrayList<ChapBean1> getAll2(String sql){
	     ArrayList<ChapBean1> al = new ArrayList<ChapBean1>();
	     try{
	        rs = stmt.executeQuery(sql);
	     while(rs.next()){
	    	 ChapBean1 m = new ChapBean1();
	    	m.setNum(rs.getString(1));
	    	m.setName(rs.getString(3));
	    	m.setPhone(rs.getString(6));
	    	 al.add(m);
	    	 
	    	 
	     }
	     } catch (SQLException e) {
	 		System.out.println(e);
	 		}
	 		return al;
	 	}
	public ArrayList<ChapBean> getAll3(String sql){
	     ArrayList<ChapBean> al = new ArrayList<ChapBean>();
	     try{
	        rs = stmt.executeQuery(sql);
	     while(rs.next()){
	    	 ChapBean m = new ChapBean();
	    	m.setNum(rs.getString(1));
	    	m.setName(rs.getString(3));
	    	m.setSchool(rs.getString(4));
	    	m.setClasses(rs.getString(5));
	    	m.setPhone(rs.getString(6));
	    	 al.add(m);
	    	 
	    	 
	     }
	     } catch (SQLException e) {
	 		System.out.println(e);
	 		}
	 		return al;
	 	}
	public ArrayList<SjdsBean> getAll4(String sql){
	     ArrayList<SjdsBean> al = new ArrayList<SjdsBean>();
	     try{
	        rs = stmt.executeQuery(sql);
	     while(rs.next()){
	    	 SjdsBean m = new SjdsBean();
	    	m.setSd_id(rs.getString(1));
	    	m.setSd_topic(rs.getString(2));
	    	m.setSd_date(rs.getDate(3));
	    	m.setSd_edit(rs.getString(4));
	    	m.setSd_main(rs.getString(5));
	    	al.add(m);
	    	 
	    	 
	     }
	     } catch (SQLException e) {
	 		System.out.println(e);
	 		}
	 		return al;
	 	}

	public ArrayList<DsBean> getAll5(String sql){
	     ArrayList<DsBean> al = new ArrayList<DsBean>();
	     try{
	        rs = stmt.executeQuery(sql);
	     while(rs.next()){
	    	 DsBean m = new DsBean();

	    m.setSd_id(rs.getString(1));System.out.println("1");
	    m.setSd_topic(rs.getString(2));System.out.println("2");
	    m.setSd_type(rs.getString(3));System.out.println("3");
	    	 al.add(m);
	    	 
	    	 
	     }
	     } catch (SQLException e) {
	 		System.out.println(e);
	 		}
	 		return al;
	 	}
	public ArrayList<DsbmBean> getAll6(String sql){
	     ArrayList<DsbmBean> al = new ArrayList<DsbmBean>();
	     try{
	        rs = stmt.executeQuery(sql);
	     while(rs.next()){
	    	 DsbmBean m = new DsbmBean();
	    	 m.setBm_id(rs.getString(1));
	    	m.setBm_ds(rs.getString(2));
	    	m.setBm_stu(rs.getString(3));
	    	m.setBm_zt(rs.getString(4));
	    	 al.add(m);
	    	 
	    	 
	     }
	     } catch (SQLException e) {
	 		System.out.println(e);
	 		}
	 		return al;
	 	}
	
	public ArrayList<Tjzp> getAll7(String sql){
	     ArrayList<Tjzp> al = new ArrayList<Tjzp>();
	     try{
	        rs = stmt.executeQuery(sql);
	     while(rs.next()){
	    	 Tjzp m = new Tjzp();
	    	 m.setTopic(rs.getString(1));
	    	 al.add(m);
	    	 
	    	 
	     }
	     } catch (SQLException e) {
	 		System.out.println(e);
	 		}
	 		return al;
	 	}
	public ArrayList<TjzpBean> getAll8(String sql){
	     ArrayList<TjzpBean> al = new ArrayList<TjzpBean>();
	     try{
	        rs = stmt.executeQuery(sql);
	     while(rs.next()){
	    	 TjzpBean m = new TjzpBean();
	    	 m.setTj_id(rs.getString(1));
	    	 m.setTj_school(rs.getString(2));
	    	 m.setTj_class(rs.getString(3));
			 m.setTj_name(rs.getString(4));
	    	 m.setTj_num(rs.getString(5));
	    	 m.setTj_zclass(rs.getString(6));
	    	 m.setTj_zname(rs.getString(7));
	    	 m.setTj_type(rs.getString(8));
	    	 m.setTj_introduce(rs.getString(9));
             m.setTj_baidu(rs.getString(10));
	    	 al.add(m);
	    	 
	    	 
	     }
	     } catch (SQLException e) {
	 		System.out.println(e);
	 		}
	 		return al;
	 	}
	public ArrayList<pm> getAll9(String sql){
		ArrayList<pm> al = new ArrayList<pm>();
		try{
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				pm m = new pm();
				m.setTj_id(rs.getString(1));
				m.setTj_school(rs.getString(2));
				m.setTj_class(rs.getString(3));
				m.setTj_name(rs.getString(4));
				m.setTj_num(rs.getString(5));
				m.setTj_zclass(rs.getString(6));
				m.setTj_zname(rs.getString(7));
				m.setTj_fs(rs.getString(8));
				m.setTj_type(rs.getString(9));
				m.setTj_introduce(rs.getString(10));
				m.setTj_baidu(rs.getString(11));
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
 	public boolean update(String sql){
 		int i=0;
 		boolean temp=false;
 		try {
 			i=stmt.executeUpdate(sql);
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			System.out.print(e);
 		}
 		if (i!=0) {temp=true;}
 		else {temp=false;}
 		
 		
 		return temp;
 	}
 	public void close(){
 		try {
 			conn.close();
 			stmt.close();
 			rs.close();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
 	}
 	}
