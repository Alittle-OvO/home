package com.entity;

import java.io.Serializable;

public class Absence_Manager implements Serializable{
	/**
	 * @author Surlon
	 */
	private static final long serialVersionUID = 1L;
	
	private int Absence_StudentID; // 缺寝学生id
	private String Dormitory_Name; //宿舍名
	private String Student_Name; //学生姓名
	private String Student_Sex; //学生性别
	private String Student_Class; //学生班级
	private String Absence_Date; // 缺寝日期
	private String Absence_Remark; // 缺寝备注
	
	public Absence_Manager(){}
	
	public Absence_Manager(int absence_StudentID, String dormitory_Name, String student_Name, String student_Sex,
			String student_Class, String absence_Date, String absence_Remark) {
		super();
		Absence_StudentID = absence_StudentID;
		Dormitory_Name = dormitory_Name;
		Student_Name = student_Name;
		Student_Sex = student_Sex;
		Student_Class = student_Class;
		Absence_Date = absence_Date;
		Absence_Remark = absence_Remark;
	}

	public int getAbsence_StudentID() {
		return Absence_StudentID;
	}

	public void setAbsence_StudentID(int absence_StudentID) {
		Absence_StudentID = absence_StudentID;
	}

	public String getDormitory_Name() {
		return Dormitory_Name;
	}

	public void setDormitory_Name(String dormitory_Name) {
		Dormitory_Name = dormitory_Name;
	}

	public String getStudent_Name() {
		return Student_Name;
	}

	public void setStudent_Name(String student_Name) {
		Student_Name = student_Name;
	}

	public String getStudent_Sex() {
		return Student_Sex;
	}

	public void setStudent_Sex(String student_Sex) {
		Student_Sex = student_Sex;
	}

	public String getStudent_Class() {
		return Student_Class;
	}

	public void setStudent_Class(String student_Class) {
		Student_Class = student_Class;
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
	
	
	
}
