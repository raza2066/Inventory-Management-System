package com.raza.inventory.business.bean;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;


@SuppressWarnings("deprecation")
public class PurchaseBean {
	
	@NotEmpty
	private String brandname;
	
	@NotEmpty
	private String material_category_id;

	private String materialCategoryNameString;
	
	@NotEmpty
	private String material_type_id;
	@NotNull
	private Double purchase_amount;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date purchase_date;
	
	@NotEmpty
	private String quantity;
	
	private String status;
	
	private String transaction_id;
	
	@NotEmpty
	private String unit_id;
	
	@NotEmpty
	private String vendor_name;
	
	private String materialTypeName;
	private String materialUnitName;
	@Override
	public String toString() {
		return "PurchaseBean [brandname=" + brandname + ", material_category_id=" + material_category_id
				+ ", materialCategoryNameString=" + materialCategoryNameString + ", material_type_id="
				+ material_type_id + ", purchase_amount=" + purchase_amount + ", purchase_date=" + purchase_date
				+ ", quantity=" + quantity + ", status=" + status + ", transaction_id=" + transaction_id + ", unit_id="
				+ unit_id + ", vendor_name=" + vendor_name + "]";
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public String getMaterial_category_id() {
		return material_category_id;
	}
	public void setMaterial_category_id(String material_category_id) {
		this.material_category_id = material_category_id;
	}
	public String getMaterial_type_id() {
		return material_type_id;
	}
	public void setMaterial_type_id(String material_type_id) {
		this.material_type_id = material_type_id;
	}
	public Double getPurchase_amount() {
		return purchase_amount;
	}
	public void setPurchase_amount(Double purchase_amount) {
		this.purchase_amount = purchase_amount;
	}
	public Date getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getUnit_id() {
		return unit_id;
	}
	public void setUnit_id(String unit_id) {
		this.unit_id = unit_id;
	}
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public String getMaterialCategoryNameString() {
		return materialCategoryNameString;
	}
	public void setMaterialCategoryNameString(String materialCategoryNameString) {
		this.materialCategoryNameString = materialCategoryNameString;
	}
	public String getMaterialTypeName() {
		return materialTypeName;
	}
	public void setMaterialTypeName(String materialTypeName) {
		this.materialTypeName = materialTypeName;
	}
	public String getMaterialUnitName() {
		return materialUnitName;
	}
	public void setMaterialUnitName(String materialUnitName) {
		this.materialUnitName = materialUnitName;
	}
	
}