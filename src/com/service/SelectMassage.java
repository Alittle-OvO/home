package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Absence_Manager;
import com.entity.Absence_Student;
import com.entity.Building;
import com.entity.Building_Dormitory;
import com.entity.Manager;
import com.entity.Student;
import com.entity.Student_Manager;
import com.util.JDBC_Dao;

public class SelectMassage {
	private Connection cnt=null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/* 获取宿舍管理员list ByUsername */
	public List<Manager> getManagerListByUsername(String thevalue) {
		List<Manager> list = new ArrayList<Manager>();
		cnt = JDBC_Dao.getConnection();
		String sql = "select * from Manager where Manager_Username like ?";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1, '%'+thevalue+'%');
			
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
	
	
	/* 获取宿舍管理员list ByTel */
	public List<Manager> getManagerListByTel(String thevalue) {
		List<Manager> list = new ArrayList<Manager>();
		cnt = JDBC_Dao.getConnection();
		String sql = "select * from Manager where Manager_Tel like ? ";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1, '%'+thevalue+'%');
			
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
	
	
	/* 获取宿舍管理员list ByName */
	public List<Manager> getManagerListByName(String thevalue) {
		List<Manager> list = new ArrayList<Manager>();
		cnt = JDBC_Dao.getConnection();
		String sql = "select * from Manager where Manager_Name like ? ";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1, '%'+thevalue+'%');
			
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

	
	/* 获取楼宇list ByBname*/
	public List<Building> getBuildingListByName(String bname) {
		List<Building> list = new ArrayList<Building>();
		cnt = JDBC_Dao.getConnection();
		String sql = "select * from Building where Building_Name like ?";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1, '%'+bname+'%');
			
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
		
	
	/* 获取学生list ById*/
	public List<Student> SelectStudentByID(String ID){
		List<Student> list = new ArrayList<Student>();
		cnt = JDBC_Dao.getConnection();
		
		String sql = "select * from Student where Student_ID=? ";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1, ID);
			
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
	
	
	/* 获取学生list ByStatus 状态*/
	public List<Student> SelectStudentByStatus(String status){
		List<Student> list = new ArrayList<Student>();
		cnt = JDBC_Dao.getConnection();
		
		String sql = "select * from Student where Student_State=? order by Student_Username";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1, status);
			
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
	
	
	/* 获取学生list ByStatusInAndName  状态 姓名*/
	public List<Student> SelectStudentByStatusAndName(String status,String name){
		List<Student> list = new ArrayList<Student>();
		cnt = JDBC_Dao.getConnection();
		
		String sql = "select * from Student where Student_State=? and Student_Name like ? order by Student_Name";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1, status);
			ps.setString(2, '%'+name+'%');
			
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
	
		 
	/* 获取学生list ByStatusInAndUsername 状态 学号*/
	public List<Student> SelectStudentByStatusAndUsername(String status,String username){
		List<Student> list = new ArrayList<Student>();
		cnt = JDBC_Dao.getConnection();
		
		String sql = "select * from Student where Student_State=? and Student_Username like ? order by Student_Username";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1, status);
			ps.setString(2, '%'+username+'%');
			
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
	
	
	/* 获取学生list ByStatusInAndClass 状态 班级*/
	public List<Student> SelectStudentByStatusAndTel(String status,String tel){
		List<Student> list = new ArrayList<Student>();
		cnt = JDBC_Dao.getConnection();
		
		String sql = "select * from Student where Student_State=? and Student_Class like ? order by Student_Class";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1, status);
			ps.setString(2, '%'+tel+'%');
			
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
	
	
	/* 获取学生list ByName 全部 姓名*/
	public List<Student> SelectStudentByName(String name){
		List<Student> list = new ArrayList<Student>();
		cnt = JDBC_Dao.getConnection();
		
		String sql = "select * from Student where Student_Name like ? order by Student_Name";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1, '%'+name+'%');
			
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
	
	
	/* 获取学生list ByClass 全部 班级*/
	public List<Student> SelectStudentByClass(String theclass){
		List<Student> list = new ArrayList<Student>();
		cnt = JDBC_Dao.getConnection();
		
		String sql = "select * from Student where Student_Class like ? order by Student_Class";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1, '%'+theclass+'%');
			
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
	
	
	/* 获取学生list ByUsername 全部 学号*/
	public List<Student> SelectStudentByUsername1(String Student_Username){
		List<Student> list = new ArrayList<Student>();
		cnt = JDBC_Dao.getConnection();
		
		String sql = "select * from Student where Student_Username like ? order by Student_Username ";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1, '%'+Student_Username+'%');
			
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
	
	
	/* 获取学生list ByUsername  准确查找*/
	public List<Student> SelectStudentByUsername(String Student_Username){
		List<Student> list = new ArrayList<Student>();
		cnt = JDBC_Dao.getConnection();
		
		String sql = "select * from Student where Student_Username=?";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1,Student_Username);
			
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
	
		
	/* 获取宿舍list  楼宇id值  空*/
	public List<Building_Dormitory> SelectDormitoryByBid(int bid) {
		List<Building_Dormitory> list = new ArrayList<Building_Dormitory>();
		cnt = JDBC_Dao.getConnection();
		String sql = "select d.Domitory_ID,d.Domitory_BuildingID,b.Building_Name,d.Domitory_Name,d.Domitory_Type,d.Domitory_Number,d.Domitory_Tel from domitory d,building b where d.Domitory_BuildingID=b.Building_ID and b.Building_ID=?";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, bid);
			
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
	
	
	/* 获取宿舍list  全部  信息*/
	public List<Building_Dormitory> SelectDormitoryByMassage(int msg,String txt) {
		List<Building_Dormitory> list = new ArrayList<Building_Dormitory>();
		cnt = JDBC_Dao.getConnection();
		
		String sql="";
		if (msg==1) {
			sql = "select d.Domitory_ID,d.Domitory_BuildingID,b.Building_Name,d.Domitory_Name,d.Domitory_Type,d.Domitory_Number,d.Domitory_Tel from domitory d,building b where d.Domitory_BuildingID=b.Building_ID and d.Domitory_Name like ?";
		}else {
			sql = "select d.Domitory_ID,d.Domitory_BuildingID,b.Building_Name,d.Domitory_Name,d.Domitory_Type,d.Domitory_Number,d.Domitory_Tel from domitory d,building b where d.Domitory_BuildingID=b.Building_ID and d.Domitory_Tel like ?";
		}
		
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1, '%'+txt+'%');;
			
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
	
	
	/* 获取宿舍list  楼宇id  信息*/
	public List<Building_Dormitory> SelectDormitoryByBidMsg(int msg,int bid,String txt) {
		List<Building_Dormitory> list = new ArrayList<Building_Dormitory>();
		cnt = JDBC_Dao.getConnection();
		
		String sql="";
		if (msg==1) {
			sql = "select d.Domitory_ID,d.Domitory_BuildingID,b.Building_Name,d.Domitory_Name,d.Domitory_Type,d.Domitory_Number,d.Domitory_Tel from domitory d,building b where d.Domitory_BuildingID=b.Building_ID and d.Domitory_BuildingID= ?  and d.Domitory_Name like ?";
		}else {
			sql = "select d.Domitory_ID,d.Domitory_BuildingID,b.Building_Name,d.Domitory_Name,d.Domitory_Type,d.Domitory_Number,d.Domitory_Tel from domitory d,building b where d.Domitory_BuildingID=b.Building_ID and d.Domitory_BuildingID= ?  and d.Domitory_Tel like ?";
		}
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, bid);
			ps.setString(2, '%'+txt+'%');;
			
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
	
	
	/* 获取缺寢学生list  username*/
	public List<Absence_Student> SelectAbsence(String username) {
		List<Absence_Student> list = new ArrayList<Absence_Student>();
		cnt = JDBC_Dao.getConnection();
		
		String sql="SELECT a.Absence_ID,a.Absence_StudentID,a.Absence_ManagerID,s.Student_Name,d.Domitory_Name,s.Student_Sex,a.Absence_Date,a.Absence_Remark,m.Manager_Name from absence a,domitory d,manager m,student s WHERE s.Student_ID=a.Absence_StudentID and s.Student_DomitoryID=d.Domitory_ID and a.Absence_ManagerID=m.Manager_ID AND s.Student_Username= ?";
		
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setString(1, username);
			
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
	
	
	/* 查询学生list 全部宿舍 条件   manager */
	public List<Student_Manager> SelectStudentList_Manager(int bid,int did) {
		List<Student_Manager> list = new ArrayList<Student_Manager>();
		cnt = JDBC_Dao.getConnection();
		
		String sql = "SELECT s.Student_ID,d.Domitory_ID,s.Student_Name,s.Student_Sex,s.Student_Class,d.Domitory_Name,d.Domitory_Type,d.Domitory_Number,d.Domitory_Tel from domitory d,building b,student s WHERE s.Student_DomitoryID=d.Domitory_ID and b.Building_ID=d.Domitory_BuildingID and b.Building_ID= ? and s.Student_State='已入住' and d.Domitory_ID=?";
		
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, bid);
			ps.setInt(2, did);
			
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
	
	
	/* 查询学生list 宿舍号 条件   manager */
	public List<Student_Manager> SelectStudentListByMsg_Manager(int bid,int msg,String txt,int did) {
		List<Student_Manager> list = new ArrayList<Student_Manager>();
		cnt = JDBC_Dao.getConnection();
		
		String sql="";
		if (msg==1) {
			sql = "SELECT s.Student_ID,d.Domitory_ID,s.Student_Name,s.Student_Sex,s.Student_Class,d.Domitory_Name,d.Domitory_Type,d.Domitory_Number,d.Domitory_Tel from domitory d,building b,student s WHERE s.Student_DomitoryID=d.Domitory_ID and b.Building_ID=d.Domitory_BuildingID and b.Building_ID= ? and s.Student_State='已入住' and s.Student_Name like ? and d.Domitory_ID=?";
		}else {
			sql = "SELECT s.Student_ID,d.Domitory_ID,s.Student_Name,s.Student_Sex,s.Student_Class,d.Domitory_Name,d.Domitory_Type,d.Domitory_Number,d.Domitory_Tel from domitory d,building b,student s WHERE s.Student_DomitoryID=d.Domitory_ID and b.Building_ID=d.Domitory_BuildingID and b.Building_ID= ? and s.Student_State='已入住' and s.Student_Class like ? and d.Domitory_ID=?";
		}
		
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, bid);
			ps.setString(2, '%'+txt+'%');
			ps.setInt(3, did);
			
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
	
	
	/* 查询学生list 全部宿舍 条件   manager */
	public List<Student_Manager> SelectStudentListByAllMsg_Manager(int bid,int msg,String txt) {
		List<Student_Manager> list = new ArrayList<Student_Manager>();
		cnt = JDBC_Dao.getConnection();
		
		String sql="";
		if (msg==1) {
			sql = "SELECT s.Student_ID,d.Domitory_ID,s.Student_Name,s.Student_Sex,s.Student_Class,d.Domitory_Name,d.Domitory_Type,d.Domitory_Number,d.Domitory_Tel from domitory d,building b,student s WHERE s.Student_DomitoryID=d.Domitory_ID and b.Building_ID=d.Domitory_BuildingID and b.Building_ID= ? and s.Student_State='已入住' and s.Student_Name like ?";
		}else {
			sql = "SELECT s.Student_ID,d.Domitory_ID,s.Student_Name,s.Student_Sex,s.Student_Class,d.Domitory_Name,d.Domitory_Type,d.Domitory_Number,d.Domitory_Tel from domitory d,building b,student s WHERE s.Student_DomitoryID=d.Domitory_ID and b.Building_ID=d.Domitory_BuildingID and b.Building_ID= ? and s.Student_State='已入住' and s.Student_Class like ?";
		}
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, bid);
			ps.setString(2, '%'+txt+'%');
			
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
	
	
	/* 查询学生缺寝list 宿舍id 空 */
	public List<Absence_Manager> SelectAbsenceListByDid_Manager(int bid,int did) {
		List<Absence_Manager> list = new ArrayList<Absence_Manager>();
		cnt = JDBC_Dao.getConnection();
		
		String sql = "SELECT a.Absence_StudentID,d.Domitory_Name,s.Student_Name,s.Student_Sex,s.Student_Class,a.Absence_Date,a.Absence_Remark from domitory d,student s,absence a WHERE s.Student_DomitoryID=d.Domitory_ID and a.Absence_StudentID=s.Student_ID and d.Domitory_BuildingID=? and s.Student_State='已入住' and d.Domitory_ID= ? ";
		
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, bid);
			ps.setInt(2, did);
			
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
	
	
	/* 查询学生缺寝list 全部宿舍 条件 */
	public List<Absence_Manager> SelectAbsenceListByMsg_Manager(int bid,int msg,String txt) {
		List<Absence_Manager> list = new ArrayList<Absence_Manager>();
		cnt = JDBC_Dao.getConnection();
		
		String sql="";
		if (msg==1) {
			sql = "SELECT a.Absence_StudentID,d.Domitory_Name,s.Student_Name,s.Student_Sex,s.Student_Class,a.Absence_Date,a.Absence_Remark from domitory d,student s,absence a WHERE s.Student_DomitoryID=d.Domitory_ID and a.Absence_StudentID=s.Student_ID and d.Domitory_BuildingID=? and s.Student_State='已入住' and s.Student_Name like ?";
		}else {
			sql = "SELECT a.Absence_StudentID,d.Domitory_Name,s.Student_Name,s.Student_Sex,s.Student_Class,a.Absence_Date,a.Absence_Remark from domitory d,student s,absence a WHERE s.Student_DomitoryID=d.Domitory_ID and a.Absence_StudentID=s.Student_ID and d.Domitory_BuildingID=? and s.Student_State='已入住' and s.Student_Class like ? ";

		}
		
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, bid);
			ps.setString(2, '%'+txt+'%');;
			
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
	
	
	/* 查询学生缺寝list 宿舍id 条件 */
	public List<Absence_Manager> SelectAbsenceListByAllMsg_Manager(int bid,int msg,String txt,int did) {
		List<Absence_Manager> list = new ArrayList<Absence_Manager>();
		cnt = JDBC_Dao.getConnection();
		
		String sql="";
		if (msg==1) {
			sql = "SELECT a.Absence_StudentID,d.Domitory_Name,s.Student_Name,s.Student_Sex,s.Student_Class,a.Absence_Date,a.Absence_Remark from domitory d,student s,absence a WHERE s.Student_DomitoryID=d.Domitory_ID and a.Absence_StudentID=s.Student_ID and d.Domitory_BuildingID=? and s.Student_State='已入住' and s.Student_Name like ? and d.Domitory_ID=?";
		}else {
			sql = "SELECT a.Absence_StudentID,d.Domitory_Name,s.Student_Name,s.Student_Sex,s.Student_Class,a.Absence_Date,a.Absence_Remark from domitory d,student s,absence a WHERE s.Student_DomitoryID=d.Domitory_ID and a.Absence_StudentID=s.Student_ID and d.Domitory_BuildingID=? and s.Student_State='已入住' and s.Student_Class like ? and d.Domitory_ID=? ";
		}
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, bid);
			ps.setString(2, '%'+txt+'%');;
			ps.setInt(3, 3);
			
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
	
	
	public static void main(String[] args) {
		new SelectMassage().SelectDormitoryByBidMsg(1, 3, "3").get(0).getDormitory_BuildingID();
	}
	
	
}
