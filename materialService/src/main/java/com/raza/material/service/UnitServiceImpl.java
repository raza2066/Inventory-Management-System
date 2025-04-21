package com.raza.material.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raza.material.bean.UnitBean;
import com.raza.material.dao.UnitDao;
import com.raza.material.entity.UnitEntity;

@Service
public class UnitServiceImpl implements UnitService{
	
	@Autowired
	UnitDao dao;

	@Override
	public List<UnitBean> getUnit() {
		List<UnitBean> beans = null;
		List<UnitEntity> entities= dao.findAll();
		if(entities!=null) {
			beans = new ArrayList<UnitBean>();
			UnitBean bean = null;
			for(UnitEntity entity:entities) {
				bean = new UnitBean();
				BeanUtils.copyProperties(entity, bean);
				bean.setCategory_id(entity.getMaterialCategoryEntity().getCategory_id());
				beans.add(bean);
			}
		}
		return beans;
	}

	@Override
	public List<UnitBean> getUnitById(String category_id) {
		List<UnitBean> beans = null;
		List<UnitEntity> entities= dao.findByCategory_id(category_id);
		if(entities!=null) {
			beans = new ArrayList<UnitBean>();
			UnitBean bean = null;
			for(UnitEntity entity:entities) {
				bean = new UnitBean();
				BeanUtils.copyProperties(entity, bean);
				bean.setCategory_id(entity.getMaterialCategoryEntity().getCategory_id());
				beans.add(bean);
			}
		}
		return beans;
	}

}
