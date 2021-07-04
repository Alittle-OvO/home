package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.Admin;
import com.entity.Manager;
import com.entity.Student;
import com.util.JDBC_Dao;

public class ToLogin {
	/**
	 * @author Surlon
	 * */
	
	private Connection cnt=null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/* 超级管理员登陆验证 */
	public Admin adminLogin(String username,String pwd) {
		Admin admin = null;
		try {
			cnt = JDBC_Dao.getConnection();
			String sql="select * from admin where Admin_Username = ? and Admin_Password = ?  ";		
			
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				int admin_ID = rs.getInt(1);
				String admin_Username = rs.getString(2);
				String admin_Password = rs.getString(3);
				String admin_Name = rs.getString(4);
				String admin_Sex = rs.getString(5);
				String admin_Tel = rs.getString(6);
				
				admin = new Admin(admin_ID, admin_Username, admin_Password, admin_Name, admin_Sex, admin_Tel);
			}
			return admin;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return admin;
	}	
	
	
	/* 宿舍管理员登录验证 */
	public Manager managerLogin(String username,String pwd) {
		Manager manager = null;		
		try {
			cnt = JDBC_Dao.getConnection();
			String sql = "select * from manager where Manager_Username = ? and Manager_Password = ? ";
			ps = cnt.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				int manager_ID = rs.getInt(1);
				String manager_Username = rs.getString(2);
				String manager_Password = rs.getString(3);
				String manager_Name = rs.getString(4);
				String manager_Sex = rs.getString(5);
				String manager_Tel = rs.getString(6);
	
				manager = new Manager(manager_ID, manager_Username, manager_Password, manager_Name, manager_Sex, manager_Tel);
			}
			return manager;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}		
		return manager;
	}
	
	/* 学生登陆验证 */
	public Student studentLogin(String username,String pwd) {
		Student student = null;
		try {
			cnt = JDBC_Dao.getConnection();
			String sql = "select * from student where Student_Username = ? and Student_Password = ? ";
			ps = cnt.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				int student_ID = rs.getInt(1);
				int student_Dormitory = rs.getInt(2);
				String student_Username = rs.getString(3);
				String student_Password = rs.getString(4);
				String student_Name = rs.getString(5);
				String student_Sex = rs.getString(6);
				String student_Class = rs.getString(7);
				String student_State = rs.getString(8);
							
				student = new Student(student_ID, student_Dormitory, student_Username, student_Password, student_Name, student_Sex, student_Class, student_State);
			}
			return student;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}		
		return student;
	}
	
}
