package com.raza.material.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.raza.material.bean.MaterialCategoryBean;
import com.raza.material.service.MaterialCategoryService;

@RestController
public class MaterialCategoryController {
	
	@Autowired
	private MaterialCategoryService service;
	
	@GetMapping("/")
	public String home() {
		return "Welcome to the Material Services of IMS";
	}
	
	@GetMapping(path = "/material/controller/materialCategoryDetails",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaterialCategoryBean>> getMaterialCategory() {
		List<MaterialCategoryBean> beans= service.getMaterialCategory();
		return new ResponseEntity<List<MaterialCategoryBean>>(beans, HttpStatus.OK);
	}
	
	@GetMapping(path = "/material/controller/materialCategoryDetailsById/{category_id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MaterialCategoryBean> getMaterialCategory(@PathVariable String category_id) {
		MaterialCategoryBean bean= service.getMaterialCategoryById(category_id);
		return new ResponseEntity<MaterialCategoryBean>(bean, HttpStatus.OK);
	}
}
