package com.raza.material.service;

import java.util.List;

import com.raza.material.bean.MaterialCategoryBean;

public interface MaterialCategoryService {

	List<MaterialCategoryBean> getMaterialCategory();

	MaterialCategoryBean getMaterialCategoryById(String category_id);

}
