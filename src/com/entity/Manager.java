package com.entity;

import java.io.Serializable;

public class Manager implements Serializable {

	/**
	 * @author Surlon
	 */
	private static final long serialVersionUID = 1L;

	private int Manager_ID; //舍管id
	private String Manager_Username; //宿管账号
	private String Manager_Password; //密码
	private String Manager_Name; //舍管姓名
	private String Manager_Sex; //舍管性别
	private String Manager_Tel; //舍管电话

	public Manager() {
	}

	public Manager(int manager_ID, String manager_Username, String manager_Password, String manager_Name,
		String manager_Sex, String manager_Tel) {
		super();
		Manager_ID = manager_ID;
		Manager_Username = manager_Username;
		Manager_Password = manager_Password;
		Manager_Name = manager_Name;
		Manager_Sex = manager_Sex;
		Manager_Tel = manager_Tel;
	}

	public int getManager_ID() {
		return Manager_ID;
	}

	public void setManager_ID(int manager_ID) {
		Manager_ID = manager_ID;
	}

	public String getManager_Username() {
		return Manager_Username;
	}

	public void setManager_Username(String manager_Username) {
		Manager_Username = manager_Username;
	}

	public String getManager_Password() {
		return Manager_Password;
	}

	public void setManager_Password(String manager_Password) {
		Manager_Password = manager_Password;
	}

	public String getManager_Name() {
		return Manager_Name;
	}

	public void setManager_Name(String manager_Name) {
		Manager_Name = manager_Name;
	}

	public String getManager_Sex() {
		return Manager_Sex;
	}

	public void setManager_Sex(String manager_Sex) {
		Manager_Sex = manager_Sex;
	}

	public String getManager_Tel() {
		return Manager_Tel;
	}

	public void setManager_Tel(String manager_Tel) {
		Manager_Tel = manager_Tel;
	}

}
