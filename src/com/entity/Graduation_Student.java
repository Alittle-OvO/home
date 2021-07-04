package com.entity;

import java.io.Serializable;

public class Graduation_Student implements Serializable {

	/**
	 * @author Surlon
	 */
	private static final long serialVersionUID = 1L;

	private int Graduation_ID; // 毕业id
	private int Graduation_StudentID; // 毕业学生id
	private String Student_Name; // 学生姓名
	private String Student_Sex; // 学生性别
	private String Student_Class;
	private String Graduation_Date; // 毕业时间
	private String Graduation_Remark; // 备注

	public Graduation_Student() {
	}

	public Graduation_Student(int graduation_ID, int graduation_StudentID, String student_Name, String student_Sex,
			String student_Class, String graduation_Date, String graduation_Remark) {
		super();
		Graduation_ID = graduation_ID;
		Graduation_StudentID = graduation_StudentID;
		Student_Name = student_Name;
		Student_Sex = student_Sex;
		Student_Class = student_Class;
		Graduation_Date = graduation_Date;
		Graduation_Remark = graduation_Remark;
	}

	public int getGraduation_ID() {
		return Graduation_ID;
	}

	public void setGraduation_ID(int graduation_ID) {
		Graduation_ID = graduation_ID;
	}

	public int getGraduation_StudentID() {
		return Graduation_StudentID;
	}

	public void setGraduation_StudentID(int graduation_StudentID) {
		Graduation_StudentID = graduation_StudentID;
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

	public String getGraduation_Date() {
		return Graduation_Date;
	}

	public void setGraduation_Date(String graduation_Date) {
		Graduation_Date = graduation_Date;
	}

	public String getGraduation_Remark() {
		return Graduation_Remark;
	}

	public void setGraduation_Remark(String graduation_Remark) {
		Graduation_Remark = graduation_Remark;
	}

	

}
