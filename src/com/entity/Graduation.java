package com.entity;

import java.io.Serializable;

public class Graduation implements Serializable {

	/**
	 * @author Surlon
	 */
	private static final long serialVersionUID = 1L;

	private int Graduation_ID; //��ҵid
	private String Graduation_StudentID; //��ҵѧ��id
	private String Graduation_Date; //��ҵʱ��
	private String Graduation_Remark; //��ע

	public Graduation() {
	}

	public Graduation(int graduation_ID, String graduation_StudentID, String graduation_Date,
			String graduation_Remark) {
		super();
		Graduation_ID = graduation_ID;
		Graduation_StudentID = graduation_StudentID;
		Graduation_Date = graduation_Date;
		Graduation_Remark = graduation_Remark;
	}

	public int getGraduation_ID() {
		return Graduation_ID;
	}

	public void setGraduation_ID(int graduation_ID) {
		Graduation_ID = graduation_ID;
	}

	public String getGraduation_StudentID() {
		return Graduation_StudentID;
	}

	public void setGraduation_StudentID(String graduation_StudentID) {
		Graduation_StudentID = graduation_StudentID;
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
