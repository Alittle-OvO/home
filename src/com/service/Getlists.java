package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Absence_Check;
import com.entity.Absence_Manager;
import com.entity.Absence_Student;
import com.entity.Building;
import com.entity.Building_Dormitory;
import com.entity.Dormitory;
import com.entity.Graduation_Student;
import com.entity.Manager;
import com.entity.Student;
import com.entity.Student_Manager;
import com.util.JDBC_Dao;

public class Getlists {
	
	private Connection cnt=null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/* 获取宿舍管理员list */
	public List<Manager> getManagerList() {
		List<Manager> list = new ArrayList<Manager>();
		cnt = JDBC_Dao.getConnection();
		String sql = "select * from Manager";
		try {
			ps = cnt.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int manager_ID = rs.getInt(1);
				String manager_Username = rs.getString(2);
				String manager_Password = rs.getString(3);
				String manager_Name = rs.getString(4);
				String manager_Sex = rs.getString(5);
				String manager_Tel = rs.getString(6);								
				
				Manager manager = new Manager(manager_ID, manager_Username, manager_Password, manager_Name, manager_Sex, manager_Tel);
				list.add(manager);
			}
			return list;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return list;
	}
	
	
	/* 获取学生list */
	public List<Student> getStudentList() {
		List<Student> list = new ArrayList<Student>();
		cnt = JDBC_Dao.getConnection();
		String sql = "select * from Student";
		try {
			ps = cnt.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int student_ID = rs.getInt(1);
				int student_Dormitory = rs.getInt(2);
				String student_Username = rs.getString(3);
				String student_Password = rs.getString(4);
				String student_Name = rs.getString(5);
				String student_Sex = rs.getString(6);	
				String student_Class = rs.getString(7);	
				String student_State = rs.getString(8);	
				
				Student student = new Student(student_ID, student_Dormitory, student_Username, student_Password, student_Name, student_Sex, student_Class, student_State);
				list.add(student);
			}
			return list;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return list;
	}
	
	
	/* 获取楼宇list */
	public List<Building> getBuildingList() {
		List<Building> list = new ArrayList<Building>();
		cnt = JDBC_Dao.getConnection();
		String sql = "select * from Building";
		try {
			ps = cnt.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int building_ID = rs.getInt(1);
				String building_Name = rs.getString(2);	
				String building_Introduction = rs.getString(3);						
				
				Building building = new Building(building_ID, building_Name, building_Introduction);
				list.add(building);
			}
			return list;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return list;
	}
	
	
	/* 获取宿舍list */
	public List<Building_Dormitory> getDormitoryList() {
		List<Building_Dormitory> list = new ArrayList<Building_Dormitory>();
		cnt = JDBC_Dao.getConnection();
		String sql = "select d.Domitory_ID,d.Domitory_BuildingID,b.Building_Name,d.Domitory_Name,d.Domitory_Type,d.Domitory_Number,d.Domitory_Tel from domitory d,building b where d.Domitory_BuildingID=b.Building_ID";
		try {
			ps = cnt.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int dormitory_ID = rs.getInt(1);
				int dormitory_BuildingID = rs.getInt(2);
				String building_Name = rs.getString(3);
				String dormitory_Name = rs.getString(4);
				String dormitory_Type = rs.getString(5);
				String dormitory_Number = rs.getString(6);
				String dormitory_Tel = rs.getString(7);							
				
				Building_Dormitory bd = new Building_Dormitory(dormitory_ID, dormitory_BuildingID, building_Name, dormitory_Name, dormitory_Type, dormitory_Number, dormitory_Tel);
				list.add(bd);
			}
			return list;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return list;
	}
	
