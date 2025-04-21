package com.raza.material.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raza.material.bean.MaterialTypeBean;
import com.raza.material.dao.MaterialTypeDao;
import com.raza.material.entity.MaterialTypeEntity;

@Service
public class MaterialTypeServiceImpl implements MaterialTypeService{
	
	@Autowired
	MaterialTypeDao dao;

	@Override
	public List<MaterialTypeBean> getMaterialType() {
		List<MaterialTypeBean> beans = null;
		List<MaterialTypeEntity> entities= dao.findAll();
		if(entities!=null) {
			beans = new ArrayList<MaterialTypeBean>();
			MaterialTypeBean bean = null;
			for(MaterialTypeEntity entity:entities) {
				bean = new MaterialTypeBean();
				BeanUtils.copyProperties(entity, bean);
				bean.setCategory_id(entity.getMaterialCategoryEntity().getCategory_id());
				beans.add(bean);
			}
		}
		return beans;
	}

	@Override
	public List<MaterialTypeBean> getMaterialTypeById(String category_id) {
		List<MaterialTypeBean> beans = null;
		List<MaterialTypeEntity> entities= dao.findByCategory_id(category_id);
		if(entities!=null) {
			beans = new ArrayList<MaterialTypeBean>();
			MaterialTypeBean bean = null;
			for(MaterialTypeEntity entity:entities) {
				bean = new MaterialTypeBean();
				BeanUtils.copyProperties(entity, bean);
				bean.setCategory_id(entity.getMaterialCategoryEntity().getCategory_id());
				beans.add(bean);
			}
		}
		return beans;
	}
}
