package com.raza.material.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "unit")
public class UnitEntity {
	@Id
	private String unit_id;
	private String unit_name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private MaterialCategoryEntity materialCategoryEntity;
	
	public UnitEntity() {
		super();
	}

	public UnitEntity(String unit_id, String unit_name, MaterialCategoryEntity materialCategoryEntity) {
		super();
		this.unit_id = unit_id;
		this.unit_name = unit_name;
		this.materialCategoryEntity = materialCategoryEntity;
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

	public MaterialCategoryEntity getMaterialCategoryEntity() {
		return materialCategoryEntity;
	}

	public void setMaterialCategoryEntity(MaterialCategoryEntity materialCategoryEntity) {
		this.materialCategoryEntity = materialCategoryEntity;
	}

	@Override
	public String toString() {
		return "UnitEntity [unit_id=" + unit_id + ", unit_name=" + unit_name + ", materialCategoryEntity="
				+ materialCategoryEntity + "]";
	}
}
