package com.entity;

import java.io.Serializable;

public class Absence_Student implements Serializable{

	/**
	 *@author Surlon
	 */
	private static final long serialVersionUID = 1L;
	
	private int Absence_ID; // 缺寝id
	private int Absence_StudentID; // 缺寝学生id
	private int Absence_ManagerID; // 宿管id
	private String Student_Name; //学生姓名
	private String Dormitory_Name; //宿舍名
	private String Student_Sex; //学生性别
	private String Absence_Date; // 缺寝日期
	private String Absence_Remark; // 缺寝备注
	private String Manager_Name; //舍管姓名
	
	public Absence_Student(){}

	public Absence_Student(int absence_ID, int absence_StudentID, int absence_ManagerID, String student_Name,
			String dormitory_Name, String student_Sex, String absence_Date, String absence_Remark,
			String manager_Name) {
		super();
		Absence_ID = absence_ID;
		Absence_StudentID = absence_StudentID;
		Absence_ManagerID = absence_ManagerID;
		Student_Name = student_Name;
		Dormitory_Name = dormitory_Name;
		Student_Sex = student_Sex;
		Absence_Date = absence_Date;
		Absence_Remark = absence_Remark;
		Manager_Name = manager_Name;
	}

	public int getAbsence_ID() {
		return Absence_ID;
	}

	public void setAbsence_ID(int absence_ID) {
		Absence_ID = absence_ID;
	}

	public int getAbsence_StudentID() {
		return Absence_StudentID;
	}

	public void setAbsence_StudentID(int absence_StudentID) {
		Absence_StudentID = absence_StudentID;
	}

	public int getAbsence_ManagerID() {
		return Absence_ManagerID;
	}

	public void setAbsence_ManagerID(int absence_ManagerID) {
		Absence_ManagerID = absence_ManagerID;
	}

	public String getStudent_Name() {
		return Student_Name;
	}

	public void setStudent_Name(String student_Name) {
		Student_Name = student_Name;
	}

	public String getDormitory_Name() {
		return Dormitory_Name;
	}

	public void setDormitory_Name(String dormitory_Name) {
		Dormitory_Name = dormitory_Name;
	}

	public String getStudent_Sex() {
		return Student_Sex;
	}

	public void setStudent_Sex(String student_Sex) {
		Student_Sex = student_Sex;
	}

	public String getAbsence_Date() {
		return Absence_Date;
	}

	public void setAbsence_Date(String absence_Date) {
		Absence_Date = absence_Date;
	}

	public String getAbsence_Remark() {
		return Absence_Remark;
	}

	public void setAbsence_Remark(String absence_Remark) {
		Absence_Remark = absence_Remark;
	}

	public String getManager_Name() {
		return Manager_Name;
	}

	public void setManager_Name(String manager_Name) {
		Manager_Name = manager_Name;
	}
	
	
	
	
	
	
}
