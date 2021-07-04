package com.entity;

import java.io.Serializable;

public class Student implements Serializable {

	/**
	 * @author Surlon
	 */
	private static final long serialVersionUID = 1L;
	
	private int Student_ID; //学生id
	private int Student_Dormitory;  //学生宿舍
	private String Student_Username; //学生账号
	private String Student_Password; //学生登录密码
	private String Student_Name; //学生姓名
	private String Student_Sex; //学生性别
	private String Student_Class; //学生班级
	private String Student_State;  //学生状况

	public Student() {
	}

	public Student(int student_ID, int student_Dormitory, String student_Username, String student_Password,
			String student_Name, String student_Sex, String student_Class, String student_State) {
		super();
		Student_ID = student_ID;
		Student_Dormitory = student_Dormitory;
		Student_Username = student_Username;
		Student_Password = student_Password;
		Student_Name = student_Name;
		Student_Sex = student_Sex;
		Student_Class = student_Class;
		Student_State = student_State;
	}

	public int getStudent_ID() {
		return Student_ID;
	}

	public void setStudent_ID(int student_ID) {
		Student_ID = student_ID;
	}

	public int getStudent_Dormitory() {
		return Student_Dormitory;
	}

	public void setStudent_Dormitory(int student_Dormitory) {
		Student_Dormitory = student_Dormitory;
	}

	public String getStudent_Username() {
		return Student_Username;
	}

	public void setStudent_Username(String student_Username) {
		Student_Username = student_Username;
	}

	public String getStudent_Password() {
		return Student_Password;
	}

	public void setStudent_Password(String student_Password) {
		Student_Password = student_Password;
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

	public String getStudent_State() {
		return Student_State;
	}

	public void setStudent_State(String student_State) {
		Student_State = student_State;
	}

}
