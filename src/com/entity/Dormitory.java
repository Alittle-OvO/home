package com.entity;

import java.io.Serializable;

public class Dormitory implements Serializable {

	/**
	 * @author Surlon
	 */
	private static final long serialVersionUID = 1L;

	private int Dormitory_ID; //Àﬁ…·id
	private int Dormitory_BuildingID; //Àﬁ…·¬•”Óid
	private String Dormitory_Name; //Àﬁ…·√˚
	private String Dormitory_Type; //Àﬁ…·¿‡–Õ
	private String Dormitory_Number; //Àﬁ…·»À ˝
	private String Dormitory_Tel;	//Àﬁ…·µÁª∞

	public Dormitory() {
	}

	public Dormitory(int dormitory_ID, int dormitory_BuildingID, String dormitory_Name, String dormitory_Type,
			String dormitory_Number, String dormitory_Tel) {
		super();
		Dormitory_ID = dormitory_ID;
		Dormitory_BuildingID = dormitory_BuildingID;
		Dormitory_Name = dormitory_Name;
		Dormitory_Type = dormitory_Type;
		Dormitory_Number = dormitory_Number;
		Dormitory_Tel = dormitory_Tel;
	}

	public int getDormitory_ID() {
		return Dormitory_ID;
	}

	public void setDormitory_ID(int dormitory_ID) {
		Dormitory_ID = dormitory_ID;
	}

	public int getDormitory_BuildingID() {
		return Dormitory_BuildingID;
	}

	public void setDormitory_BuildingID(int dormitory_BuildingID) {
		Dormitory_BuildingID = dormitory_BuildingID;
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
