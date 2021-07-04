package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.util.JDBC_Dao;

public class DelectMassage {
	private Connection cnt=null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	/* É¾³ýËÞÉá¹ÜÀíÔ± */
	public boolean DelectManager(int Manager_ID) {
		boolean result = true;	
		
		cnt = JDBC_Dao.getConnection();
		String sql = "delete from manager WHERE Manager_ID = ?";
		
		try {
			ps=cnt.prepareStatement(sql);
			
			ps.setInt(1, Manager_ID);
			
			result=ps.execute();
		} catch (Exception e) {
			
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return result;
	}
	
	
	/* É¾³ýÑ§Éú */
	public boolean DelectStudent(int Student_ID) {
		boolean result = true;	
		
		cnt = JDBC_Dao.getConnection();
		String sql = "delete from student WHERE Student_ID = ?";
		
		try {
			ps=cnt.prepareStatement(sql);
			
			ps.setInt(1, Student_ID);
			
			result=ps.execute();
		} catch (Exception e) {
			
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return result;
	}
	
		
	/* É¾³ýÂ¥Óî */
	public boolean DelectBuilding(int Building_ID) {
		boolean result = true;	
		
		cnt = JDBC_Dao.getConnection();
		String sql = "delete from Building WHERE Building_ID = ?";
		
		try {
			ps=cnt.prepareStatement(sql);
			
			ps.setInt(1, Building_ID);
			
			result=ps.execute();
		} catch (Exception e) {
			
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return result;
	}
	
	
	/* É¾³ýÂ¥ÓîµÄÍ¬Ê±É¾³ý¸½ÊôËÞÉá */
	public boolean DelectBuilding_Dormitory(int Building_ID) {
		boolean result = true;	
		
		cnt = JDBC_Dao.getConnection();
		String sql = "delete from domitory WHERE Building_ID = ?";
		
		try {
			ps=cnt.prepareStatement(sql);
			
			ps.setInt(1, Building_ID);
			
			result=ps.execute();
		} catch (Exception e) {
			
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return result;
	}
	
		
	/* É¾³ýËÞÉá */
	public boolean DeleteDormitory(int Dormitory_ID) {
		boolean result = true;	
		
		cnt = JDBC_Dao.getConnection();
		String sql = "delete from domitory WHERE Domitory_ID = ?";
		
		try {
			ps=cnt.prepareStatement(sql);
			
			ps.setInt(1, Dormitory_ID);
			
			result=ps.execute();
		} catch (Exception e) {
			
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return result;
	}
	
	
	/* É¾³ýÉá¹ÜÖ°Îñ */
	public boolean DeleteManagerDuty(int mid ,int bid) {
		boolean result = true;	
		
		cnt = JDBC_Dao.getConnection();
		String sql = "delete from Manager_Duty WHERE MD_ManagerID = ? and MD_BuildingID= ?";
		
		try {
			ps=cnt.prepareStatement(sql);
			
			ps.setInt(1, mid);
			ps.setInt(2, bid);
			
			result=ps.execute();
		} catch (Exception e) {
			
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return result;
	}
	
//	public static void main(String[] args) {
//		DelectMassage delectMassage = new DelectMassage();
//		
//		boolean result = delectMassage.DelectManager(2); 
//		System.out.println(result);
//	}
	
}
