package com.raystech.bean;

import java.util.ArrayList;

public class Testmarksheetmodel {
	public static void main(String[] args) throws Exception {
		//testadd();
		//testupdate();
		//testdelete();
		//testrollno();
		//testgetmaritlist();	
		testsearch();
	}
	
	
	public static void testsearch() throws Exception {
		MarksheetBeans bean=new MarksheetBeans();
		bean.setFNAME("suresh");
		Marksheetmodel model= new Marksheetmodel();
		model.getsearch(bean);
		
	}
	
	public static void testgetmaritlist() throws Exception {
		MarksheetBeans bean = new MarksheetBeans();
		Marksheetmodel model= new Marksheetmodel();
		ArrayList s = new ArrayList();
		s.add(bean);
	
	}

	private static void testrollno() throws Exception {
		MarksheetBeans bean = new MarksheetBeans();
		bean.setRoll_No(105);
		Marksheetmodel model= new Marksheetmodel();
		model.getrollno(bean);
		
	}



	private static void testdelete() throws Exception {
	MarksheetBeans bean= new MarksheetBeans();
	bean.setID(11);
	Marksheetmodel model= new Marksheetmodel();
	model.delete(bean);
		
	}

	private static void testupdate() throws Exception {
		MarksheetBeans bean= new MarksheetBeans();
		bean.setRoll_No(111);
		bean.setFNAME("mohammad");
		bean.setLNAME("kaif");
		bean.setPHYSICS(70);
		bean.setCHEMISTRY(60);
		bean.setMATHS(70);
		bean.setID(11);
		Marksheetmodel model= new Marksheetmodel();
		model.update(bean);	
	}

	public static void testadd() throws Exception {
		MarksheetBeans bean= new MarksheetBeans();
		bean.setID(11);
		bean.setRoll_No(111);
		bean.setFNAME("katreena");
		bean.setLNAME("kaif");
		bean.setPHYSICS(70);
		bean.setCHEMISTRY(60);
		bean.setMATHS(70);
		
		Marksheetmodel model= new Marksheetmodel();
		model.add(bean);
	}
}