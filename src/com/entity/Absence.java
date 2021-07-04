package com.entity;

import java.io.Serializable;

public class Absence implements Serializable {

	/**
	 * @author Surlon
	 */
	private static final long serialVersionUID = 1L;

	private int Absence_ID; // È±ÇÞid
	private int Absence_StudentID; // È±ÇÞÑ§Éúid
	private int Absence_ManagerID; // ËÞ¹Üid
	private String Absence_Date; // È±ÇÞÈÕÆÚ
	private String Absence_Remark; // È±ÇÞ±¸×¢

	public Absence() {
	}

	public Absence(int absence_ID, int absence_StudentID, int absence_ManagerID, String absence_Date,
			String absence_Remark) {
		super();
		Absence_ID = absence_ID;
		Absence_StudentID = absence_StudentID;
		Absence_ManagerID = absence_ManagerID;
		Absence_Date = absence_Date;
		Absence_Remark = absence_Remark;
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
