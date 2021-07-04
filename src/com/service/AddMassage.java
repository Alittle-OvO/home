package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.Building;
import com.entity.Dormitory;
import com.entity.Manager;
import com.entity.Student;
import com.util.JDBC_Dao;

public class AddMassage {
	
	private Connection cnt=null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/* ��ӹ���Ա */
	public boolean AddManager(Manager manager) {
		boolean result = true;
		
		cnt = JDBC_Dao.getConnection();
		String sql = "INSERT INTO manager VALUES (null,?,?,?,?,?)";
		
		try {
			ps=cnt.prepareStatement(sql);
			
			ps.setString(1, manager.getManager_Username());
			ps.setString(2, manager.getManager_Password());
			ps.setString(3, manager.getManager_Name());
			ps.setString(4, manager.getManager_Sex());
			ps.setString(5, manager.getManager_Tel());
			
			result=ps.execute();
		} catch (Exception e) {
			
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return result;
	}
	
	
	/* ���ѧ�� */
	public boolean AddStudent(Student student) {
		boolean result = true;
		
		cnt = JDBC_Dao.getConnection();
		String sql = "INSERT INTO student VALUES (null,null,?,?,?,?,?,'δ��ס')";
		
		try {
			ps=cnt.prepareStatement(sql);
			
			ps.setString(1, student.getStudent_Username());
			ps.setString(2, student.getStudent_Password());
			ps.setString(3, student.getStudent_Name());
			ps.setString(4, student.getStudent_Sex());
			ps.setString(5, student.getStudent_Class());
			
			result=ps.execute();
		} catch (Exception e) {
			
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return result;
	}
	
	
	/* ���¥�� */
	public boolean AddBuilding(Building building) {
		boolean result = true;
		
		cnt = JDBC_Dao.getConnection();
		String sql = "INSERT INTO building VALUES (null,?,?)";
		
		try {
			ps=cnt.prepareStatement(sql);
			
			ps.setString(1, building.getBuilding_Name());
			ps.setString(2, building.getBuilding_Introduction());
			
			result=ps.execute();
		} catch (Exception e) {
			
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return result;
	}
	
	
	/* ��ӹ����� */
	public boolean AddDormitory(Dormitory dormitory) {
		boolean result = true;
		
		cnt = JDBC_Dao.getConnection();
		String sql = "INSERT INTO Domitory VALUES (null,?,?,?,?,?)";
		
		try {
			ps=cnt.prepareStatement(sql);
			
			ps.setInt(1, dormitory.getDormitory_BuildingID());
			ps.setString(2, dormitory.getDormitory_Name());
			ps.setString(3, dormitory.getDormitory_Type());
			ps.setString(4, dormitory.getDormitory_Number());
			ps.setString(5, dormitory.getDormitory_Tel());
			
			result=ps.execute();
		} catch (Exception e) {
			
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return result;
	}
	
	

	/* ��ӱ�ҵ��¼ */
	public boolean AddGraduation(int sid, String thedate,String remark) {
		boolean result = true;
		
		cnt = JDBC_Dao.getConnection();
		String sql = "INSERT INTO Graduation VALUES (null,?,?,?)";
		
		try {
			ps=cnt.prepareStatement(sql);
			
			ps.setInt(1, sid);
			ps.setString(2, thedate);
			ps.setString(3, remark);

			result=ps.execute();
		} catch (Exception e) {
			
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return result;
	}
	

	/* ��� �������Աְ�� */
	public boolean AddManagerDuty(int bid,int mid) {
		boolean result = true;
		
		cnt = JDBC_Dao.getConnection();
		String sql = "INSERT INTO Manager_Duty VALUES (null,?,?)";
		
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
	
	
	/* ��� ȱ����Ϣ */
	public boolean AddAbsence(int sid,int mid,String date,String area) {
		boolean result = true;
		
		cnt = JDBC_Dao.getConnection();
		String sql = "INSERT INTO Absence VALUES (null,?,?,?,?)";
		
		try {
			ps=cnt.prepareStatement(sql);
			
			ps.setInt(1, sid);
			ps.setInt(2, mid);
			ps.setString(3, date);
			ps.setString(4, area);
			
			result=ps.execute();
		} catch (Exception e) {
			
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return result;
	}

}
