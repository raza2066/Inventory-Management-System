package com.raza.material.bean;

public class UnitBean {
	private String unit_id;
	private String unit_name;
	private String category_id;
	
	public UnitBean() {
		super();
	}
	
	public UnitBean(String unit_id, String unit_name, String category_id) {
		super();
		this.unit_id = unit_id;
		this.unit_name = unit_name;
		this.category_id = category_id;
	}

	public String getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}

	public String getUnit_name() {
		return unit_name;
	}

	public void setUnit_name(String unit_name) {
		this.unit_name = unit_name;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "UnitBean [unit_id=" + unit_id + ", unit_name=" + unit_name + ", category_id=" + category_id + "]";
	}
}
