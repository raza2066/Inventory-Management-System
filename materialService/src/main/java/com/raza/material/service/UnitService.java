package com.raza.material.service;

import java.util.List;

import com.raza.material.bean.UnitBean;

public interface UnitService {

	List<UnitBean> getUnit();
	List<UnitBean> getUnitById(String category_id);

}