	/* 获取list 毕业迁出 */
	public List<Graduation_Student> getGraduationList() {
		List<Graduation_Student> list = new ArrayList<Graduation_Student>();
		cnt = JDBC_Dao.getConnection();
		
		String sql = "select g.Graduation_ID,s.Student_ID,s.Student_Name,s.Student_Sex,s.Student_Class,g.Graduation_Date,g.Graduation_Remark from Graduation g,Student s where g.Graduation_StudentID = s.Student_ID ";
		
		try {
			ps = cnt.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int graduation_ID = rs.getInt(1);
				int graduation_StudentID = rs.getInt(2);
				String student_Name = rs.getString(3);	
				String student_Sex = rs.getString(4);	
				String student_Class = rs.getString(5);
				String graduation_Date = rs.getString(6);	
				String graduation_Remark = rs.getString(7);	

				Graduation_Student graduation_Student = new Graduation_Student(graduation_ID, graduation_StudentID, student_Name, student_Sex, student_Class, graduation_Date, graduation_Remark);
				list.add(graduation_Student);
			}
			return list;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return list;
	}
	
	
	/* 获取宿舍管理员list 职务 */
	public List<Manager> getManagerDutyList(int bid) {
		List<Manager> list = new ArrayList<Manager>();
		cnt = JDBC_Dao.getConnection();
		
		String sql = "select m.Manager_ID,m.Manager_Username,m.Manager_Password,m.Manager_Name,m.Manager_Sex,m.Manager_Tel from Manager m,manager_duty md WHERE m.Manager_ID=md.MD_ManagerID and md.MD_BuildingID= ?";
		
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1,bid );
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int manager_ID = rs.getInt(1);
				String manager_Username = rs.getString(2);
				String manager_Password = rs.getString(3);
				String manager_Name = rs.getString(4);
				String manager_Sex = rs.getString(5);
				String manager_Tel = rs.getString(6);								
				
