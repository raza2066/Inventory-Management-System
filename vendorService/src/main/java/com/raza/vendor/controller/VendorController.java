package com.raza.vendor.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raza.vendor.bean.VendorBean;
import com.raza.vendor.service.VendorService;

@RestController
public class VendorController {
	
	@Autowired
	private VendorService service;
	
	@GetMapping("/")
	public String home() {
		return "Welcome to the Vendor Services of IMS";
	}
	
	@GetMapping("/vendor/controller/vendorDetails")
	public ResponseEntity<List<VendorBean>> getVendorDetails() {
		List<VendorBean> vendorList = service.getVendorDetails();
		return new ResponseEntity<List<VendorBean>>(vendorList,HttpStatus.OK);
	}
}
