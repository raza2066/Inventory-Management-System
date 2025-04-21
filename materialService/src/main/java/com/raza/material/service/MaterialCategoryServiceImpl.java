package com.raza.material.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raza.material.bean.MaterialCategoryBean;
import com.raza.material.dao.MaterialCategoryDAO;
import com.raza.material.entity.MaterialCategoryEntity;

@Service
public class MaterialCategoryServiceImpl implements MaterialCategoryService{
	
	@Autowired
	MaterialCategoryDAO dao;

	@Override
	public List<MaterialCategoryBean> getMaterialCategory() {
		List<MaterialCategoryBean> beans= null;
		List <MaterialCategoryEntity> entities = dao.findAll();
		if(entities!=null) {
			MaterialCategoryBean bean = null;
			beans = new ArrayList<MaterialCategoryBean>();
			for(MaterialCategoryEntity entity:entities) {
				bean = new MaterialCategoryBean();
				BeanUtils.copyProperties(entity, bean);
				beans.add(bean);
			}
		}
		
		return beans;
	}

	@Override
	public MaterialCategoryBean getMaterialCategoryById(String category_id) {
		MaterialCategoryBean bean = null;
		MaterialCategoryEntity entity = dao.findById(category_id).orElse(null);
		if(entity!=null) {
			bean = new MaterialCategoryBean();
			BeanUtils.copyProperties(entity, bean);
		}
		
		return bean;
	}

}
