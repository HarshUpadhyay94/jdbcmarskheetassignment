package com.raystech.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Marksheetmodel {
	public static void main(String[] args) throws Exception {
		//add(null);
		//update(null);
		//delete(null);
		//getrollno(null);
		//getMaritList();
		getsearch(null);
		
	}
	public static void getsearch(MarksheetBeans bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays","root", "root");
		PreparedStatement ps = conn.prepareStatement("SELECT*FROM MARKSHEET WHERE FNAME=?");
		ps.setString(1, bean.getFNAME());
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t    "+rs.getInt(2));
			System.out.print("\t    "+rs.getString(3));
			System.out.print("\t    "+rs.getString(4));
			System.out.print("\t    "+rs.getInt(5));
			System.out.print("\t    "+rs.getInt(6));
			System.out.print("\t    "+rs.getInt(7));
		}
		
		
	}
	public static void getMaritList() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays","root", "root");
		PreparedStatement ps = conn.prepareStatement("SELECT * , (PHYSICS+CHEMISTRY+MATHS) AS TOTAL, (PHYSICS+CHEMISTRY+MATHS)/3 AS PERCENTAGE FROM MARKSHEET WHERE PHYSICS>35 AND CHEMISTRY>35 AND MATHS>35 ORDER BY TOTAL DESC LIMIT 0,5");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t    "+rs.getInt(2));
			System.out.print("\t    "+rs.getString(3));
			System.out.print("\t    "+rs.getString(4));
			System.out.print("\t    "+rs.getInt(5));
			System.out.print("\t    "+rs.getInt(6));
			System.out.print("\t    "+rs.getInt(7));
			System.out.print("\t    "+ rs.getInt(8));
			System.out.println("\t  "+rs.getInt(9));
		}
	}
	public static void getrollno(MarksheetBeans bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays","root", "root");
		PreparedStatement ps = conn.prepareStatement("SELECT* FROM MARKSHEET WHERE ROLL_NO=?");
		ps.setInt(1, bean.getRoll_No());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t    "+rs.getInt(2));
			System.out.print("\t    "+rs.getString(3));
			System.out.print("\t    "+rs.getString(4));
			System.out.print("\t    "+rs.getInt(5));
			System.out.print("\t    "+rs.getInt(6));
			System.out.print("\t    "+rs.getInt(7));
		}
		conn.close();
		ps.close();
	}

	
	public static void delete(MarksheetBeans bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays","root", "root");
		PreparedStatement ps = conn.prepareStatement("DELETE FROM MARKSHEET WHERE ID=?");
		ps.setInt(1, bean.getID());
		ps.executeUpdate();
		System.out.println("deleted");
		conn.close();
		ps.close();
		
	}
			
			public static void update(MarksheetBeans bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays","root","root");
		PreparedStatement ps = conn.prepareStatement("UPDATE MARKSHEET SET ROLL_NO=?, FNAME=?, LNAME=?, PHYSICS=?, CHEMISTRY=?, MATHS=? WHERE ID=?");
		ps.setInt(1, bean.getRoll_No());
		ps.setString(2, bean.getFNAME());
		ps.setString(3, bean.getLNAME());
		ps.setInt(4, bean.getPHYSICS());
		ps.setInt(5, bean.getCHEMISTRY());
		ps.setInt(6, bean.getMATHS());
		ps.setInt(7, bean.getID());
		ps.executeUpdate();
		System.out.println("updated");
		conn.close();
		ps.close();
		
	}
		public static void add(MarksheetBeans bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sunrays","root","root");
		PreparedStatement ps=conn.prepareStatement("INSERT INTO MARKSHEET VALUES(?,?,?,?,?,?,?)");
		ps.setInt(1, bean.getID());
		ps.setInt(2, bean.getRoll_No());
		ps.setString(3, bean.getFNAME());
		ps.setString(4, bean.getLNAME());
		ps.setInt(5, bean.getPHYSICS());
		ps.setInt(6, bean.getCHEMISTRY());
		ps.setInt(7, bean.getMATHS());
		ps.execute();
		System.out.println("inserted");
		conn.close();
		ps.close();
}
}


