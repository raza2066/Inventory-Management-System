package com.raza.material.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.raza.material.bean.UnitBean;
import com.raza.material.service.UnitService;


@RestController
public class UnitController {
	@Autowired
	UnitService service;

	
	@GetMapping(path = "/material/controller/unitDetails",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UnitBean>> getUnit() {
		List<UnitBean> beans = service.getUnit();
		return new ResponseEntity<List<UnitBean>>(beans, HttpStatus.OK);
	}
	
	@GetMapping(path = "/material/controller/unitDetailsById/{category_id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UnitBean>> getUnitById(@PathVariable String category_id) {
		List<UnitBean> beans = service.getUnitById(category_id);
		return new ResponseEntity<List<UnitBean>>(beans, HttpStatus.OK);
	}
}
