package com.entity;

import java.io.Serializable;

public class Manager_Duty implements Serializable {

	/**
	 * @author Surlon
	 */
	private static final long serialVersionUID = 1L;

	private int MD_ID; //Ö°Îñid
	private int MD_ManagerID; //Éá¹Üid
	private int MD_BuildingID; //Â¥Óîid

	public Manager_Duty() {
	}

	public Manager_Duty(int mD_ID, int mD_ManagerID, int mD_BuildingID) {
		super();
		MD_ID = mD_ID;
		MD_ManagerID = mD_ManagerID;
		MD_BuildingID = mD_BuildingID;
	}

	public int getMD_ID() {
		return MD_ID;
	}

	public void setMD_ID(int mD_ID) {
		MD_ID = mD_ID;
	}

	public int getMD_ManagerID() {
		return MD_ManagerID;
	}

	public void setMD_ManagerID(int mD_ManagerID) {
		MD_ManagerID = mD_ManagerID;
	}

	public int getMD_BuildingID() {
		return MD_BuildingID;
	}

	public void setMD_BuildingID(int mD_BuildingID) {
		MD_BuildingID = mD_BuildingID;
	}

}
