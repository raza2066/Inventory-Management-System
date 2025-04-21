package com.raza.inventory.business.bean;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;


@SuppressWarnings("deprecation")
public class VendorPurchaseReport {
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fromDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date toDate;
	@NotBlank
	private String vendor_name;
	public VendorPurchaseReport() {
		super(); 
	}
	
	public VendorPurchaseReport(Date fromDate,Date toDate,String vendor_name) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.vendor_name = vendor_name;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}	
	
	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	@Override
	public String toString() {
		return "DateWisePurchaseReportBean [fromDate=" + fromDate + ", toDate="
				+ toDate + "]  vendorName [" + vendor_name + "]";
	}



}