package com.raza.material.service;

import java.util.List;

import com.raza.material.bean.MaterialTypeBean;

public interface MaterialTypeService {
	List<MaterialTypeBean> getMaterialType();
	List<MaterialTypeBean> getMaterialTypeById(String category_id);
}
