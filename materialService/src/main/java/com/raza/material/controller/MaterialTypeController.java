package com.raza.material.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.raza.material.bean.MaterialTypeBean;
import com.raza.material.service.MaterialTypeService;

@RestController
public class MaterialTypeController {
	@Autowired
	MaterialTypeService service;

	
	@GetMapping(path = "/material/controller/materialTypeDetails",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaterialTypeBean>> getMaterialType() {
		List<MaterialTypeBean> beans = service.getMaterialType();
		return new ResponseEntity<List<MaterialTypeBean>>(beans, HttpStatus.OK);
	}
	
	@GetMapping(path = "/material/controller/materialTypeDetailsById/{category_id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaterialTypeBean>> getMaterialTypeById(@PathVariable String category_id) {
		List<MaterialTypeBean> beans = service.getMaterialTypeById(category_id);
		return new ResponseEntity<List<MaterialTypeBean>>(beans, HttpStatus.OK);
	}
}
