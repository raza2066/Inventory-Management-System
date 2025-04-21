package com.raza.material.bean;

public class MaterialTypeBean {
	private String type_id;
	private String type_name;
	private String category_id;
	
	public MaterialTypeBean() {
		super();
	}

	public MaterialTypeBean(String type_id, String type_name, String category_id) {
		super();
		this.type_id = type_id;
		this.type_name = type_name;
		this.category_id = category_id;
	}

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "MaterialtypeBean [type_id=" + type_id + ", type_name=" + type_name + ", category_id=" + category_id + "]";
	}
}
