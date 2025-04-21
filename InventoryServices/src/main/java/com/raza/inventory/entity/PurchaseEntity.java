package com.raza.inventory.entity;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



/*
 *Declare fields to set or get purchaseid, transactionId, vendor name,material category id,material type id,
 *brand name, unit id,quantity,purchase amount, purchase date and status.
 *Generate toString method. Add default and parameterized constructors.
 */
@SuppressWarnings("deprecation")
@Entity
@Table(name="purchase")
public class PurchaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer purchase_id;
	private String brandname;
	private String material_category_id;
	private String material_type_id;
	private Double purchase_amount;
	
	@Temporal(TemporalType.DATE)
	private Date purchase_date;
	private String quantity;
	private String status;
	private String transaction_id;
	private String unit_id;
	private String vendor_name;
	public Integer getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(Integer purchase_id) {
		this.purchase_id = purchase_id;
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
}
