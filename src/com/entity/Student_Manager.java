package com.entity;

import java.io.Serializable;

public class Student_Manager implements Serializable {
	/**
	 * @author Surlon
	 */
	private static final long serialVersionUID = 1L;
	private int Student_ID; // 学生id
	private int Dormitory_ID; // 宿舍id
	private String Student_Name; // 学生姓名
	private String Student_Sex; // 学生性别
	private String Student_Class; // 学生班级
	private String Dormitory_Name; // 宿舍名
	private String Dormitory_Type; // 宿舍类型
	private String Dormitory_Number; // 宿舍人数
	private String Dormitory_Tel; // 宿舍电话

	public Student_Manager() {
	}

	public Student_Manager(int student_ID, int dormitory_ID, String student_Name, String student_Sex,
			String student_Class, String dormitory_Name, String dormitory_Type, String dormitory_Number,
			String dormitory_Tel) {
		super();
		Student_ID = student_ID;
		Dormitory_ID = dormitory_ID;
		Student_Name = student_Name;
		Student_Sex = student_Sex;
		Student_Class = student_Class;
		Dormitory_Name = dormitory_Name;
		Dormitory_Type = dormitory_Type;
		Dormitory_Number = dormitory_Number;
		Dormitory_Tel = dormitory_Tel;
	}

	public int getStudent_ID() {
		return Student_ID;
	}

	public void setStudent_ID(int student_ID) {
		Student_ID = student_ID;
	}

	public int getDormitory_ID() {
		return Dormitory_ID;
	}

	public void setDormitory_ID(int dormitory_ID) {
		Dormitory_ID = dormitory_ID;
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

	public String getDormitory_Type() {
		return Dormitory_Type;
	}

	public void setDormitory_Type(String dormitory_Type) {
		Dormitory_Type = dormitory_Type;
	}

	public String getDormitory_Number() {
		return Dormitory_Number;
	}

	public void setDormitory_Number(String dormitory_Number) {
		Dormitory_Number = dormitory_Number;
	}

	public String getDormitory_Tel() {
		return Dormitory_Tel;
	}

	public void setDormitory_Tel(String dormitory_Tel) {
		Dormitory_Tel = dormitory_Tel;
	}

}
