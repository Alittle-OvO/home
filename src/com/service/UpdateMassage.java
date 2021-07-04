package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Building;
import com.entity.Building_Dormitory;
import com.entity.Manager;
import com.entity.Student;
import com.util.JDBC_Dao;

public class UpdateMassage {
	
	private Connection cnt=null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/* ��ȡ�������Աlist ById */
	public List<Manager> getManagerListByID(int id) {
		List<Manager> list = new ArrayList<Manager>();
		cnt = JDBC_Dao.getConnection();
		String sql = "select * from Manager where Manager_ID=? ";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, id);
			
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
	
	
	/* ��ȡѧ��list ById*/
	public List<Student> getStudentListByID(int id) {
		List<Student> list = new ArrayList<Student>();
		cnt = JDBC_Dao.getConnection();
		String sql = "select * from Student where student_id=?";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, id);
			
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
	
	
	/* ��ȡ¥��list ById*/
	public List<Building> getBuildingListById(int id) {
		List<Building> list = new ArrayList<Building>();
		cnt = JDBC_Dao.getConnection();
		String sql = "select * from Building where Building_ID=?";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, id);
			
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
	
	
	/* ��ȡ����list ById */
	public List<Building_Dormitory> getDormitoryListById(int id) {
		List<Building_Dormitory> list = new ArrayList<Building_Dormitory>();
		cnt = JDBC_Dao.getConnection();
		String sql = "select d.Domitory_ID,d.Domitory_BuildingID,b.Building_Name,d.Domitory_Name,d.Domitory_Type,d.Domitory_Number,d.Domitory_Tel from domitory d,building b where d.Domitory_BuildingID=b.Building_ID and domitory_id=?";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, id);
			
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
	
	
	/* ����¥��id��ȡ���Ӧ����list */
	public List<Building_Dormitory> getDormitoryListByBuilding_Id(int id) {
		List<Building_Dormitory> list = new ArrayList<Building_Dormitory>();
		cnt = JDBC_Dao.getConnection();
		String sql = "select d.Domitory_ID,d.Domitory_BuildingID,b.Building_Name,d.Domitory_Name,d.Domitory_Type,d.Domitory_Number,d.Domitory_Tel from domitory d,building b where d.Domitory_BuildingID=b.Building_ID and b.Building_id=?";
		try {
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, id);
			
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
	
		
	/*ѧ����ס*/
	  public int Student_check_in(String sid,int did){
		int result=0;
		try {
			String sql = "UPDATE student SET Student_state='����ס',Student_DomitoryID=? WHERE Student_Username=? and Student_state='δ��ס'";
			cnt = JDBC_Dao.getConnection();
			ps = cnt.prepareStatement(sql);
			
			ps.setInt(1, did);
			ps.setString(2, sid);
			
			result=ps.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			JDBC_Dao.close(cnt, ps, rs);
		}
		return result;
	}
	
	  
	/* �޸�admin���� */
	  public int Update_Admin_Pwd(String username,String renewpwd){
			int result=0;
			try {
				String sql = "UPDATE admin SET Admin_Password= ? WHERE Admin_Username= ?";
				cnt = JDBC_Dao.getConnection();
				ps = cnt.prepareStatement(sql);
				
				ps.setString(1, renewpwd);
				ps.setString(2, username);
				
				result=ps.executeUpdate();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				JDBC_Dao.close(cnt, ps, rs);
			}
			return result;
		}
	  
	  
	  /* �޸�manager���� */
	  public int Update_Manager_Pwd(String username,String renewpwd){
			int result=0;
			try {
				String sql = "UPDATE Manager SET Manager_Password= ? WHERE Manager_Username= ?";
				cnt = JDBC_Dao.getConnection();
				ps = cnt.prepareStatement(sql);
				
				ps.setString(1, renewpwd);
				ps.setString(2, username);
				
				result=ps.executeUpdate();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				JDBC_Dao.close(cnt, ps, rs);
			}
			return result;
		}
	  
	  
	  /* �޸�student���� */
	  public int Update_Student_Pwd(String username,String renewpwd){
			int result=0;
			try {
				String sql = "UPDATE Student SET Student_Password= ? WHERE Student_Username= ?";
				cnt = JDBC_Dao.getConnection();
				ps = cnt.prepareStatement(sql);
				
				ps.setString(1, renewpwd);
				ps.setString(2, username);
				
				result=ps.executeUpdate();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				JDBC_Dao.close(cnt, ps, rs);
			}
			return result;
		}
	  
	  
		/* �޸Ĺ���Ա NeedPwd*/
	  public int Update_Manager_NeedPwd(String username,String pwd,String name,String sex,String tel,int uid) {
		  int result=0;
			try {
				String sql = "UPDATE Manager SET Manager_Username= ?,Manager_Password= ?,Manager_Name= ?,Manager_Sex= ?,Manager_Tel= ? WHERE Manager_ID= ?";
				cnt = JDBC_Dao.getConnection();
				ps = cnt.prepareStatement(sql);
				
				ps.setString(1, username);
				ps.setString(2, pwd);
				ps.setString(3, name);
				ps.setString(4, sex);
				ps.setString(5, tel);
				ps.setInt(6, uid);
				
				result=ps.executeUpdate();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				JDBC_Dao.close(cnt, ps, rs);
			}
			return result;
	  }
	  
	  
		/* �޸Ĺ���Ա NoPwd*/
	  public int Update_Manager_NoPwd(String username,String name,String sex,String tel,int uid) {
		  int result=0;
			try {
				String sql = "UPDATE Manager SET Manager_Username= ?,Manager_Name= ?,Manager_Sex= ?,Manager_Tel= ? WHERE Manager_ID= ?";
				cnt = JDBC_Dao.getConnection();
				ps = cnt.prepareStatement(sql);
				
				ps.setString(1, username);
				ps.setString(2, name);
				ps.setString(3, sex);
				ps.setString(4, tel);
				ps.setInt(5, uid);
				
				result=ps.executeUpdate();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				JDBC_Dao.close(cnt, ps, rs);
			}
			return result;
	  }
	  
	  
	  /* �޸�ѧ�� NeedPwd*/
	  public int Update_Student_NeedPwd(String username,String pwd,String name,String sex,String classes,int uid) {
		  int result=0;
			try {
				String sql = "UPDATE Student SET Student_Username= ?,Student_Password= ?,Student_Name= ?,Student_Sex= ?,Student_Class= ? WHERE Student_ID= ?";
				cnt = JDBC_Dao.getConnection();
				ps = cnt.prepareStatement(sql);
				
				ps.setString(1, username);
				ps.setString(2, pwd);
				ps.setString(3, name);
				ps.setString(4, sex);
				ps.setString(5, classes);
				ps.setInt(6, uid);
				
				result=ps.executeUpdate();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				JDBC_Dao.close(cnt, ps, rs);
			}
			return result;
	  }
	  
	  
	  /* �޸�ѧ�� NoPwd*/
	  public int Update_Student_NoPwd(String username,String pwd,String name,String sex,String classes,int uid) {
		  int result=0;
			try {
				String sql = "UPDATE Student SET Student_Username= ?,Student_Name= ?,Student_Sex= ?,Student_Class= ? WHERE Student_ID= ?";
				cnt = JDBC_Dao.getConnection();
				ps = cnt.prepareStatement(sql);
				
				ps.setString(1, username);
				ps.setString(2, name);
				ps.setString(3, sex);
				ps.setString(4, classes);
				ps.setInt(5, uid);
				
				result=ps.executeUpdate();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				JDBC_Dao.close(cnt, ps, rs);
			}
			return result;
	  }
	  
	  
	  /* �޸�¥�� */
	  public int Update_Building(String bname,String area,int uid) {
		  int result=0;
			try {
				String sql = "UPDATE Building SET Building_Name= ?,Building_Introduction= ? WHERE Building_ID= ?";
				cnt = JDBC_Dao.getConnection();
				ps = cnt.prepareStatement(sql);
				
				ps.setString(1, bname);
				ps.setString(2, area);
				ps.setInt(3, uid);
				
				result=ps.executeUpdate();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				JDBC_Dao.close(cnt, ps, rs);
			}
			return result;
	  }
	  
	  
	  /* �޸����� */
	  public int Update_Dormitory(String dname,String type,String number,String tel,int bid,int uid) {
		  int result=0;
			try {
				String sql = "UPDATE Domitory SET Domitory_Name= ?,Domitory_Type= ?,Domitory_Number= ?,Domitory_Tel= ?,Domitory_BuildingID= ? WHERE Domitory_ID= ?";
				cnt = JDBC_Dao.getConnection();
				ps = cnt.prepareStatement(sql);
				
				ps.setString(1, dname);
				ps.setString(2, type);
				ps.setString(3, number);
				ps.setString(4, tel);
				ps.setInt(5, bid);
				ps.setInt(6, uid);
				
				result=ps.executeUpdate();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				JDBC_Dao.close(cnt, ps, rs);
			}
			return result;
	  }
	  
	  /* �޸�ѧ�� ��ҵ*/
	  public int Update_Student_Graduate(String username) {
		  int result=0;
			try {
				String sql = "UPDATE Student SET Student_State= '��Ǩ��' WHERE Student_Username = ?";
				cnt = JDBC_Dao.getConnection();
				ps = cnt.prepareStatement(sql);
				
				ps.setString(1, username);
				
				result=ps.executeUpdate();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				JDBC_Dao.close(cnt, ps, rs);
			}
			return result;
	  }
	  
	  
	  /* �޸�ѧ�� ���ҵ���*/
	  public int Update_Student_Change(String username,int did) {
		  int result=0;
			try {
				String sql = "UPDATE Student SET Student_DomitoryID = ? WHERE Student_Username = ?";
				cnt = JDBC_Dao.getConnection();
				ps = cnt.prepareStatement(sql);
				
				ps.setInt(1, did);
				ps.setString(2, username);
				
				result=ps.executeUpdate();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				JDBC_Dao.close(cnt, ps, rs);
			}
			return result;
	  }
	  
	  
	  
}
