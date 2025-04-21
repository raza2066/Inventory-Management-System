package com.raza.vendor.bean;

public class VendorBean {
	private String vendor_id;
	private String vendor_name;
	private String vendor_address;
	private String contact_person;
	private String contact_number;
	
	public VendorBean() {
		super();
	}

	public VendorBean(String vendor_id, String vendor_name, String vendor_address, String contact_person,
			String contact_number) {
		super();
		this.vendor_id = vendor_id;
		this.vendor_name = vendor_name;
		this.vendor_address = vendor_address;
		this.contact_person = contact_person;
		this.contact_number = contact_number;
	}

	public String getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public String getVendor_address() {
		return vendor_address;
	}

	public void setVendor_address(String vendor_address) {
		this.vendor_address = vendor_address;
	}

	public String getContact_person() {
		return contact_person;
	}

	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	@Override
	public String toString() {
		return "VendorBean [vendor_id=" + vendor_id + ", vendor_name=" + vendor_name + ", vendor_address="
				+ vendor_address + ", contact_person=" + contact_person + ", contact_number=" + contact_number + "]";
	}	
}
