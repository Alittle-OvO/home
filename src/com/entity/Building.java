package com.entity;

import java.io.Serializable;

public class Building implements Serializable {

	/**
	 * @author Surlon
	 */
	private static final long serialVersionUID = 1L;

	private int Building_ID; //Â¥Óîid
	private String Building_Name; //Â¥ÓîÃû
	private String Building_Introduction; //Â¥Óî½éÉÜ

	public Building() {
	}

	public Building(int building_ID, String building_Name, String building_Introduction) {
		super();
		Building_ID = building_ID;
		Building_Name = building_Name;
		Building_Introduction = building_Introduction;
	}

	public int getBuilding_ID() {
		return Building_ID;
	}

	public void setBuilding_ID(int building_ID) {
		Building_ID = building_ID;
	}

	public String getBuilding_Name() {
		return Building_Name;
	}

	public void setBuilding_Name(String building_Name) {
		Building_Name = building_Name;
	}

	public String getBuilding_Introduction() {
		return Building_Introduction;
	}

	public void setBuilding_Introduction(String building_Introduction) {
		Building_Introduction = building_Introduction;
	}

}
