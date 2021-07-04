package com.entity;

import java.io.Serializable;

public class Absence_Check implements Serializable {
	/**
	 * @author Surlon
	 */
	private static final long serialVersionUID = 1L;

	private int Absence_StudentID; // 缺寝学生id
	private int Manager_ID; // 记录的舍管id
	private String Student_Name; // 学生姓名
	private String Student_Sex; // 学生性别
	private String Student_Class; // 学生班级
	private String Dormitory_Name; // 宿舍名
	private String Absence_Date; // 缺寝日期
	private String Absence_Remark; // 缺寝备注
	private String Student_Username; // 学生学号
	private int Student_ID; // 宿舍id

	public Absence_Check() {
	}

	public Absence_Check(int absence_StudentID, int manager_ID, String student_Name, String student_Sex,
			String student_Class, String dormitory_Name, String absence_Date, String absence_Remark,
			String student_Username, int student_ID) {
		super();
		Absence_StudentID = absence_StudentID;
		Manager_ID = manager_ID;
		Student_Name = student_Name;
		Student_Sex = student_Sex;
		Student_Class = student_Class;
		Dormitory_Name = dormitory_Name;
		Absence_Date = absence_Date;
		Absence_Remark = absence_Remark;
		Student_Username = student_Username;
		Student_ID = student_ID;
	}

	public int getAbsence_StudentID() {
		return Absence_StudentID;
	}

	public void setAbsence_StudentID(int absence_StudentID) {
		Absence_StudentID = absence_StudentID;
	}

	public int getManager_ID() {
		return Manager_ID;
	}

	public void setManager_ID(int manager_ID) {
		Manager_ID = manager_ID;
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

	public String getDormitory_Name() {
		return Dormitory_Name;
	}

	public void setDormitory_Name(String dormitory_Name) {
		Dormitory_Name = dormitory_Name;
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

	public String getStudent_Username() {
		return Student_Username;
	}

	public void setStudent_Username(String student_Username) {
		Student_Username = student_Username;
	}

	public int getStudent_ID() {
		return Student_ID;
	}

	public void setStudent_ID(int student_ID) {
		Student_ID = student_ID;
	}

}
