package com.entity;

import java.io.Serializable;

public class Admin implements Serializable {

	/**
	 * @author Surlon
	 */
	private static final long serialVersionUID = 1L;

	private int Admin_ID; // 超管id
	private String Admin_Username; // 超管账号
	private String Admin_Password; // 超管密码
	private String Admin_Name; // 超管姓名
	private String Admin_Sex; // 超管性别
	private String Admin_Tel; // 超管电话

	public Admin() {
	}

	public Admin(int admin_ID, String admin_Username, String admin_Password, String admin_Name, String admin_Sex,
			String admin_Tel) {
		super();
		Admin_ID = admin_ID;
		Admin_Username = admin_Username;
		Admin_Password = admin_Password;
		Admin_Name = admin_Name;
		Admin_Sex = admin_Sex;
		Admin_Tel = admin_Tel;
	}

	public int getAdmin_ID() {
		return Admin_ID;
	}

	public void setAdmin_ID(int admin_ID) {
		Admin_ID = admin_ID;
	}

	public String getAdmin_Username() {
		return Admin_Username;
	}

	public void setAdmin_Username(String admin_Username) {
		Admin_Username = admin_Username;
	}

	public String getAdmin_Password() {
		return Admin_Password;
	}

	public void setAdmin_Password(String admin_Password) {
		Admin_Password = admin_Password;
	}

	public String getAdmin_Name() {
		return Admin_Name;
	}

	public void setAdmin_Name(String admin_Name) {
		Admin_Name = admin_Name;
	}

	public String getAdmin_Sex() {
		return Admin_Sex;
	}

	public void setAdmin_Sex(String admin_Sex) {
		Admin_Sex = admin_Sex;
	}

	public String getAdmin_Tel() {
		return Admin_Tel;
	}

	public void setAdmin_Tel(String admin_Tel) {
		Admin_Tel = admin_Tel;
	}

}
