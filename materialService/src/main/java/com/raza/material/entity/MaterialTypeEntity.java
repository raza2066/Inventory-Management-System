package com.raza.material.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "material_type")
public class MaterialTypeEntity {
	@Id
	private String type_id;
	private String type_name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private MaterialCategoryEntity materialCategoryEntity;
	
	public MaterialTypeEntity() {
		super();
	}

	public MaterialTypeEntity(String type_id, String type_name, MaterialCategoryEntity materialCategoryEntity) {
		super();
		this.type_id = type_id;
		this.type_name = type_name;
		this.materialCategoryEntity = materialCategoryEntity;
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

	public MaterialCategoryEntity getMaterialCategoryEntity() {
		return materialCategoryEntity;
	}

	public void setMaterialCategoryEntity(MaterialCategoryEntity materialCategoryEntity) {
		this.materialCategoryEntity = materialCategoryEntity;
	}

	@Override
	public String toString() {
		return "MaterialtypeEntity [type_id=" + type_id + ", type_name=" + type_name + ", materialCategoryEntity="
				+ materialCategoryEntity + "]";
	}
}