				Manager manager = new Manager(manager_ID, manager_Username, manager_Password, manager_Name, manager_Sex, manager_Tel);
				list.add(manager);
			}
			return list;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return list;
	}
	
	
	/* 获取我的缺寢list  uid*/
	public List<Absence_Student> GetMyAbsenceList(int uid) {
		List<Absence_Student> list = new ArrayList<Absence_Student>();
		cnt = JDBC_Dao.getConnection();
		
		String sql="SELECT a.Absence_ID,a.Absence_StudentID,a.Absence_ManagerID,s.Student_Name,d.Domitory_Name,s.Student_Sex,a.Absence_Date,a.Absence_Remark,m.Manager_Name from absence a,domitory d,manager m,student s WHERE s.Student_ID=a.Absence_StudentID and s.Student_DomitoryID=d.Domitory_ID and a.Absence_ManagerID=m.Manager_ID AND s.Student_ID= ?";
		
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, uid);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int absence_ID = rs.getInt(1);
				int absence_StudentID = rs.getInt(2);
				int absence_ManagerID = rs.getInt(3);
				String student_Name = rs.getString(4);
				String dormitory_Name = rs.getString(5);
				String student_Sex = rs.getString(6);
				String absence_Date = rs.getString(7);	
				String absence_Remark = rs.getString(8);	
				String manager_Name = rs.getString(9);	
				
				Absence_Student as = new Absence_Student(absence_ID, absence_StudentID, absence_ManagerID, student_Name, dormitory_Name, student_Sex, absence_Date, absence_Remark, manager_Name);
				list.add(as);
			}
			return list;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return list;
	}
	
	
	/* 获取楼宇list managerDuty */
	public List<Building> getBuildingName_ManagerDuty(int uid) {
		List<Building> list = new ArrayList<Building>();
		cnt = JDBC_Dao.getConnection();
		String sql = "SELECT b.Building_ID,b.Building_Name,b.Building_Introduction from building b,manager_duty md WHERE md.MD_BuildingID=b.Building_ID AND md.MD_ManagerID= ?";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, uid);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int building_ID = rs.getInt(1);
				String building_Name = rs.getString(2);	
				String building_Introduction = rs.getString(3);						
				
				Building building = new Building(building_ID, building_Name, building_Introduction);
				list.add(building);
			}
			return list;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return list;
	}
	
	
	/* 获取学生list manager */
	public List<Student_Manager> getStudentList_Manager(int bid) {
		List<Student_Manager> list = new ArrayList<Student_Manager>();
		cnt = JDBC_Dao.getConnection();
		String sql = "SELECT s.Student_ID,d.Domitory_ID,s.Student_Name,s.Student_Sex,s.Student_Class,d.Domitory_Name,d.Domitory_Type,d.Domitory_Number,d.Domitory_Tel from domitory d,building b,student s WHERE s.Student_DomitoryID=d.Domitory_ID and b.Building_ID=d.Domitory_BuildingID and b.Building_ID= ? and s.Student_State='已入住'";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, bid);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int student_ID = rs.getInt(1);
				int dormitory_ID = rs.getInt(2);
				String student_Name = rs.getString(3);	
				String student_Sex = rs.getString(4);	
				String student_Class = rs.getString(5);
				String dormitory_Name = rs.getString(6);
				String dormitory_Type = rs.getString(7);
				String dormitory_Number = rs.getString(8);
				String dormitory_Tel = rs.getString(9);
				
				Student_Manager sm = new Student_Manager(student_ID, dormitory_ID, student_Name, student_Sex, student_Class, dormitory_Name, dormitory_Type, dormitory_Number, dormitory_Tel);
				list.add(sm);
			}
			return list;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return list;
	}
	
	
	/* 获取学生缺寝list manager */
	public List<Absence_Manager> getAbsenceList_Manager(int bid) {
		List<Absence_Manager> list = new ArrayList<Absence_Manager>();
		cnt = JDBC_Dao.getConnection();
		String sql = "SELECT a.Absence_StudentID,d.Domitory_Name,s.Student_Name,s.Student_Sex,s.Student_Class,a.Absence_Date,a.Absence_Remark from domitory d,student s,absence a WHERE s.Student_DomitoryID=d.Domitory_ID and a.Absence_StudentID=s.Student_ID and d.Domitory_BuildingID=? and s.Student_State='已入住'";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, bid);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int absence_StudentID = rs.getInt(1);
				String dormitory_Name = rs.getString(2);	
				String student_Name = rs.getString(3);	
				String student_Sex = rs.getString(4);
				String student_Class = rs.getString(5);
				String absence_Date = rs.getString(6);
				String absence_Remark = rs.getString(7);
				
				Absence_Manager am = new Absence_Manager(absence_StudentID, dormitory_Name, student_Name, student_Sex, student_Class, absence_Date, absence_Remark);
				list.add(am);
			}
			return list;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return list;
	}
	
	
	/* 获取学生缺寝list manager */
	public List<Absence_Check> getAbsence_Check(int sid) {
		List<Absence_Check> list = new ArrayList<Absence_Check>();
		cnt = JDBC_Dao.getConnection();
		String sql = "SELECT s.Student_ID,md.MD_ManagerID,s.Student_Name,s.Student_Sex,s.Student_Class,d.Domitory_Name,s.Student_Username from student s,manager_duty md,domitory d WHERE md.MD_BuildingID=d.Domitory_BuildingID  and s.Student_DomitoryID=d.Domitory_ID and s.Student_ID= ? and s.Student_State ='已入住'";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, sid);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int absence_StudentID = rs.getInt(1);
				int manager_ID=rs.getInt(2);
				String student_Name = rs.getString(3);	
				String student_Sex = rs.getString(4);	
				String student_Class = rs.getString(5);
				String dormitory_Name = rs.getString(6);
				String student_Username = rs.getString(7);
				
				Absence_Check ac = new Absence_Check(absence_StudentID, manager_ID, student_Name, student_Sex, student_Class, dormitory_Name, null, null, student_Username, 0);
				list.add(ac);
			}
			return list;
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC_Dao.close(cnt, ps, rs);
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		Getlists gl = new Getlists();
		List<Building> list = gl.getBuildingList();
		System.out.println(list.get(1).getBuilding_Name());
	}
	
	
}
